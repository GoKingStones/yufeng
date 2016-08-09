package com.yufeng.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
	
	//查询订单详细
	public Map<String,Object> getFastConsumerLoanOrder(String order_id){
		Map<String,Object> map=new HashMap<String, Object>();
		//查询订单
		FastConsumerLoanOrder order_info=fastConsumerLoanOrderDao.getFastConsumerLoanOrderByOrderId(order_id);
		if(order_info==null)return null;
		//查询商品
		List<FastConsumerLoanOrderCommodity> consumer_info_list=fastConsumerLoanOrderDao.getFastConsumerLoanOrderCommodityByOrderId(order_info.getId());
		map.put("loanOrder", order_info);
		map.put("loanOrderConsumer", consumer_info_list);
		return map;
	}
	
	//新建订单详细
	public String insertFastConsumerLoanOrder(String json){
		try {
			Date date = new Date();
			// 新建分期订单id
			String order_id = UUID.randomUUID().toString();
			// 获取单个订单与多个商品的json
			JSONObject obj = JSON.parseObject(json);
			String order = obj.getString("order");
			String commodityList = obj.getString("commodityList");
			// 订单
			FastConsumerLoanOrder loanOrder = JSON.parseObject(order, FastConsumerLoanOrder.class);
			loanOrder.setId(order_id);
			loanOrder.setFound_time(date);
			// 储存订单
			fastConsumerLoanOrderDao.insertFastConsumerLoanOrder(loanOrder);
			// 商品
			List<String> arry = JSON.parseArray(commodityList, String.class);
			for (String str : arry) {
				// 储存商品
				FastConsumerLoanOrderCommodity commodity = JSON.parseObject(str, FastConsumerLoanOrderCommodity.class);
				commodity.setOrder_id(order_id);
				commodity.setId(UUID.randomUUID().toString());
				commodity.setFound_time(date);
				fastConsumerLoanOrderDao.insertFastConsumerLoanOrderCommodity(commodity);
			}
			return "1";
		} catch (Exception e) {
			return "0"; 
		}
	}
	
	//修改订单
	public String updateFastConsumerLoanOrder(String json){
		try {
			Date date = new Date();
			// 新建分期订单id
			// 获取单个订单与多个商品的json
			JSONObject obj = JSON.parseObject(json);
			String order = obj.getString("order");
			String commodityList = obj.getString("commodityList");
			// 订单
			if(order!=null&&(!"".equals(order))){
				FastConsumerLoanOrder loanOrder = JSON.parseObject(order, FastConsumerLoanOrder.class);
				loanOrder.setUpdate_time(date);
				// 修改订单(先查出原值)
				FastConsumerLoanOrder oldObj=fastConsumerLoanOrderDao.getFastConsumerLoanOrderById(loanOrder.getId());
				fastConsumerLoanOrderDao.updateFastConsumerLoanOrder(loanOrder);
			}
			// 商品
			if(commodityList!=null&&(!"".equals(commodityList))){
				List<String> arry = JSON.parseArray(commodityList, String.class);
				for (String str : arry) {
					// 储存商品
					FastConsumerLoanOrderCommodity commodity = JSON.parseObject(str, FastConsumerLoanOrderCommodity.class);
					commodity.setUpdate_time(date);
					fastConsumerLoanOrderDao.updateFastConsumerLoanOrderCommodity(commodity);
				}
			}
			
			return "1";
		} catch (Exception e) {
			return "0"; 
		}
	}

}
