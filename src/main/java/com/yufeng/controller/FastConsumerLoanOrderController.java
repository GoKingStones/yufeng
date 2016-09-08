package com.yufeng.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yufeng.config.ResultStatus;
import com.yufeng.entity.FastConsumerLoanOrder;
import com.yufeng.entity.FastConsumerLoanOrderCommodity;
import com.yufeng.service.FastConsumerLoanOrderService;
import com.yufeng.util.ResultModel;
import com.yufeng.util.Utils;

/**
 * 快速消费品分期订单控制层
 * @author dh
 */
@RestController
@RequestMapping("/FastConsumerLoanOrder")
public class FastConsumerLoanOrderController {
	@Autowired
	private FastConsumerLoanOrderService fastConsumerLoanOrderService;
	
	//查询订单信息(code)
	@RequestMapping("/getFastConsumerLoanOrder")
	public Map<String,Object> getFastConsumerLoanOrder(String orderId){
		return fastConsumerLoanOrderService.getFastConsumerLoanOrder(orderId);
	}
		
	//新建订单信息(接收json)
	@RequestMapping("/insertFastConsumerLoanOrder")
	public ResponseEntity<ResultModel> insertFastConsumerLoanOrder(@RequestBody String order){
		String type=fastConsumerLoanOrderService.insertFastConsumerLoanOrder(order);
		if(Utils.RETURN_VALUE_CODE_1.equals(type)){
            return new ResponseEntity<ResultModel>(ResultModel.ok(),HttpStatus.OK);
        }else{//操作失败
            return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
        }
	}
		
	//订单订单修改(接收json)
	@RequestMapping("/updateFastConsumerLoanOrder")
	public ResponseEntity<ResultModel> updateFastConsumerLoanOrder(@RequestBody String order){
		String type=fastConsumerLoanOrderService.updateFastConsumerLoanOrder(order);
		if(Utils.RETURN_VALUE_CODE_1.equals(type)){
            return new ResponseEntity<ResultModel>(ResultModel.ok(),HttpStatus.OK);
        }else{//操作失败
            return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
        }
	}
		

}
