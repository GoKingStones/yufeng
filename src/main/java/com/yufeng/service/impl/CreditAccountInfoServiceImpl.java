package com.yufeng.service.impl;

import com.yufeng.algorithm.UUIDGenerator;
import com.yufeng.dao.CreditAccountInfoDao;
import com.yufeng.dao.InternalCodeDao;
import com.yufeng.dao.RegisterAccountDao;
import com.yufeng.entity.CreditAccountInfo;
import com.yufeng.entity.InternalCode;
import com.yufeng.entity.RegisterAccount;
import com.yufeng.service.CreditAccountInfoService;
import com.yufeng.service.RegisterAccountService;

import com.yufeng.util.InternalCodeGenerator;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by fishyu on 16/8/12.
 */
public class CreditAccountInfoServiceImpl implements CreditAccountInfoService{

    @Autowired
    private CreditAccountInfoDao creditAccountInfoDao;

	public CreditAccountInfo getCreditAccountInfo(String internalCode) {
		
		CreditAccountInfo creditAccountInfo = new CreditAccountInfo();
		
		creditAccountInfo = creditAccountInfoDao.getCreditAccountInfo(internalCode);
		
		return creditAccountInfo;
	}


	public boolean isExistedCreditAccountInfo(String internalCode) {
		
		
		boolean result = false;
		
		int resultCount = creditAccountInfoDao.isExistedCreditAccountInfo(internalCode);
		
		if(resultCount>0){
			
			result = true;
			
		}
		
		return result;
	}


	public CreditAccountInfo insertCreditAccountInfo(CreditAccountInfo creditAccountInfo) {
		
		int result =  creditAccountInfoDao.insertCreditAccountInfo(creditAccountInfo);
		
		CreditAccountInfo creditAccountInfoResult=null;

	        if(result==1) {

	            creditAccountInfoResult=creditAccountInfoDao.getCreditAccountInfo(creditAccountInfo.getInternalCode());

	        }

	        return creditAccountInfoResult;
	}


	public CreditAccountInfo updateCreditAccountInfo(CreditAccountInfo creditAccountInfo) {
		
		int result = creditAccountInfoDao.updateCreditAccountInfo(creditAccountInfo);
		
		CreditAccountInfo creditAccountInfoResult=null;
	        
		if(result==1) {
			
			creditAccountInfoResult =creditAccountInfoDao.getCreditAccountInfo(creditAccountInfo.getInternalCode());
	    
		}

	        return creditAccountInfoResult;
	}

    

}
