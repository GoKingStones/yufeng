package com.yufeng.dao;

import java.util.List;

import com.yufeng.entity.UserFinancialAccountInfo;

/**
 * @author dh
 * 用户金融账户信息dao层
 */
public interface UserFinancialAccountDao {
	//查询用户金融信息详细
	public List<UserFinancialAccountInfo> getUserFinancialAccountByCode(String internalCode);
	public UserFinancialAccountInfo getUserFinancialAccountById(String uniqueId,String internalCode);
	public UserFinancialAccountInfo getUserFinancialAccountByAccountId(String accountId);
	//新增用户金融信息信息
	public int insertUserFinancialAccount(UserFinancialAccountInfo userFinancialAccountInfo);
	//修改用户金融信息信息
	public int updateUserFinancialAccount(UserFinancialAccountInfo userFinancialAccountInfo);
	//删除用户金融信息信息
	public int deleteUserFinancialAccount(UserFinancialAccountInfo userFinancialAccountInfo);

}
