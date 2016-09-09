package com.yufeng.dao;

import java.util.List;

import com.yufeng.entity.FastConsumerLoanOrder;
import com.yufeng.entity.FastConsumerLoanOrderCommodity;


/**
 * 快速消费品分期订单业务dao层
 * @author dh
 */
public interface FastConsumerLoanOrderDao {


	//取消订单
	public int cancelConsumerLoanOrder(long orderId);

	//查询分期订单详细
	public FastConsumerLoanOrder getFastConsumerLoanOrderById(long id);
	public FastConsumerLoanOrder getFastConsumerLoanOrderByOrderId(String orderId);
	//新增分期订单详细
	public int insertFastConsumerLoanOrder(FastConsumerLoanOrder fastConsumerLoanOrder);
	//修改分期订单详细
	public int updateFastConsumerLoanOrder(FastConsumerLoanOrder fastConsumerLoanOrder);
	
	//查询商品详细
	public FastConsumerLoanOrderCommodity getFastConsumerLoanOrderCommodityById(String uniqueId);
	//查询商品详细
	public List<FastConsumerLoanOrderCommodity> getFastConsumerLoanOrderCommodityByOrderId(String orderId);
	//新增商品详细
	public int insertFastConsumerLoanOrderCommodity(FastConsumerLoanOrderCommodity fastConsumerLoanOrderCommodity);
	//修改商品详细
	public int updateFastConsumerLoanOrderCommodity(FastConsumerLoanOrderCommodity fastConsumerLoanOrderCommodity);

	//取消商品
	public int cancelFastConsumerLoanOrderCommodity(String uniqueId);

}
