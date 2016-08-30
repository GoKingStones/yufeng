package com.yufeng.dao;

import java.util.List;

import com.yufeng.entity.RegisterAccount;
import com.yufeng.entity.UserBankCardInfo;

/**
 * 银行卡dao层
 * @author dh
 */
public interface BankCardDao {
	//查询银行卡详细
	public List<UserBankCardInfo> getBankCardByCode(String internalCode);
	public UserBankCardInfo getBankCardByID(String uniqueId,String internalCode);
	public UserBankCardInfo getBankCardByBankCardNumber(String number);
	//新增银行卡信息
	public int insertBankCard(UserBankCardInfo userBankCardInfo);
    //修改银行卡信息
	public int updateBankCard(UserBankCardInfo userBankCardInfo);
    //删除银行卡信息
	public int deleteBankCard(UserBankCardInfo userBankCardInfo);

}
