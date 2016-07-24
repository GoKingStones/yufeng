package com.yufeng.dao;

import java.util.List;

import com.yufeng.entity.UserFamilyInfo;

/**
 * 用户家庭联系人信息dao层
 * @author dh
 */
public interface UserFamilyDao {
	
	//查询用户家庭联系人信息详细
	public List<UserFamilyInfo> getUserFamily(String code);
	//新增用户家庭联系人信息
	public int insertUserFamily(UserFamilyInfo userFamilyInfo);
	//修改用户家庭联系人信息
	public int updateUserFamily(UserFamilyInfo userFamilyInfo);
	//删除用户家庭联系人信息
	public int deleteUserFamily(UserFamilyInfo userFamilyInfo);

}
