package com.yufeng.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yufeng.config.ResultStatus;
import com.yufeng.entity.UserFinancialAccountInfo;
import com.yufeng.service.UserFinancialAccountService;
import com.yufeng.util.ResultModel;
import com.yufeng.util.Utils;

/**
 * 用户金融控制层
 * @author dh
 */
@RestController
@RequestMapping("/UserFinancialAccount")
public class UserFinancialAccountController {
	
	@Autowired
	private UserFinancialAccountService userFinancialAccountService;
	
	//查询金融账户信息
	@RequestMapping("/getUserFinancialAccountByInternalCode")
	public List<UserFinancialAccountInfo> getUserFinancialAccountByCode(String internalCode){
		List<UserFinancialAccountInfo> info=userFinancialAccountService.getUserFinancialAccountByCode(internalCode);
	    return info;
	}
	
	//查询金融账户信息
	@RequestMapping("/getUserFinancialAccountByIdAndInternalCode")
	public UserFinancialAccountInfo getUserFinancialAccountById(String uniqueId,String internalCode){
		UserFinancialAccountInfo info=userFinancialAccountService.getUserFinancialAccountById(uniqueId,internalCode);
		   return info;
	}
		
	//新建金融账户信息
	@RequestMapping("/insertUserFinancialAccount")
	public ResponseEntity<ResultModel> insertUserFinancialAccount(@RequestBody UserFinancialAccountInfo userFinancialAccountInfo){
		String type=userFinancialAccountService.insertUserFinancialAccount(userFinancialAccountInfo);
		if(Utils.RETURN_VALUE_CODE_1.equals(type)){
            return new ResponseEntity<ResultModel>(ResultModel.ok(),HttpStatus.OK);
        }else if(Utils.RETURN_VALUE_CODE_99.equals(type)){
            return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.FINANCIALCONSUMEACCOUNTID_REPEAT),HttpStatus.OK);
        }else{
            return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
        }
	}
			
	//金融账户信息修改
	@RequestMapping("/updateUserFinancialAccount")
	public ResponseEntity<ResultModel> updateUserFinancialAccount(@RequestBody UserFinancialAccountInfo userFinancialAccountInfo){
	    String type=userFinancialAccountService.updateUserFinancialAccount(userFinancialAccountInfo);	
	    if(Utils.RETURN_VALUE_CODE_1.equals(type)){
            return new ResponseEntity<ResultModel>(ResultModel.ok(),HttpStatus.OK);
        }else if((Utils.RETURN_VALUE_CODE_3.equals(type))){
            return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.FINANCIALACCOUNT_NOT_FOUND),HttpStatus.OK);
        }else{//操作失败
            return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
        }
	}
			
	//删除金融账户信息
	@RequestMapping("/deleteUserFinancialAccount")
	public ResponseEntity<ResultModel> deleteUserFinancialAccount(@RequestBody UserFinancialAccountInfo userFinancialAccountInfo){
	    String type=userFinancialAccountService.deleteUserFinancialAccount(userFinancialAccountInfo);
	    if(Utils.RETURN_VALUE_CODE_1.equals(type)){
            return new ResponseEntity<ResultModel>(ResultModel.ok(),HttpStatus.OK);
        }else if((Utils.RETURN_VALUE_CODE_3.equals(type))){
            return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.FINANCIALACCOUNT_NOT_FOUND),HttpStatus.OK);
        }else{//操作失败
            return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
        }
	}

}
