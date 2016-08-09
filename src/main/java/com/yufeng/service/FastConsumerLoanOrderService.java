package com.yufeng.service;

import java.util.Map;

/**
 * 快速消费品分期订单业务处理层接口
 * @author dh
 */
public interface FastConsumerLoanOrderService {
	
	//查询订单详细
	public Map<String,Object> getFastConsumerLoanOrder(String order_id);
	//新建订单详细
	public String insertFastConsumerLoanOrder(String json);
	//修改订单
	public String updateFastConsumerLoanOrder(String json);
	

}
