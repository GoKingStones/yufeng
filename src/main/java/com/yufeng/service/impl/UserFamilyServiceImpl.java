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
		userFamilyInfo.setCreateTime(new Date());
		return userFamilyDao.insertUserFamily(userFamilyInfo)+"";
	}
			
	//联系人信息修改
	public String updateUserFamily(UserFamilyInfo userFamilyInfo){
		UserFamilyInfo info=userFamilyDao.getUserFamilyById(userFamilyInfo.getUniqueId());
		//检查信息是否存在
		if(info==null){
			return "0";
		}
		//保存修改时间
		userFamilyInfo.setModTime(new Date());
		return userFamilyDao.updateUserFamily(userFamilyInfo)+"";
	}
			
	//删除联系人信息
	public String deleteUserFamily(UserFamilyHistoryInfo userFamilyHistoryInfo){
		UserFamilyInfo info=userFamilyDao.getUserFamilyById(userFamilyHistoryInfo.getId());
		//检查信息是否存在
		if(info==null){
			return "0";
		}
		UserFamilyHistoryInfo u=new UserFamilyHistoryInfo();
		u.setCredentialsNumber(info.getCredentialsNumber());
		u.setCredentialsType(info.getCredentialsType());
		u.setDelete_operator(userFamilyHistoryInfo.getDelete_operator());//取得操作者
		u.setFoundTime(info.getCreateTime());
		u.setGender(info.getGender());
		u.setHighestEducation(info.getHighestEducation());
		u.setHighestEducationSchool(info.getHighestEducationSchool());
		u.setInternal_code(info.getInternalCode());
		u.setMailbox(info.getEmail());
		u.setMailingAddress(info.getMailingAddress());
		u.setName(info.getName());
		u.setOrganization(info.getOrganization());
		u.setPhone(info.getCellNo());
		u.setRelation(info.getRelation());
		//保存联系人进历史表
		userFamilyHistoryDao.insertUserFamilyHistory(u);
		return userFamilyDao.deleteUserFamily(userFamilyHistoryInfo)+"";
	}

}
