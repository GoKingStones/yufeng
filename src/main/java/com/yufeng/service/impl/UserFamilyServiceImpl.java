package com.yufeng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yufeng.dao.UserFamilyDao;
import com.yufeng.entity.UserFamilyInfo;

/**
 * 用户家庭联系人业务处理层
 * @author dh
 */
@Service
public class UserFamilyServiceImpl {
	
	@Autowired
    private UserFamilyDao userFamilyDao;
	
	//查询联系人信息
	public List<UserFamilyInfo> getUserFamily(String code){
		List<UserFamilyInfo> info=userFamilyDao.getUserFamily(code);
		return info;
	}
	
	//新建联系人信息
	public String insertUserFamily(UserFamilyInfo userFamilyInfo){
		userFamilyDao.insertUserFamily(userFamilyInfo);
		return "ok";	
	}
			
	//联系人信息修改
	public String updateUserFamily(UserFamilyInfo userFamilyInfo){
		userFamilyDao.updateUserFamily(userFamilyInfo);
		return "ok";	
	}
			
	//删除联系人信息
	public String deleteUserFamily(UserFamilyInfo userFamilyInfo){
		userFamilyDao.deleteUserFamily(userFamilyInfo);
		return "ok";	
	}

}
