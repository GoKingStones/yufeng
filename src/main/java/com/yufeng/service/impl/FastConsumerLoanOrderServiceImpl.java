package com.yufeng.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import com.yufeng.algorithm.OrderIdGenerator;
import com.yufeng.dto.FastConsumerLoanOrderDto;
import com.yufeng.dto.GetOrderInterestDto;
import com.yufeng.dto.OrderStateDto;
import com.yufeng.dto.ReturnCommodityDto;
import com.yufeng.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yufeng.dao.FastConsumerLoanOrderDao;
import com.yufeng.entity.FastConsumerLoanOrder;
import com.yufeng.entity.FastConsumerLoanOrderCommodity;
import com.yufeng.service.FastConsumerLoanOrderService;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 快速消费品分期订单业务处理层
 * @author dh
 */
public class FastConsumerLoanOrderServiceImpl implements FastConsumerLoanOrderService{

	private static Logger logger= LoggerFactory.getLogger(FastConsumerLoanOrderServiceImpl.class);
	@Autowired
	private FastConsumerLoanOrderDao fastConsumerLoanOrderDao;

	//通过订单获取总的利息，这个接口暂时保留
	public ResponseEntity<ResultModel> getRepaymentInterest(GetOrderInterestDto getOrderInterestDto) {


		BigDecimal interest= OrderInterestUtil.getInterest(getOrderInterestDto);

		return new ResponseEntity<ResultModel>(ResultModel.ok(interest), HttpStatus.OK);

	}

	//用户提交订单
	public ResponseEntity<ResultModel> submitOrder(String params) {

		ResultModel resultModel=null;
		try {

			FastConsumerLoanOrderDto map= JSON.parseObject(params,FastConsumerLoanOrderDto.class);
			logger.debug(map.toString());
			//本金融平台内部审核如果审核不通过
			//resultModel=new ResultModel(300,"额度不够","");

			//中银消费审核如果审核没通过
			//resultModel=new ResultModel(301,"用户身份存疑","");
			//金融平台和中银审核通过更新订单表和更新商品表,返回生成的订单号
			FastConsumerLoanOrder fastConsumerLoanOrder=map.getFastConsumerLoanOrder();
			fastConsumerLoanOrder.setOrderState(OrderStateEnum.已支付.name());
			fastConsumerLoanOrder.setSubmitTime(new Date());
			long orderResult = fastConsumerLoanOrderDao.insertFastConsumerLoanOrder(fastConsumerLoanOrder);
			long commodityResult;
			List<FastConsumerLoanOrderCommodity> lists=map.getFastConsumerLoanOrderCommodities();
			for(int i=0;i<lists.size();i++) {
				lists.get(i).setOrderId(fastConsumerLoanOrder.getOrderId());
			}
			commodityResult = fastConsumerLoanOrderDao.insertFastConsumerLoanOrderCommodityList(lists);

			if(orderResult!=1&&commodityResult!=lists.size()) {
				resultModel = new ResultModel(302,"提交失败","");
			}else {
				Map<String,Object> result=new HashMap<String, Object>();
				result.put("orderId",fastConsumerLoanOrder.getOrderId());
				resultModel = ResultModel.ok(result);
			}

		}catch (Exception e) {
			logger.error(e.getMessage());
			resultModel=new ResultModel(-300,"传入参数错误");
		}finally {
			return new ResponseEntity<ResultModel>(resultModel,HttpStatus.OK);
		}

	}

