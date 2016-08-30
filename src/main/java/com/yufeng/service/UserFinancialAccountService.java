package com.yufeng.service;

import java.util.List;

import com.yufeng.entity.UserFinancialAccountInfo;

/**
 * 用户金融业务处理层接口
 * @author dh
 */
public interface UserFinancialAccountService {
	
	//查询金融账户信息
	public List<UserFinancialAccountInfo> getUserFinancialAccountByCode(String internalCode);
	//查询金融账户信息
	public UserFinancialAccountInfo getUserFinancialAccountById(String uniqueId,String internalCode);
	//新建金融账户信息
	public String insertUserFinancialAccount(UserFinancialAccountInfo userFinancialAccountInfo);
	//金融账户信息修改
	public String updateUserFinancialAccount(UserFinancialAccountInfo userFinancialAccountInfo);
	//删除金融账户信息
	public String deleteUserFinancialAccount(UserFinancialAccountInfo userFinancialAccountInfo);
	

}
