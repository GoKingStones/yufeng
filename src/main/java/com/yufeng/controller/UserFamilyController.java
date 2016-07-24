package com.yufeng.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yufeng.entity.UserBankCardInfo;
import com.yufeng.entity.UserFamilyInfo;
import com.yufeng.service.impl.UserFamilyServiceImpl;

/**
 * 用户家庭联系人控制层
 * @author dh
  */

@RestController
@RequestMapping("/UserFamily")
public class UserFamilyController {
	
	@Autowired
	private UserFamilyServiceImpl userFamilyService;
	
	
	//查询联系人信息
	@RequestMapping("/getUserFamily")
	public List<UserFamilyInfo> getUserFamily(String code){
		List<UserFamilyInfo> info=userFamilyService.getUserFamily(code);
		return info;
	}
	
	//新建联系人信息
	@RequestMapping("/insertUserFamily")
	public String insertUserFamily(UserFamilyInfo userFamilyInfo){
		userFamilyService.insertUserFamily(userFamilyInfo);
		return "ok";	
	}
		
	//联系人信息修改
	@RequestMapping("/updateUserFamily")
	public String updateUserFamily(UserFamilyInfo userFamilyInfo){
		userFamilyService.updateUserFamily(userFamilyInfo);
		return "ok";	
	}
		
	//删除联系人信息
	@RequestMapping("/deleteUserFamily")
	public String deleteUserFamily(UserFamilyInfo userFamilyInfo){
		userFamilyService.deleteUserFamily(userFamilyInfo);
		return "ok";	
	}
 
}
