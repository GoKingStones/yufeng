package com.yufeng.dao;

import com.yufeng.entity.UserFamilyHistoryInfo;

/**
 * 用户家庭联系人历史信息dao层
 * @author dh
 */
public interface UserFamilyHistoryDao {
	
	//新增用户家庭联系人历史信息
	public int insertUserFamilyHistory(UserFamilyHistoryInfo userFamilyHistoryInfo);

}
