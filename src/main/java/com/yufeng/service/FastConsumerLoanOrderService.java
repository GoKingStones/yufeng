package com.yufeng.service;

import com.yufeng.entity.FastConsumerLoanOrder;

import java.util.Map;

/**
 * 快速消费品分期订单业务处理层接口
 * @author dh
 */
public interface FastConsumerLoanOrderService {
	
	//查询订单详细
	public FastConsumerLoanOrder getFastConsumerLoanOrder(long orderId);
	//新建订单详细
	public long insertFastConsumerLoanOrder(String json);
	//取消订单
	public boolean cancelFastConsumerLoanOrder(long orderId);
	//修改订单
	public boolean updateFastConsumerLoanOrder(String json);
	

}
