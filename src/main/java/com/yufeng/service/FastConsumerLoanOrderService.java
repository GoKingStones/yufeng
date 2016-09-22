package com.yufeng.service;

import com.alibaba.fastjson.JSON;
import com.yufeng.dto.GetOrderInterestDto;
import com.yufeng.dto.OrderStateDto;
import com.yufeng.dto.ReturnCommodityDto;
import com.yufeng.entity.FastConsumerLoanOrder;
import com.yufeng.util.OrderInterestUtil;
import com.yufeng.util.OrderStateEnum;
import com.yufeng.util.ResultModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 快速消费品分期订单业务处理层接口
 * @author dh
 */
public interface FastConsumerLoanOrderService {

	//通过订单获取总的利息，这个接口暂时保留
	public ResponseEntity<ResultModel> getRepaymentInterest(GetOrderInterestDto getOrderInterestDto);

	//用户提交订单
	public ResponseEntity<ResultModel> submitOrder(String params);
	//取消订单
	public ResponseEntity<ResultModel> cancelOrder(long orderId);

	//全部退货即退整个订单
	//对于整个订单的退货，订单已经产生利息，那么从额度中扣除一个月的利息
	//这样的话，给中银那边的利息是从发货到退货的时间，而平台获得的利息是剩余的价值

	public ResponseEntity<ResultModel> returnOrder(long orderId);
	/**
	 * 订单部分退货时间，即订单中的部分商品申请退货
	 * //修改订单分期表和商品分期表
	 //对于订单部分商品的退货，订单已经产生利息，那么在分期列表中，所有期的本金是一样的，
	 //只有第一期的利息比其他期多。
	 * @param params 输入参数orderId,shopIdList
	 * @return
	 */
	public ResponseEntity<ResultModel> returnCommodity(String params);



	//更新订单状态
	public ResponseEntity<ResultModel> updateOrderState(String orderStateInfo);

	//查询订单状态
	public ResponseEntity<ResultModel> queryOrderState(long orderId);
	

}
