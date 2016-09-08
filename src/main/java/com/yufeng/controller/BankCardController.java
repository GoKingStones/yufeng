package com.yufeng.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yufeng.config.ResultStatus;
import com.yufeng.entity.UserBankCardInfo;
import com.yufeng.service.BankCardService;
import com.yufeng.util.ResultModel;
import com.yufeng.util.Utils;

/**
 * 银行卡控制层
 * @author dh
 */
@RestController
@RequestMapping("/BankCard")
public class BankCardController { 
	
	@Autowired
	private BankCardService bankCardService;
	
	//查询银行卡信息(code)
	@RequestMapping("/getBankCardByInternalCode")
	public List<UserBankCardInfo> getBankCardByCode(String internalCode){
		List<UserBankCardInfo> info=bankCardService.getBankCardByCode(internalCode);
		return info;
    }
	
	//查询银行卡信息(id)
	@RequestMapping("/getBankCardByIdAndInternalCode")
	//id和内码作为where条件，以免出现问题
	public UserBankCardInfo getBankCardByID(String uniqueId,String internalCode){
		UserBankCardInfo info=bankCardService.getBankCardByID(uniqueId,internalCode);
		return info;
	}
	
	//新建银行卡信息
	@RequestMapping("/insertBankCard")
	//入参应该是个list
	public ResponseEntity<ResultModel> insertBankCard(@RequestBody List<UserBankCardInfo> userBankCardInfo){
		String type=bankCardService.insertBankCard(userBankCardInfo);
		if(Utils.RETURN_VALUE_CODE_1.equals(type)){
		    return new ResponseEntity<ResultModel>(ResultModel.ok(),HttpStatus.OK);
		}else if(Utils.RETURN_VALUE_CODE_99.equals(type)){
		    return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.BANKCARDNUMBER_REPEAT),HttpStatus.OK);
		}else{
		    return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
		}
	    
	}
	
	//银行卡信息修改
	@RequestMapping("/updateBankCard")
	public ResponseEntity<ResultModel> updateBankCard(@RequestBody UserBankCardInfo userBankCardInfo){
		//id和内码作为where条件，以免出现问题
		String type=bankCardService.updateBankCard(userBankCardInfo);
		if(Utils.RETURN_VALUE_CODE_1.equals(type)){
		    return new ResponseEntity<ResultModel>(ResultModel.ok(),HttpStatus.OK);
		}else if((Utils.RETURN_VALUE_CODE_3.equals(type))){//不存在银行卡
		    return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.BANKCARD_NOT_FOUND),HttpStatus.OK);
		}else{//操作失败
		    return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
		}
	}
	
	//删除银行卡信息
	@RequestMapping("/deleteBankCard")
	public ResponseEntity<ResultModel> deleteBankCard(@RequestBody UserBankCardInfo userBankCardInfo){
		String type=bankCardService.deleteBankCard(userBankCardInfo);
		if(Utils.RETURN_VALUE_CODE_1.equals(type)){
            return new ResponseEntity<ResultModel>(ResultModel.ok(),HttpStatus.OK);
        }else if((Utils.RETURN_VALUE_CODE_3.equals(type))){//不存在银行卡
            return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.BANKCARD_NOT_FOUND),HttpStatus.OK);
        }else{//操作失败
            return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
        }
	}

	
//返回值应为ResponseEntity，参考RegisterAccountController
	
	
}
