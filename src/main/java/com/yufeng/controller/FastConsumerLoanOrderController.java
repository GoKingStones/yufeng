package com.yufeng.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.yufeng.dto.FastConsumerLoanOrderDto;
import com.yufeng.dto.GetOrderInterestDto;
import com.yufeng.dto.ReturnCommodityDto;
import com.yufeng.util.OrderInterestUtil;
import com.yufeng.util.OrderStateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.yufeng.config.ResultStatus;
import com.yufeng.entity.FastConsumerLoanOrder;
import com.yufeng.entity.FastConsumerLoanOrderCommodity;
import com.yufeng.service.FastConsumerLoanOrderService;
import com.yufeng.util.ResultModel;

/**
 * 快速消费品分期订单控制层
 * @author dh
 */
@RestController
@RequestMapping("/FastConsumerLoanOrder")
public class FastConsumerLoanOrderController {
	@Autowired
	private FastConsumerLoanOrderService fastConsumerLoanOrderService;

	//通过订单获取总的利息，这个接口暂时保留
	@RequestMapping(value = "/getOrderInterest",method = RequestMethod.POST)
	public ResponseEntity<ResultModel> getRepaymentInterest(GetOrderInterestDto getOrderInterestDto) {


		BigDecimal interest= OrderInterestUtil.getInterest(getOrderInterestDto);

		return new ResponseEntity<ResultModel>(ResultModel.ok(interest),HttpStatus.OK);

	}

	//用户提交订单
	@RequestMapping(value = "/submitOrder",method = RequestMethod.POST)
	public ResponseEntity<ResultModel> submitOrder(String params) {

		//FastConsumerLoanOrderDto map= (FastConsumerLoanOrderDto) JSON.parse(params);

		//本金融平台内部审核如果审核不通过
		ResultModel resultModel=new ResultModel(300,"额度不够","");

		//中银消费审核如果审核没通过
		resultModel=new ResultModel(301,"用户身份存疑","");

		//金融平台和中银审核通过更新订单表和更新商品表,返回生成的订单号
		long orderId = fastConsumerLoanOrderService.insertFastConsumerLoanOrder(params);

		if(orderId==-1) {
			return new ResponseEntity<ResultModel>(new ResultModel(302,"提交失败",""),HttpStatus.OK);
		}else {
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("orderId",orderId);
			return new ResponseEntity<ResultModel>(ResultModel.ok(map),HttpStatus.OK);
		}

	}

	//取消订单
	@RequestMapping(value = "/cancelOrder",method = RequestMethod.GET)
	public ResponseEntity<ResultModel> cancelOrder(@RequestParam long orderId) {

		FastConsumerLoanOrder fastConsumerLoanOrder = fastConsumerLoanOrderService.getFastConsumerLoanOrder(orderId);
		if(fastConsumerLoanOrder==null) {
			return new ResponseEntity<ResultModel>(new ResultModel(310,"订单号不存在",""),HttpStatus.OK);
		}else {
			String orderState=fastConsumerLoanOrder.getOrderState();
			if(orderState.equals(OrderStateEnum.等待发货)) {
				boolean result = fastConsumerLoanOrderService.cancelFastConsumerLoanOrder(orderId);
				if (result) {
					return new ResponseEntity<ResultModel>(new ResultModel(311,"取消订单成功"),HttpStatus.OK);

				}else {
					return  new ResponseEntity<ResultModel>(new ResultModel(312,"取消订单失败"),HttpStatus.OK);
				}
			}else{
				return  new ResponseEntity<ResultModel>(new ResultModel(312,"无法取消"),HttpStatus.OK);
			}
		}
	}


	//全部退货即退整个订单
	@RequestMapping(value = "/returnOrder",method = RequestMethod.GET)
	public ResponseEntity<ResultModel> returnOrder(@RequestParam long orderId) {

		FastConsumerLoanOrder fastConsumerLoanOrder = fastConsumerLoanOrderService.getFastConsumerLoanOrder(orderId);
		if(fastConsumerLoanOrder==null) {
			return new ResponseEntity<ResultModel>(new ResultModel(310,"订单号不存在",""),HttpStatus.OK);
		}else {

			//对于整个订单的退货，订单已经产生利息，那么从额度中扣除一个月的利息
			//这样的话，给中银那边的利息是从发货到退货的时间，而平台获得的利息是剩余的价值
			return null;

		}
	}



