package com.yufeng.dao;

import com.yufeng.entity.UserBasicInfo;

/**
 * Created by fishyu on 16/7/23
 */
public interface UserBasicInfoDao {

	int isExistedUserBasicInfo(String idType,String idNo);
	UserBasicInfo getUserBasicInfoByInternalCode(String internalCode);
    int insertUserBasicInfo(UserBasicInfo userBasicInfo);
    int updateUserBasicInfo(UserBasicInfo userBasicInfo);
    int isExistedUserBasicInfoForUpdate(String idType,String idNo,String internalCode);
}
