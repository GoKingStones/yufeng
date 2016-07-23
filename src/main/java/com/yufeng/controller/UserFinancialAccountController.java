package com.yufeng.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yufeng.entity.UserFinancialAccountInfo;
import com.yufeng.service.impl.UserFinancialAccountServiceImpl;

/**
 * 用户金融控制层
 * @author dh
  */

@RestController
@RequestMapping("/ UserFinancialAccount")
public class UserFinancialAccountController {
	
	@Autowired
	private UserFinancialAccountServiceImpl userFinancialAccountServiceImpl;
	
	//查询金融账户信息
	@RequestMapping("/getUserFinancialAccount")
	public List<UserFinancialAccountInfo> getUserFinancialAccount(String code){
		List<UserFinancialAccountInfo> info=userFinancialAccountServiceImpl.getUserFinancialAccount(code);
	    return info;
	}
		
	//新建金融账户信息
	@RequestMapping("/insertUserFinancialAccount")
	public String insertUserFinancialAccount(UserFinancialAccountInfo userFinancialAccountInfo){
		userFinancialAccountServiceImpl.insertUserFinancialAccount(userFinancialAccountInfo);
		return "ok";	
	}
			
	//金融账户信息修改
	@RequestMapping("/updateUserFinancialAccount")
	public String updateUserFinancialAccount(UserFinancialAccountInfo userFinancialAccountInfo){
		userFinancialAccountServiceImpl.updateUserFinancialAccount(userFinancialAccountInfo);
		return "ok";	
	}
			
	//删除金融账户信息
	@RequestMapping("/deleteUserFinancialAccount")
	public String deleteUserFinancialAccount(UserFinancialAccountInfo userFinancialAccountInfo){
		userFinancialAccountServiceImpl.deleteUserFinancialAccount(userFinancialAccountInfo);
		return "ok";	
	}

}