	/**
	 * 订单部分退货时间，即订单中的部分商品申请退货
	 * @param params 输入参数orderId,shopIdList
	 * @return
	 */
	@RequestMapping(value = "/returnCommodity",method = RequestMethod.POST)
	public ResponseEntity<ResultModel> returnCommodity(@RequestBody String params) {

		ReturnCommodityDto returnCommodityDto=(ReturnCommodityDto)JSON.parse(params);
		FastConsumerLoanOrder fastConsumerLoanOrder = fastConsumerLoanOrderService.getFastConsumerLoanOrder(returnCommodityDto.getOrderId());
		if(fastConsumerLoanOrder==null) {
			return new ResponseEntity<ResultModel>(new ResultModel(310,"订单号不存在",""),HttpStatus.OK);
		}else {

			//修改订单分期表和商品分期表
			//对于订单部分商品的退货，订单已经产生利息，那么在分期列表中，所有期的本金是一样的，
			//只有第一期的利息比其他期多。
			return null;

		}
	}



	//更新订单状态
	@RequestMapping(value = "/updateOrderState",method = RequestMethod.POST)
	public ResponseEntity<ResultModel> updateOrderState(@RequestBody String orderInfo) {

		boolean result = fastConsumerLoanOrderService.updateFastConsumerLoanOrder(orderInfo);

		if (result) {
			return new ResponseEntity<ResultModel>(new ResultModel(320,"修改订单状态成功"),HttpStatus.OK);
		}else {
			return new ResponseEntity<ResultModel>(new ResultModel(321,"修改订单状态失败"),HttpStatus.OK);
		}
	}

	//查询订单状态
	@RequestMapping(value = "/queryOrderState",method = RequestMethod.GET)
	public ResponseEntity<ResultModel> queryOrderState(@RequestParam long orderId) {


		FastConsumerLoanOrder fastConsumerLoanOrder = fastConsumerLoanOrderService.getFastConsumerLoanOrder(orderId);

		if (fastConsumerLoanOrder!=null) {
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("orderId",orderId);
			map.put("orderState",fastConsumerLoanOrder.getOrderState());
			return new ResponseEntity<ResultModel>(new ResultModel(330,"查询订单状态成功",map),HttpStatus.OK);
		}else {
			return new ResponseEntity<ResultModel>(new ResultModel(331,"查询订单状态失败"),HttpStatus.OK);
		}
	}














//	//查询订单信息(code)
//	@RequestMapping("/getFastConsumerLoanOrder")
//	public Map<String,Object> getFastConsumerLoanOrder(String orderId){
//		return fastConsumerLoanOrderService.getFastConsumerLoanOrder(orderId);
//	}
//
//	//新建订单信息(接收json)
//	@RequestMapping("/insertFastConsumerLoanOrder")
//	public ResponseEntity<ResultModel> insertFastConsumerLoanOrder(@RequestBody String order){
//		String type=fastConsumerLoanOrderService.insertFastConsumerLoanOrder(order);
//		if("1".equals(type)){
//            return new ResponseEntity<ResultModel>(ResultModel.ok(),HttpStatus.OK);
//        }else{//操作失败
//            return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
//        }
//	}
//
//	//订单订单修改(接收json)
//	@RequestMapping("/updateFastConsumerLoanOrder")
//	public ResponseEntity<ResultModel> updateFastConsumerLoanOrder(@RequestBody String order){
//		String type=fastConsumerLoanOrderService.updateFastConsumerLoanOrder(order);
//		if("1".equals(type)){
//            return new ResponseEntity<ResultModel>(ResultModel.ok(),HttpStatus.OK);
//        }else{//操作失败
//            return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
//        }
//	}
		

}
