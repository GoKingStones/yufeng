package com.yufeng.controller;

import com.yufeng.config.ResultStatus;
import com.yufeng.entity.UserBasicInfo;
import com.yufeng.service.UserBasicInfoService;
import com.yufeng.util.ResultModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;


/**
 * Created by fishyu on 16/7/23.
 */
@RestController
@RequestMapping("userBasicInfo")
public class UserBasicInfoController {

    @Autowired
    private UserBasicInfoService userBasicInfoService;


    @RequestMapping(value = "/getUserBasicInfoByInternalCode",method = RequestMethod.GET)
    public ResponseEntity<ResultModel> getUserBasicInfoByInternalCode(@RequestParam("internalCode") String internalCode){

    	UserBasicInfo userBasicInfo= userBasicInfoService.getUserBasicInfoByInternalCode(internalCode);
        
    	if (userBasicInfo!=null) {
            return new ResponseEntity<ResultModel>(ResultModel.ok(userBasicInfo),HttpStatus.OK);
        }else {
            return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
        }
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

    @RequestMapping(value = "/updateUserBasicInfo",method = RequestMethod.POST)
    public ResponseEntity<ResultModel> updateUserBasicInfo(@RequestBody UserBasicInfo userBasicInfo) throws ParseException{

    	UserBasicInfo userBasicInfoResult = userBasicInfoService.updateUserBasicInfo(userBasicInfo);
    	
    	if (userBasicInfoResult!=null) {
            return new ResponseEntity<ResultModel>(ResultModel.ok(userBasicInfoResult),HttpStatus.OK);
        }else {
            return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
        }    	
    }

}
