package com.yufeng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yufeng.dao.BankCardDao;
import com.yufeng.entity.UserBankCardInfo;

/**
 * 用户银行卡业务处理层
 * @author dh
 */
@Service
public class BankCardServiceImpl {
	
	@Autowired
    private BankCardDao bankCardDao;
	
	//查询银行卡信息
	public List<UserBankCardInfo> getBankCard(String code){
		List<UserBankCardInfo> info=bankCardDao.getBankCard(code);
		return info;
	}
		
	//新建银行卡信息
	public String insertBankCard(UserBankCardInfo userBankCardInfo){
		bankCardDao.insertBankCard(userBankCardInfo);
		return "ok";	
	}
		
	//银行卡信息修改
	public String updateBankCard(UserBankCardInfo userBankCardInfo){
		bankCardDao.updateBankCard(userBankCardInfo);
		return "ok";	
	}
		
	//删除银行卡信息
	public String deleteBankCard(UserBankCardInfo userBankCardInfo){
		bankCardDao.deleteBankCard(userBankCardInfo);
		return "ok";	
	}

}
