package com.yufeng.dao;

import java.util.List;

import com.yufeng.entity.UserFamilyHistoryInfo;
import com.yufeng.entity.UserFamilyInfo;

/**
 * 用户家庭联系人信息dao层
 * @author dh
 */
public interface UserFamilyDao {
	
	//查询用户家庭联系人信息详细
	public List<UserFamilyInfo> getUserFamilyByCode(String code);
	public UserFamilyInfo getUserFamilyById(String id);
	public UserFamilyInfo getUserFamilyByCredentialsNumber(String number);
	//新增用户家庭联系人信息
	public int insertUserFamily(UserFamilyInfo userFamilyInfo);
	//修改用户家庭联系人信息
	public int updateUserFamily(UserFamilyInfo userFamilyInfo);
	//删除用户家庭联系人信息
	public int deleteUserFamily(UserFamilyHistoryInfo userFamilyHistoryInfo);

}
