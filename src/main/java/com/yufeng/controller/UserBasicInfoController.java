package com.yufeng.controller;

import com.yufeng.config.ResultStatus;
import com.yufeng.entity.UserBasicInfo;
import com.yufeng.service.UserBasicInfoService;
import com.yufeng.util.ResultMap;
import com.yufeng.util.ResultModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by fishyu on 16/7/23.
 */
@RestController
@RequestMapping("userBasicInfo")
public class UserBasicInfoController {

    @Autowired
    private UserBasicInfoService userBasicInfoService;


    @RequestMapping("getUserBasicInfoByInternalCode")
    public UserBasicInfo getUserBasicInfoByInternalCode(@RequestParam("internalCode") String internalCode){

    	UserBasicInfo userBasicInfo= userBasicInfoService.getUserBasicInfoByInternalCode(internalCode);
        
        return userBasicInfo;
    }


    @RequestMapping(value = "/insertUserBasicInfoForSignUp",method = RequestMethod.POST)
    public ResponseEntity<ResultModel> insertUserBasicInfo(@RequestBody String json) throws ParseException{

    	UserBasicInfo userBasicInfoResult = userBasicInfoService.insertUserBasicInfoForSignUp(json);
    		
    	if (userBasicInfoResult!=null) {
            return new ResponseEntity<ResultModel>(ResultModel.ok(userBasicInfoResult),HttpStatus.OK);
        }else {
            return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
        }

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