	//取消订单
	public ResponseEntity<ResultModel> cancelOrder(long orderId) {

		FastConsumerLoanOrder fastConsumerLoanOrder = fastConsumerLoanOrderDao.getFastConsumerLoanOrderByOrderId(orderId);
		if(fastConsumerLoanOrder==null) {
			return new ResponseEntity<ResultModel>(new ResultModel(310,"订单号不存在",""),HttpStatus.OK);
		}else {
			String orderState=fastConsumerLoanOrder.getOrderState();
			if(orderState.equals(OrderStateEnum.等待发货.name())||orderState.equals(OrderStateEnum.已支付.name())) {
				fastConsumerLoanOrder.setOrderState(OrderStateEnum.已取消.name());
				fastConsumerLoanOrder.setCancelTime(new Date());
				int result = fastConsumerLoanOrderDao.updateFastConsumerLoanOrder(fastConsumerLoanOrder);
				if (result==1) {
					return new ResponseEntity<ResultModel>(new ResultModel(311,"取消订单成功"),HttpStatus.OK);

				}else {
					return  new ResponseEntity<ResultModel>(new ResultModel(312,"取消订单失败"),HttpStatus.OK);
				}
			}else{
				return  new ResponseEntity<ResultModel>(new ResultModel(313,"无法取消"),HttpStatus.OK);
			}
		}
	}


	//全部退货即退整个订单
	//对于整个订单的退货，订单已经产生利息，那么从额度中扣除一个月的利息
	//这样的话，给中银那边的利息是从发货到退货的时间，而平台获得的利息是剩余的价值

	public ResponseEntity<ResultModel> returnOrder(long orderId) {

		FastConsumerLoanOrder fastConsumerLoanOrder = fastConsumerLoanOrderDao.getFastConsumerLoanOrderByOrderId(orderId);
		if(fastConsumerLoanOrder==null) {
			return new ResponseEntity<ResultModel>(new ResultModel(310,"订单号不存在",""),HttpStatus.OK);
		}else {

			fastConsumerLoanOrder.setOrderState(OrderStateEnum.所有退货.name());
			fastConsumerLoanOrder.setReturnOrderTime(new Date());
			int result = fastConsumerLoanOrderDao.updateFastConsumerLoanOrder(fastConsumerLoanOrder);

			List<FastConsumerLoanOrderCommodity> fastConsumerLoanOrderCommodities=fastConsumerLoanOrderDao.getFastConsumerLoanOrderCommodityByOrderId(orderId);
			int commodityResult=-1;
			for (FastConsumerLoanOrderCommodity fastConsumerLoanOrderCommodity:fastConsumerLoanOrderCommodities) {

				fastConsumerLoanOrderCommodity.setCommodityState(OrderCommodityStateEnum.已退货.name());
				commodityResult=fastConsumerLoanOrderDao.updateFastConsumerLoanOrderCommodity(fastConsumerLoanOrderCommodity);
				if(commodityResult!=1) {
					return new ResponseEntity<ResultModel>(new ResultModel(341,"订单退货失败"),HttpStatus.OK);
				}


			}
			if(result==1&&commodityResult==1) {
				Map<String,String> map=new HashMap<String, String>();
				map.put("interest","111.11");
				return new ResponseEntity<ResultModel>(new ResultModel(340,"订单退货成功",map),HttpStatus.OK);
			}else {
				return new ResponseEntity<ResultModel>(new ResultModel(341,"订单退货失败"),HttpStatus.OK);

			}

		}
	}

