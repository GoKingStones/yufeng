package com.yufeng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yufeng.dao.UserFinancialAccountDao;
import com.yufeng.entity.UserFinancialAccountInfo;

/**
 * 用户金融业务处理层
 * @author dh
 */
@Service
public class UserFinancialAccountServiceImpl {
	
	@Autowired
    private UserFinancialAccountDao userFinancialAccountDao;
	
	//查询金融账户信息
	public List<UserFinancialAccountInfo> getUserFinancialAccount(String code){
		List<UserFinancialAccountInfo> info=userFinancialAccountDao.getUserFinancialAccount(code);
		return info;
	}
			
	//新建金融账户信息
	public String insertUserFinancialAccount(UserFinancialAccountInfo userFinancialAccountInfo){
		userFinancialAccountDao.insertUserFinancialAccount(userFinancialAccountInfo);
		return "ok";	
	}
				
	//金融账户信息修改
	public String updateUserFinancialAccount(UserFinancialAccountInfo userFinancialAccountInfo){
		userFinancialAccountDao.updateUserFinancialAccount(userFinancialAccountInfo);
		return "ok";	
	}
				
	//删除金融账户信息
	public String deleteUserFinancialAccount(UserFinancialAccountInfo userFinancialAccountInfo){
		userFinancialAccountDao.deleteUserFinancialAccount(userFinancialAccountInfo);
		return "ok";	
	}

}
