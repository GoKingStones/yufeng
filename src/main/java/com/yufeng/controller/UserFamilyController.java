package com.yufeng.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yufeng.entity.UserFamilyHistoryInfo;
import com.yufeng.entity.UserFamilyInfo;
import com.yufeng.service.UserFamilyService;

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
	public List<UserFamilyInfo> getUserFamilyByCode(String code){
		return userFamilyService.getUserFamilyByCode(code);
	}
	
	//查询联系人信息
	@RequestMapping("/getUserFamilyById")
	id和内码作为where条件，以免出现问题
	public UserFamilyInfo getUserFamilyById(String id){
		return userFamilyService.getUserFamilyById(id);
	}
	
	//新建联系人信息
	@RequestMapping("/insertUserFamily")
	入参这应该是个list，填写联系人应该是在一个page内，会一起提交。
	public String insertUserFamily(@RequestBody UserFamilyInfo userFamilyInfo){
		return userFamilyService.insertUserFamily(userFamilyInfo);
	}
		
	//联系人信息修改
	@RequestMapping("/updateUserFamily")
	public String updateUserFamily(@RequestBody UserFamilyInfo userFamilyInfo){
		return userFamilyService.updateUserFamily(userFamilyInfo);
	}
		
	//删除联系人信息
	@RequestMapping("/deleteUserFamily")
	public String deleteUserFamily(@RequestBody UserFamilyHistoryInfo userFamilyHistoryInfo){
		return userFamilyService.deleteUserFamily(userFamilyHistoryInfo);
	}
	返回值应为ResponseEntity，参考RegisterAccountController
}
