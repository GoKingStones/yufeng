package com.yufeng.service;

import java.util.List;

import com.yufeng.entity.UserFamilyHistoryInfo;
import com.yufeng.entity.UserFamilyInfo;

/**
 * 用户家庭联系人业务处理层接口
 * @author dh
 */
public interface UserFamilyService {
	
	//查询联系人信息
	public List<UserFamilyInfo> getUserFamilyByCode(String code);
	//查询联系人信息
	public UserFamilyInfo getUserFamilyById(String uniqueId,String internalCode);
	//新建联系人信息
	public String insertUserFamily(List<UserFamilyInfo> userFamilyInfo);
	//联系人信息修改
	public String updateUserFamily(UserFamilyInfo userFamilyInfo);
	//删除联系人信息
	public String deleteUserFamily(UserFamilyHistoryInfo userFamilyHistoryInfo);
	

}
