package com.yufeng.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	@RequestMapping("/getUserFamilyByCode")
	public List<UserFamilyInfo> getUserFamilyByCode(String code){
		return userFamilyService.getUserFamilyByCode(code);
	}
	
	//查询联系人信息
	@RequestMapping("/getUserFamilyById")
	public UserFamilyInfo getUserFamilyById(String id){
		return userFamilyService.getUserFamilyById(id);
	}
	
	//新建联系人信息
	@RequestMapping("/insertUserFamily")
	public String insertUserFamily(UserFamilyInfo userFamilyInfo){
		return userFamilyService.insertUserFamily(userFamilyInfo);
	}
		
	//联系人信息修改
	@RequestMapping("/updateUserFamily")
	public String updateUserFamily(UserFamilyInfo userFamilyInfo){
		return userFamilyService.updateUserFamily(userFamilyInfo);
	}
		
	//删除联系人信息
	@RequestMapping("/deleteUserFamily")
	public String deleteUserFamily(UserFamilyHistoryInfo userFamilyHistoryInfo){
		return userFamilyService.deleteUserFamily(userFamilyHistoryInfo);
	}
 
}
