package com.yufeng.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yufeng.entity.FastConsumerLoanOrder;
import com.yufeng.entity.FastConsumerLoanOrderCommodity;
import com.yufeng.service.FastConsumerLoanOrderService;

/**
 * 快速消费品分期订单控制层
 * @author dh
 */
@RestController
@RequestMapping("/FastConsumerLoanOrder")
public class FastConsumerLoanOrderController {
	@Autowired
	private FastConsumerLoanOrderService fastConsumerLoanOrderService;
	
	//查询银行卡信息(code)
	@RequestMapping("/getFastConsumerLoanOrder")
	public Map<String,Object> getFastConsumerLoanOrder(String order_id){
		return fastConsumerLoanOrderService.getFastConsumerLoanOrder(order_id);
	   }
		
	//新建银行卡信息
	@RequestMapping("/insertFastConsumerLoanOrder")
	public String insertFastConsumerLoanOrder(String json){
		return fastConsumerLoanOrderService.insertFastConsumerLoanOrder(json);
	}
		
	//银行卡信息修改
	@RequestMapping("/updateFastConsumerLoanOrder")
	public String updateFastConsumerLoanOrder(String json){
		return fastConsumerLoanOrderService.updateFastConsumerLoanOrder(json);
	}
		

}
