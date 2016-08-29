package com.yufeng.service;

import java.util.List;

import com.yufeng.entity.UserBankCardInfo;

/**
 * 用户银行卡业务处理层接口
 * @author dh
 */
public interface BankCardService {
	
	//查询银行卡信息
	public List<UserBankCardInfo> getBankCardByCode(String code);
	//查询银行卡信息
	public UserBankCardInfo getBankCardByID(String id,String internalCode);
	//新建银行卡信息
	public String insertBankCard(UserBankCardInfo userBankCardInfo);
	//银行卡信息修改
	public String updateBankCard(UserBankCardInfo userBankCardInfo);
	//删除银行卡信息
	public String deleteBankCard(UserBankCardInfo userBankCardInfo);

}
