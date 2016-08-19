package com.yufeng.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yufeng.dao.InternalCodeDao;
import com.yufeng.dao.RegisterAccountDao;
import com.yufeng.dao.UserBasicInfoDao;
import com.yufeng.entity.InternalCode;
import com.yufeng.entity.RegisterAccount;
import com.yufeng.entity.UserBasicInfo;
import com.yufeng.service.CreditAccountInfoService;
import com.yufeng.service.UserBasicInfoService;
import com.yufeng.util.CheckMethod;
import com.yufeng.util.InternalCodeGenerator;

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
    
    @Autowired
    private CreditAccountInfoService creditAccountInfoService;
    

	public UserBasicInfo getUserBasicInfoByInternalCode(String internalCode) {
		return userBasicInfoDao.getUserBasicInfoByInternalCode(internalCode);
	}

	public UserBasicInfo insertUserBasicInfoForSignUp(String json) throws ParseException {
		
		JSONObject obj = JSON.parseObject(json);
		
		String accountType = obj.getString("accountType");
		String userBasicInfoStr = obj.getString("userBasicInfo");
		UserBasicInfo userBasicInfo = JSON.parseObject(userBasicInfoStr, UserBasicInfo.class);
		
		int count =userBasicInfoDao.isExistedUserBasicInfo(userBasicInfo.getIdType(), userBasicInfo.getIdNo());
    	//已经存在用户
    	if(count>0){
    		System.out.println("存在这个基本用户");
    		return null;
    		
    	}else{

    			System.out.println("不存在这个基本用户");
    		
    		    Map<String,String> errorMap = new HashMap<String,String>();
    		    
    		    errorMap = checkUserBasicInfo(userBasicInfo);
    		    
    		    RegisterAccount registerAccount =  registerAccountDao.getRegisterAccountByPhoneNumber(userBasicInfo.getCellNo());
    		    
    		    //不存在注册用户
    		    if(registerAccount==null){
    		    	System.out.println("不存在这个注册用户");
    		    	return null;
    		   
    		    }
    		    //通过校验
    		    if(errorMap.isEmpty()){
    		    	System.out.println("存在这个注册用户");
    		    	//生成内码
    		    	InternalCode internalCode = new InternalCode();
    		    	internalCode.setInternalCode(InternalCodeGenerator.getCode(Integer.parseInt(userBasicInfo.getIdType()),userBasicInfo.getIdNo()));
    		    	//在内码表插入一条数据
    		    	System.out.println("开始插入内码数据");
    		    	System.out.println("内码数据为"+internalCode.toString());
    		    	internalCodeDao.insertInternalCode(internalCode);
    		    	System.out.println("结束插入内码数据");
    		    	//在客户基本信息表中插入一条数据
    		    	System.out.println("开始插入基本信息数据");
    		    	userBasicInfo.setInternalCode(internalCode.getInternalCode());
    		    	System.out.println("基本数据为"+userBasicInfo.toString());
    		    	int result = userBasicInfoDao.insertUserBasicInfo(userBasicInfo);
    		    	System.out.println("结束插入内码数据");
    		    	//生成内码更新至用户注册表中	    
    		    	System.out.println("开始更新注册账户数据");
    		    	registerAccount.setInternalCode(userBasicInfo.getInternalCode());  
    		    	System.out.println("更新数据为"+registerAccount.toString());
    		    	int result2 = registerAccountDao.updateRegisterAccount(registerAccount);
    		    	System.out.println("结束更新注册账户数据");
    		    	//生成信用账户
    		    	
    		    	System.out.println("开始插入信用账户数据");
    		    	creditAccountInfoService.insertOrUpdateCreditAccountInfo(internalCode.getInternalCode(), accountType);
    		    	System.out.println("结束插入信用账户数据");
    		    	if(result==1&&result2==1){
    		    		
    		    		return userBasicInfoDao.getUserBasicInfoByInternalCode(internalCode.getInternalCode());
    		    		
    		    	}else{
    		    		return null;
    		    	}
    		    	
    		  }else{
    			  
    			  return null;
    			  
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
