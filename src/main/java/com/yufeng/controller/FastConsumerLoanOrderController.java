package com.yufeng.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.yufeng.dto.FastConsumerLoanOrderDto;
import com.yufeng.dto.GetOrderInterestDto;
import com.yufeng.dto.OrderStateDto;
import com.yufeng.dto.ReturnCommodityDto;
import com.yufeng.util.OrderInterestUtil;
import com.yufeng.util.OrderStateEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("fastConsumerLoanOrder")
public class FastConsumerLoanOrderController {

	private static  Logger logger= LoggerFactory.getLogger(FastConsumerLoanOrderController.class);
	@Autowired
	private FastConsumerLoanOrderService fastConsumerLoanOrderService;

	//通过订单获取总的利息，这个接口暂时保留
	@RequestMapping(value = "/getOrderInterest",method = RequestMethod.POST)
	public ResponseEntity<ResultModel> getRepaymentInterest(@RequestBody GetOrderInterestDto getOrderInterestDto) {

		logger.debug(getOrderInterestDto.toString());
		return fastConsumerLoanOrderService.getRepaymentInterest(getOrderInterestDto);
	}

	//用户提交订单
	@RequestMapping(value = "/submitOrder",method = RequestMethod.POST)
	public ResponseEntity<ResultModel> submitOrder(@RequestBody String json) {

		logger.debug(json);
		return fastConsumerLoanOrderService.submitOrder(json);
	}

	//取消订单
	@RequestMapping(value = "/cancelOrder",method = RequestMethod.GET)
	public ResponseEntity<ResultModel> cancelOrder(@RequestParam long orderId) {
		logger.debug(""+orderId);
		return fastConsumerLoanOrderService.cancelOrder(orderId);
	}


	//全部退货即退整个订单
	//对于整个订单的退货，订单已经产生利息，那么从额度中扣除一个月的利息
	//这样的话，给中银那边的利息是从发货到退货的时间，而平台获得的利息是剩余的价值

	@RequestMapping(value = "/returnOrder",method = RequestMethod.GET)
	public ResponseEntity<ResultModel> returnOrder(@RequestParam long orderId) {
		logger.debug(""+orderId);
		return fastConsumerLoanOrderService.returnOrder(orderId);
	}

	/**
	 * 订单部分退货时间，即订单中的部分商品申请退货
	 * //修改订单分期表和商品分期表
	 //对于订单部分商品的退货，订单已经产生利息，那么在分期列表中，所有期的本金是一样的，
	 //只有第一期的利息比其他期多。
	 * @param json 输入参数orderId,shopIdList
	 * @return
	 */
	@RequestMapping(value = "/returnCommodity",method = RequestMethod.POST)
	public ResponseEntity<ResultModel> returnCommodity(@RequestBody String json) {
		logger.debug(json);
		return fastConsumerLoanOrderService.returnCommodity(json);
	}



	//更新订单状态
	@RequestMapping(value = "/updateOrderState",method = RequestMethod.POST)
	public ResponseEntity<ResultModel> updateOrderState(@RequestBody String json) {
		logger.debug(json);
		return fastConsumerLoanOrderService.updateOrderState(json);
	}

	//查询订单状态
	@RequestMapping(value = "/queryOrderState",method = RequestMethod.GET)
	public ResponseEntity<ResultModel> queryOrderState(@RequestParam long orderId) {

		logger.debug(""+orderId);
		return fastConsumerLoanOrderService.queryOrderState(orderId);
	}

}
