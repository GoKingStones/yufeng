package com.yufeng.service.impl;

import java.util.Date;
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
	public List<UserBankCardInfo> getBankCardByCode(String code){
		List<UserBankCardInfo> info=bankCardDao.getBankCardByCode(code);
		return info;
	}
	
	//查询银行卡信息
	public UserBankCardInfo getBankCardByID(String id){
		UserBankCardInfo info=bankCardDao.getBankCardByID(id);
		return info;
	}
		
	//新建银行卡信息
	public String insertBankCard(UserBankCardInfo userBankCardInfo){
		userBankCardInfo.setFoundTime(new Date());
		//检查是否存在重复银行卡号
		UserBankCardInfo info=bankCardDao.getBankCardByBankCardNumber(userBankCardInfo.getBankCardNumber());
		if(info!=null){
			return "2";//存在重复
		}
		return bankCardDao.insertBankCard(userBankCardInfo)+"";	
	}
		
	//银行卡信息修改
	public String updateBankCard(UserBankCardInfo userBankCardInfo){
		userBankCardInfo.setUpdateTime(new Date());
		//检查数据是否存在
		UserBankCardInfo info=bankCardDao.getBankCardByID(userBankCardInfo.getId());
		if(info==null){
			return "0";
		}
		return bankCardDao.updateBankCard(userBankCardInfo)+"";	
	}
		
	//删除银行卡信息
	public String deleteBankCard(UserBankCardInfo userBankCardInfo){
		//检查数据是否存在
		UserBankCardInfo info=bankCardDao.getBankCardByID(userBankCardInfo.getId());
		if(info==null){
			return "0";
		}
		return bankCardDao.deleteBankCard(userBankCardInfo)+"";	
	}

}
