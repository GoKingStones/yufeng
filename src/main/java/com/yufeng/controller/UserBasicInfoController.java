package com.yufeng.controller;

import com.yufeng.entity.RegisterAccount;
import com.yufeng.entity.UserBasicInfo;
import com.yufeng.service.UserBasicInfoService;
import com.yufeng.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by fishyu on 16/7/23.
 */
@RestController
public class UserBasicInfoController {

    @Autowired
    private UserBasicInfoService userBasicInfoService;

    
//    @RequestMapping("isExistedUserBasicInfo")
//
//    public boolean isExistedUserBasicInfo(@RequestParam("idType") String idType,@RequestParam("idNo") String idNo) {
//
//        boolean result = userBasicInfoService.isExistedUserBasicInfo(idType, idNo);
//        return result;
//    }

    @RequestMapping("getUserBasicInfoByInternalCode")
    public UserBasicInfo getUserBasicInfoByInternalCode(@RequestParam("internalCode") String internalCode){

    	UserBasicInfo userBasicInfo= userBasicInfoService.getUserBasicInfoByInternalCode(internalCode);
        
        return userBasicInfo;
    }

    @RequestMapping("insertUserBasicInfo")
    @ResponseBody
    public Map<String,String> insertUserBasicInfo(@RequestBody UserBasicInfo userBasicInfo,@RequestBody RegisterAccount registerAccount) throws ParseException{

    	return userBasicInfoService.insertUserBasicInfoForSignUp(userBasicInfo,registerAccount);

    }

    @RequestMapping("updateUserBasicInfo")
    public Map<String,String> updateUserBasicInfo(UserBasicInfo userBasicInfo) throws ParseException{

        ResultMap resultMap=new ResultMap();
        
        if(userBasicInfoService.isExistedUserBasicInfoForUpdate(userBasicInfo.getIdType(), userBasicInfo.getIdNo(),userBasicInfo.getInternalCode())){
        	Map<String,String> errorMap = new HashMap<String,String>();
            
    	    errorMap = userBasicInfoService.checkUserBasicInfo(userBasicInfo);
    	
    	    if(errorMap.isEmpty()){
    	    	int result=userBasicInfoService.updateUserBasicInfo(userBasicInfo);
    	        if (result==0) {
    	            return resultMap.getErrorMap();
    	        }else {
    	            return resultMap.getSuccessMap();
    	        }
    	    }else{
    	    	
    	    	return errorMap;
    	    	
    	    }
        }else{
        	
        	return resultMap.getnotExistIDErrorMap();
        	
        }
   
    }

}
