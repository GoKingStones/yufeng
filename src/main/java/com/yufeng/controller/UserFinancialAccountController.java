package com.yufeng.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yufeng.entity.UserFinancialAccountInfo;
import com.yufeng.service.UserFinancialAccountService;

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
	@RequestMapping("/getUserFinancialAccountByCode")
	public List<UserFinancialAccountInfo> getUserFinancialAccountByCode(String code){
		List<UserFinancialAccountInfo> info=userFinancialAccountService.getUserFinancialAccountByCode(code);
	    return info;
	}
	
	//查询金融账户信息
	@RequestMapping("/getUserFinancialAccountById")
	public UserFinancialAccountInfo getUserFinancialAccountById(String id){
		UserFinancialAccountInfo info=userFinancialAccountService.getUserFinancialAccountById(id);
		   return info;
	}
		
	//新建金融账户信息
	@RequestMapping("/insertUserFinancialAccount")
	public String insertUserFinancialAccount(UserFinancialAccountInfo userFinancialAccountInfo){
		return userFinancialAccountService.insertUserFinancialAccount(userFinancialAccountInfo);	
	}
			
	//金融账户信息修改
	@RequestMapping("/updateUserFinancialAccount")
	public String updateUserFinancialAccount(UserFinancialAccountInfo userFinancialAccountInfo){
		return userFinancialAccountService.updateUserFinancialAccount(userFinancialAccountInfo);	
	}
			
	//删除金融账户信息
	@RequestMapping("/deleteUserFinancialAccount")
	public String deleteUserFinancialAccount(UserFinancialAccountInfo userFinancialAccountInfo){
		return userFinancialAccountService.deleteUserFinancialAccount(userFinancialAccountInfo);	
	}

}
