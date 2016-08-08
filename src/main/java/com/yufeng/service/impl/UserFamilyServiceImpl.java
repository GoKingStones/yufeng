package com.yufeng.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yufeng.dao.UserFamilyDao;
import com.yufeng.dao.UserFamilyHistoryDao;
import com.yufeng.entity.UserFamilyHistoryInfo;
import com.yufeng.entity.UserFamilyInfo;
import com.yufeng.service.UserFamilyService;

/**
 * 用户家庭联系人业务处理层
 * @author dh
 */
@Service
public class UserFamilyServiceImpl implements UserFamilyService{
	
	@Autowired
    private UserFamilyDao userFamilyDao;
	@Autowired
    private UserFamilyHistoryDao userFamilyHistoryDao;
	
	//查询联系人信息
	public List<UserFamilyInfo> getUserFamilyByCode(String code){
		return userFamilyDao.getUserFamilyByCode(code);
	}
	
	//查询联系人信息
	public UserFamilyInfo getUserFamilyById(String id){
		return userFamilyDao.getUserFamilyById(id);
	}
	
	//新建联系人信息
	public String insertUserFamily(UserFamilyInfo userFamilyInfo){
		//检查身份证号是否重复
		UserFamilyInfo info=userFamilyDao.getUserFamilyByCredentialsNumber(userFamilyInfo.getCredentialsNumber());
		if(info!=null){
			return "2";//重复
		}
		//保存新建时间
		userFamilyInfo.setFoundTime(new Date());
		return userFamilyDao.insertUserFamily(userFamilyInfo)+"";
	}
			
	//联系人信息修改
	public String updateUserFamily(UserFamilyInfo userFamilyInfo){
		UserFamilyInfo info=userFamilyDao.getUserFamilyById(userFamilyInfo.getId());
		//检查信息是否存在
		if(info==null){
			return "0";
		}
		//保存修改时间
		userFamilyInfo.setUpdateTime(new Date());
		return userFamilyDao.updateUserFamily(userFamilyInfo)+"";
	}
			
	//删除联系人信息
	public String deleteUserFamily(UserFamilyHistoryInfo userFamilyHistoryInfo){
		UserFamilyInfo info=userFamilyDao.getUserFamilyById(userFamilyHistoryInfo.getId());
		//检查信息是否存在
		if(info==null){
			return "0";
		}
		//保存联系人进历史表
		userFamilyHistoryDao.insertUserFamilyHistory(userFamilyHistoryInfo);
		return userFamilyDao.deleteUserFamily(userFamilyHistoryInfo)+"";
	}

}
