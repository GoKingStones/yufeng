package com.yufeng.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yufeng.dao.BankCardDao;
import com.yufeng.entity.UserBankCardInfo;
import com.yufeng.service.BankCardService;
import com.yufeng.util.Utils;

/**
 * 用户银行卡业务处理层
 * @author dh
 */
@Service
public class BankCardServiceImpl implements BankCardService{
	
	@Autowired
    private BankCardDao bankCardDao;
	
	//查询银行卡信息
	public List<UserBankCardInfo> getBankCardByCode(String code){
		List<UserBankCardInfo> info=bankCardDao.getBankCardByCode(code);
		return info;
	}
	
	//查询银行卡信息
	public UserBankCardInfo getBankCardByID(String uniqueId,String internalCode){
		UserBankCardInfo info=bankCardDao.getBankCardByID(uniqueId,internalCode);
		return info;
	}
		
	//新建银行卡信息
	public String insertBankCard(List<UserBankCardInfo> userBankCardInfo){
	    //验证信息
	    if(userBankCardInfo!=null&&userBankCardInfo.size()>0){
	        for(UserBankCardInfo u:userBankCardInfo){
	            u.setCreateTime(new Date());
	            //检查是否存在重复银行卡号
	            UserBankCardInfo info=bankCardDao.getBankCardByBankCardNumber(u.getBankCardNumber());
	            if(info!=null){
	                return Utils.RETURN_VALUE_CODE_99;//存在重复
	            }
	            bankCardDao.insertBankCard(u); 
	        }
	        
	    }
		return Utils.RETURN_VALUE_CODE_1;
	}
		
	//银行卡信息修改
	public String updateBankCard(UserBankCardInfo userBankCardInfo){
		userBankCardInfo.setModTime(new Date());
		//检查数据是否存在
		UserBankCardInfo info=bankCardDao.getBankCardByID(userBankCardInfo.getUniqueId(),userBankCardInfo.getInternalCode());
		if(info==null){
			return Utils.RETURN_VALUE_CODE_3;
		}
		return bankCardDao.updateBankCard(userBankCardInfo)+"";	
	}
		
	//删除银行卡信息
	public String deleteBankCard(UserBankCardInfo userBankCardInfo){
		//检查数据是否存在
		UserBankCardInfo info=bankCardDao.getBankCardByID(userBankCardInfo.getUniqueId(),userBankCardInfo.getInternalCode());
		if(info==null){
			return Utils.RETURN_VALUE_CODE_3;
		}
		return bankCardDao.deleteBankCard(userBankCardInfo)+"";	
	}

}
