package com.yufeng.service.impl;

import com.yufeng.algorithm.CalculateCreditLine;
import com.yufeng.dao.CreditAccountInfoDao;
import com.yufeng.entity.CreditAccountInfo;
import com.yufeng.service.CreditAccountInfoService;
import com.yufeng.util.Utils;

import java.math.BigDecimal;

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
		System.out.println("resultCount=="+resultCount);
		if(resultCount>0){
			
			result = true;
			
		}
		System.out.println("result是否存在=="+result);
		return result;
	}


	public CreditAccountInfo insertOrUpdateCreditAccountInfo(String internalCode,String accountType) {
		
		CreditAccountInfo creditAccountInfoResult=null;
		//如果账户存在就重新计算信用额度，并更新信用账户
		if(isExistedCreditAccountInfo(internalCode)){
			
			System.out.println("存在该信用账户，用于更新额度");
			
			CreditAccountInfo creditAccountInfoNew = new CreditAccountInfo();
			
			creditAccountInfoNew = updateCreditAccountLine(internalCode,accountType);
			
			int result =  creditAccountInfoDao.updateCreditAccountInfo(creditAccountInfoNew);
			
		    if(result==1) {

		    	creditAccountInfoResult=creditAccountInfoDao.getCreditAccountInfo(internalCode);

		    }
		    		
			
		}else{
			//如果账户不存在就生成一个新的信用账户
			
			System.out.println("不存在该信用账户，用于更新额度");
			
			CreditAccountInfo creditAccountInfoNew = new CreditAccountInfo();
			
			creditAccountInfoNew = makeCreditAccountLine(internalCode, accountType);
			
			int result =  creditAccountInfoDao.insertCreditAccountInfo(creditAccountInfoNew);

		    if(result==1) {

		    	creditAccountInfoResult=creditAccountInfoDao.getCreditAccountInfo(internalCode);

		    }
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
	
	/**
	 * 构造信用账户
	 * @param UserInfo userInfo 该用户所有信息
	 * @param String accountType 该用户类型
	 * @return CreditAccountInfo 信用账户
	 * 
	 * */
	public CreditAccountInfo makeCreditAccountLine(String internalCode,String accountType){
				
		double creditLine = 0;
		
		CalculateCreditLine calculateCreditLine = new CalculateCreditLine();
		
		if(accountType!=null&&accountType.equals(Utils.STUDENT_ACCOUNT)){
			
			System.out.println("学生信用账户");
			creditLine = calculateCreditLine.CalculateCreditLineForStudent(internalCode);
			
		}
		
		if(accountType!=null&&accountType.equals(Utils.ADULT_ACCOUNT)){
			
			
			creditLine = calculateCreditLine.CalculateCreditLineForAdult(internalCode);
			
		}
		
		CreditAccountInfo creditAccountInfo = new CreditAccountInfo();
		
		creditAccountInfo.setInternalCode(internalCode);
		creditAccountInfo.setAccountType(accountType);
		creditAccountInfo.setAccountStatus(Utils.NORMAL_ACCOUNT);
		creditAccountInfo.setInitialCashQuota(new BigDecimal(creditLine));
		creditAccountInfo.setInitialGuaranteeQuota(new BigDecimal(creditLine).multiply(Utils.GUARANTEE_QUOATA_RATIO));
		creditAccountInfo.setCurrentCashQuota(new BigDecimal(creditLine));
		creditAccountInfo.setCurrentGuaranteeQuota(new BigDecimal(creditLine).multiply(Utils.GUARANTEE_QUOATA_RATIO));
		creditAccountInfo.setAvailableCashQuota(new BigDecimal(creditLine));
		creditAccountInfo.setAvailableGuaranteeQuota(new BigDecimal(creditLine).multiply(Utils.GUARANTEE_QUOATA_RATIO));
		
		
		return creditAccountInfo;
	}
	
	
	
	/**
	 * 更新信用账户
	 * @param UserInfo userInfo 该用户所有信息
	 * @param String accountType 该用户类型
	 * @return CreditAccountInfo 信用账户
	 * 
	 * */
	public CreditAccountInfo updateCreditAccountLine(String internalCode,String accountType){
				
		double creditLine = 0;
		
		CalculateCreditLine calculateCreditLine = new CalculateCreditLine();
		
		if(accountType!=null&&accountType.equals(Utils.STUDENT_ACCOUNT)){
			
			
			creditLine = calculateCreditLine.CalculateCreditLineForStudent(internalCode);
			
		}
		
		if(accountType!=null&&accountType.equals(Utils.ADULT_ACCOUNT)){
			
			
			creditLine = calculateCreditLine.CalculateCreditLineForAdult(internalCode);
			
		}
		
		CreditAccountInfo creditAccountInfoOld = getCreditAccountInfo(internalCode);
		
		BigDecimal OldCurrentCashQuota = creditAccountInfoOld.getCurrentCashQuota();
		BigDecimal OldCurrentGuaranteeQuota = creditAccountInfoOld.getCurrentGuaranteeQuota();
		
		
		creditAccountInfoOld.setCurrentCashQuota(new BigDecimal(creditLine));
		creditAccountInfoOld.setCurrentGuaranteeQuota(new BigDecimal(creditLine).multiply(Utils.GUARANTEE_QUOATA_RATIO));
		creditAccountInfoOld.setAvailableCashQuota(new BigDecimal(creditLine).subtract(OldCurrentCashQuota));
		creditAccountInfoOld.setAvailableGuaranteeQuota(new BigDecimal(creditLine).multiply(Utils.GUARANTEE_QUOATA_RATIO).subtract(OldCurrentGuaranteeQuota));
		
		
		return creditAccountInfoOld;
	}
	

    

}
