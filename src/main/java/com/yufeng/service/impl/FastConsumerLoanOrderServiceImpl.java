package com.yufeng.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.yufeng.algorithm.OrderIdGenerator;
import com.yufeng.dto.FastConsumerLoanOrderDto;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yufeng.dao.FastConsumerLoanOrderDao;
import com.yufeng.entity.FastConsumerLoanOrder;
import com.yufeng.entity.FastConsumerLoanOrderCommodity;
import com.yufeng.service.FastConsumerLoanOrderService;

/**
 * 快速消费品分期订单业务处理层
 * @author dh
 */
public class FastConsumerLoanOrderServiceImpl implements FastConsumerLoanOrderService{
	@Autowired
	private FastConsumerLoanOrderDao fastConsumerLoanOrderDao;

	public FastConsumerLoanOrder getFastConsumerLoanOrder(long orderId) {
		return null;
	}

	public long insertFastConsumerLoanOrder(String json) {

		long result = -1;
		try {
			FastConsumerLoanOrderDto fastConsumerLoanOrderDto=(FastConsumerLoanOrderDto)JSON.parse(json);

			long orderId = OrderIdGenerator.getIncrementOrderId();
			FastConsumerLoanOrder fastConsumerLoanOrder=fastConsumerLoanOrderDto.getFastConsumerLoanOrder();
			fastConsumerLoanOrder.setOrderId(orderId);
			fastConsumerLoanOrderDao.insertFastConsumerLoanOrder(fastConsumerLoanOrder);
			for(FastConsumerLoanOrderCommodity fastConsumerLoanOrderCommodity:fastConsumerLoanOrderDto.getFastConsumerLoanOrderCommodities()) {
				fastConsumerLoanOrderDao.insertFastConsumerLoanOrderCommodity(fastConsumerLoanOrderCommodity);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			return result;
		}
	}

	public boolean cancelFastConsumerLoanOrder(long orderId) {
		return false;
	}

	public boolean updateFastConsumerLoanOrder(String json) {
		return false;
	}

//	//查询订单详细
//	public Map<String,Object> getFastConsumerLoanOrder(String orderId){
//		Map<String,Object> map=new HashMap<String, Object>();
//		//查询订单
//		FastConsumerLoanOrder orderInfo=fastConsumerLoanOrderDao.getFastConsumerLoanOrderByOrderId(orderId);
//		if(orderInfo==null)return null;
//		//查询商品
//		List<FastConsumerLoanOrderCommodity> consumerInfoList=fastConsumerLoanOrderDao.getFastConsumerLoanOrderCommodityByOrderId(orderInfo.getUniqueId());
//		map.put("loanOrder", orderInfo);
//		map.put("loanOrderConsumerList", consumerInfoList);
//		return map;
//	}
//
//	//新建订单详细
//	public String insertFastConsumerLoanOrder(String json){
////		try {
////			Date date = new Date();
////			// 新建分期订单id
////			String orderId = UUID.randomUUID().toString();
////			// 获取单个订单与多个商品的json
////			JSONObject obj = JSON.parseObject(json);
////			String order = obj.getString("loanOrder");
////			String commodityList = obj.getString("loanOrderConsumerList");
////			// 订单
////			FastConsumerLoanOrder loanOrder = JSON.parseObject(order, FastConsumerLoanOrder.class);
////			loanOrder.setUniqueId(orderId);
////			loanOrder.setCreateTime(date);
////			// 储存订单
////			fastConsumerLoanOrderDao.insertFastConsumerLoanOrder(loanOrder);
////			// 商品
////			List<String> arry = JSON.parseArray(commodityList, String.class);
////			for (String str : arry) {
////				// 储存商品
////				FastConsumerLoanOrderCommodity commodity = JSON.parseObject(str, FastConsumerLoanOrderCommodity.class);
////				commodity.setOrderId(orderId);
////				commodity.setUniqueId(UUID.randomUUID().toString());
////				commodity.setCreateTime(date);
////				fastConsumerLoanOrderDao.insertFastConsumerLoanOrderCommodity(commodity);
////			}
////			return "1";
////		} catch (Exception e) {
////			return "0";
////		}
//		return  null;
//	}
//
//	//修改订单
//	public String updateFastConsumerLoanOrder(String json){
//		try {
//			Date date = new Date();
//			// 新建分期订单id
//			// 获取单个订单与多个商品的json
//			JSONObject obj = JSON.parseObject(json);
//			String order = obj.getString("loanOrder");
//			String commodityList = obj.getString("loanOrderConsumerList");
//			// 订单
//			if(order!=null&&(!"".equals(order))){
//				FastConsumerLoanOrder loanOrder = JSON.parseObject(order, FastConsumerLoanOrder.class);
//				loanOrder.setModTime(date);
//				// 修改订单(先查出原值)
//				//FastConsumerLoanOrder oldObj=fastConsumerLoanOrderDao.getFastConsumerLoanOrderById(loanOrder.getId());
//				fastConsumerLoanOrderDao.updateFastConsumerLoanOrder(loanOrder);
//				//存入历史
//			}
//			// 商品
//			if(commodityList!=null&&(!"".equals(commodityList))){
//				List<String> arry = JSON.parseArray(commodityList, String.class);
//				for (String str : arry) {
//					// 储存商品
//					FastConsumerLoanOrderCommodity commodity = JSON.parseObject(str, FastConsumerLoanOrderCommodity.class);
//					commodity.setModTime(date);
//					fastConsumerLoanOrderDao.updateFastConsumerLoanOrderCommodity(commodity);
//				}
//			}
//
//			return "1";
//		} catch (Exception e) {
//			return "0";
//		}
//	}

}
