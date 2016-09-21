package com.yufeng.service;

import com.yufeng.entity.ChinaUnionPayRequest;

/**
 * Created by fishyu on 16/9/20.
 */
public interface ChinaUnionPayService {
    
	public String queryPay(String orderId,String enterpriseNo,String merId,String txnTime) throws Exception;
	public String queryBalance(String enterpriseNo,String merId,String settType) throws Exception;
	public String requestPay(ChinaUnionPayRequest chinaUnionPayRequest) throws Exception;
	
}
