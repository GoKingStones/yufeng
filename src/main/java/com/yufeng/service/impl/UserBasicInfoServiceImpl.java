package com.yufeng.service.impl;

import com.yufeng.dao.InternalCodeDao;
import com.yufeng.dao.RegisterAccountDao;
import com.yufeng.dao.UserBasicInfoDao;
import com.yufeng.entity.InternalCode;
import com.yufeng.entity.RegisterAccount;
import com.yufeng.entity.UserBasicInfo;
import com.yufeng.service.UserBasicInfoService;
import com.yufeng.util.CheckMethod;
import com.yufeng.util.InternalCodeGenerator;
import com.yufeng.util.ResultMap;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by fishyu on 16/7/23.
 */
public class UserBasicInfoServiceImpl implements UserBasicInfoService{

    @Autowired
    private UserBasicInfoDao userBasicInfoDao;
    
    
    @Autowired
    private RegisterAccountDao registerAccountDao;
    
    @Autowired
    private InternalCodeDao internalCodeDao;
    

	public UserBasicInfo getUserBasicInfoByInternalCode(String internalCode) {
		return userBasicInfoDao.getUserBasicInfoByInternalCode(internalCode);
	}

	public Map<String,String> insertUserBasicInfoForSignUp(UserBasicInfo userBasicInfo,RegisterAccount registerAccount) throws ParseException {
		
		
		ResultMap resultMap=new ResultMap();
		
		int count =userBasicInfoDao.isExistedUserBasicInfo(userBasicInfo.getIdType(), userBasicInfo.getIdNo());
    	
    	if(count>0){
    		
    		return resultMap.getExistIDErrorMap();
    		
    	}else{

    		    Map<String,String> errorMap = new HashMap<String,String>();
    		    
    		    errorMap = checkUserBasicInfo(userBasicInfo);
    		    
    		    if(registerAccount.getRegisterAccountId()==0){
    		    
    		    	errorMap.put("register", "no data error");
    		   
    		    }
    		    
    		    if(errorMap.isEmpty()){
    		    	
    		    	//生成内码
    		    	InternalCode internalCode = new InternalCode();
    		    	internalCode.setInternalCode(InternalCodeGenerator.getCode(Integer.parseInt(userBasicInfo.getIdType()),userBasicInfo.getIdNo()));
    		    	//在内码表插入一条数据
    		    	internalCodeDao.insertInternalCode(internalCode);
    		    	
    		    	//在客户基本信息表中插入一条数据
    		    	userBasicInfo.setInternalCode(internalCode.getInternalCode());
    		    	int result = userBasicInfoDao.insertUserBasicInfo(userBasicInfo);

    		    	//生成内码更新至用户注册表中	    	
    		    	registerAccount.setInternalCode(userBasicInfo.getInternalCode());    		    	
    		    	int result2 = registerAccountDao.updateRegisterAccount(registerAccount);
    		    	  	
        	        if (result==0 && result2==0) {
        	            return resultMap.getErrorMap();
        	        }else {
        	            return resultMap.getSuccessMap();
        	        }
    		    }else{
    		    	
    		    	return errorMap;
    		    	
    		    }
    	}
		
	}

	public int updateUserBasicInfo(UserBasicInfo userBasicInfo) {
		return userBasicInfoDao.updateUserBasicInfo(userBasicInfo);
	}

	public boolean isExistedUserBasicInfo(String idType, String idNo) {
		int count =userBasicInfoDao.isExistedUserBasicInfo(idType, idNo);
        boolean result =false;
        if(count !=0) result=true;
        return result;
	}

	public Map<String, String> checkUserBasicInfo(UserBasicInfo userBasicInfo) throws ParseException {
		
		Map<String, String> errorMap = new HashMap<String,String>();
		
		if(!CheckMethod.isEmail(userBasicInfo.getEmail())){
			errorMap.put("email", "format error");
		}
		
		if(!CheckMethod.isNumeric(userBasicInfo.getQqNo())){
			errorMap.put("qqNo", "format error");
		}
		
		String iDErrorStr = CheckMethod.IDCardValidate(userBasicInfo.getIdNo());
		
		if(iDErrorStr!=null && !iDErrorStr.equals("")){
			errorMap.put("idNo", iDErrorStr);
		}
		
		return errorMap;
	}

	public boolean isExistedUserBasicInfoForUpdate(String idType, String idNo, String internalCode) {
		int count =userBasicInfoDao.isExistedUserBasicInfoForUpdate(idType, idNo, internalCode);
        boolean result =false;
        if(count !=0) result=true;
        return result;
	}
}