	/**
	 * 订单部分退货时间，即订单中的部分商品申请退货
	 * //修改订单分期表和商品分期表
	 //对于订单部分商品的退货，订单已经产生利息，那么在分期列表中，所有期的本金是一样的，
	 //只有第一期的利息比其他期多。
	 * @param params 输入参数orderId,shopIdList
	 * @return
	 */
	public ResponseEntity<ResultModel> returnCommodity(String params) {

		ResultModel resultModel=null;

		try {
			ReturnCommodityDto returnCommodityDto=JSON.parseObject(params,ReturnCommodityDto.class);
			FastConsumerLoanOrder fastConsumerLoanOrder = fastConsumerLoanOrderDao.getFastConsumerLoanOrderByOrderId(returnCommodityDto.getOrderId());
			if(fastConsumerLoanOrder==null) {

				resultModel = new ResultModel(310,"订单号不存在","");
			}else {
				fastConsumerLoanOrder.setOrderState(OrderStateEnum.部分退货.name());
				fastConsumerLoanOrder.setReturnCommodityTime(new Date());
				int result = fastConsumerLoanOrderDao.updateFastConsumerLoanOrder(fastConsumerLoanOrder);

				if(result!=1) {
					resultModel = new ResultModel(351,"订单退货失败");
				}
				List<FastConsumerLoanOrderCommodity> fastConsumerLoanOrderCommodities=fastConsumerLoanOrderDao.getFastConsumerLoanOrderCommodityByOrderId(returnCommodityDto.getOrderId());
				int commodityResult=-1;
				for (FastConsumerLoanOrderCommodity fastConsumerLoanOrderCommodity:fastConsumerLoanOrderCommodities) {
					for(String commodityId:returnCommodityDto.getCommodityIdList()) {
						if(commodityId.equals(fastConsumerLoanOrderCommodity.getUniqueId())) {
							fastConsumerLoanOrderCommodity.setCommodityState(OrderCommodityStateEnum.已退货.name());
							commodityResult=fastConsumerLoanOrderDao.updateFastConsumerLoanOrderCommodity(fastConsumerLoanOrderCommodity);
							if(commodityResult!=1) {
								resultModel = new ResultModel(351,"订单退货失败");
							}
						}
					}
				}

				if(result==1&&commodityResult==1) {
					Map<String,String> map=new HashMap<String, String>();
					map.put("interest","111.11");
					resultModel = new  ResultModel(350,"订单退货成功",map);
				}else {
					resultModel = new  ResultModel(351,"订单退货失败");

				}

			}
		}catch (Exception e) {
			logger.error(e.getMessage());
			resultModel=new ResultModel(-300,"传入参数错误");
		}finally {
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.OK);
		}
	}

	//更新订单状态
	public ResponseEntity<ResultModel> updateOrderState(String orderStateInfo) {

		ResultModel resultModel=null;

		try{
			OrderStateDto orderStateDto=JSON.parseObject(orderStateInfo, OrderStateDto.class);
			long orderId=orderStateDto.getOrderId();
			String orderState=orderStateDto.getOrderState();
			FastConsumerLoanOrder fastConsumerLoanOrder=fastConsumerLoanOrderDao.getFastConsumerLoanOrderByOrderId(orderId);
			if(fastConsumerLoanOrder==null) {
				resultModel =new ResultModel(310,"订单号不存在","");
			}

			if(orderState.equals(OrderStateEnum.已发货.name())) {

				//去向中银请款
				fastConsumerLoanOrder.setOrderState(OrderStateEnum.已发货.name());
				fastConsumerLoanOrder.setSendTime(new Date());
				int result=fastConsumerLoanOrderDao.insertFastConsumerLoanOrder(fastConsumerLoanOrder);
				if (result==1) {
					resultModel  =new ResultModel(320,"修改订单状态成功");
				}else {
					resultModel = new ResultModel(321,"修改订单状态失败");
				}
			}else {
				resultModel =ResultModel.ok();
			}
		}catch (Exception e) {
			logger.error(e.getMessage());
			resultModel=new ResultModel(-300,"传入参数错误");
		}finally {
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.OK);
		}
	}

	//查询订单状态
	public ResponseEntity<ResultModel> queryOrderState(long orderId) {

		FastConsumerLoanOrder fastConsumerLoanOrder = fastConsumerLoanOrderDao.getFastConsumerLoanOrderByOrderId(orderId);
		if (fastConsumerLoanOrder!=null) {
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("orderId",orderId);
			map.put("orderState",fastConsumerLoanOrder.getOrderState());
			return new ResponseEntity<ResultModel>(new ResultModel(330,"查询订单状态成功",map),HttpStatus.OK);
		}else {
			return new ResponseEntity<ResultModel>(new ResultModel(310,"订单不存在"),HttpStatus.OK);
		}
	}

}
