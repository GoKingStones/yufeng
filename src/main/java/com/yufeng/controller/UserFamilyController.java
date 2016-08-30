package com.yufeng.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yufeng.config.ResultStatus;
import com.yufeng.entity.UserFamilyHistoryInfo;
import com.yufeng.entity.UserFamilyInfo;
import com.yufeng.service.UserFamilyService;
import com.yufeng.util.ResultModel;

/**
 * 用户家庭联系人控制层
 * @author dh
 */
@RestController
@RequestMapping("/UserFamily")
public class UserFamilyController {
	
	@Autowired
	private UserFamilyService userFamilyService;
	
	
	//查询联系人信息
	@RequestMapping("/getUserFamilyByInternalCode")
	public List<UserFamilyInfo> getUserFamilyByCode(String internalCode){
		return userFamilyService.getUserFamilyByCode(internalCode);
	}
	
	//查询联系人信息
	@RequestMapping("/getUserFamilyByIdAndInternalCode")
	//id和内码作为where条件，以免出现问题
	public UserFamilyInfo getUserFamilyById(String uniqueId,String internalCode){
		return userFamilyService.getUserFamilyById(uniqueId,internalCode);
	}
	
	//新建联系人信息
	@RequestMapping("/insertUserFamily")
	//入参这应该是个list，填写联系人应该是在一个page内，会一起提交。
	public ResponseEntity<ResultModel> insertUserFamily(@RequestBody List<UserFamilyInfo> userFamilyInfo){
		String type=userFamilyService.insertUserFamily(userFamilyInfo);
		if("1".equals(type)){
            return new ResponseEntity<ResultModel>(ResultModel.ok(),HttpStatus.OK);
        }else if("99".equals(type)){
            return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.CREDENTIALSNUMBER_REPEAT),HttpStatus.OK);
        }else{
            return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
        }
	}
		
	//联系人信息修改
	@RequestMapping("/updateUserFamily")
	public ResponseEntity<ResultModel> updateUserFamily(@RequestBody UserFamilyInfo userFamilyInfo){
		String type=userFamilyService.updateUserFamily(userFamilyInfo);
		if("1".equals(type)){
            return new ResponseEntity<ResultModel>(ResultModel.ok(),HttpStatus.OK);
        }else if(("3".equals(type))){//不存在银行卡
            return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.FAMILY_NOT_FOUND),HttpStatus.OK);
        }else{//操作失败
            return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
        }
	}
		
	//删除联系人信息
	@RequestMapping("/deleteUserFamily")
	public ResponseEntity<ResultModel> deleteUserFamily(@RequestBody UserFamilyHistoryInfo userFamilyHistoryInfo){
		String type=userFamilyService.deleteUserFamily(userFamilyHistoryInfo);
		if("1".equals(type)){
            return new ResponseEntity<ResultModel>(ResultModel.ok(),HttpStatus.OK);
        }else if(("3".equals(type))){//不存在银行卡
            return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.FAMILY_NOT_FOUND),HttpStatus.OK);
        }else{//操作失败
            return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
        }
	}
	//返回值应为ResponseEntity，参考RegisterAccountController
}
