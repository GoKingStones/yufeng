package com.yufeng.service;

import java.text.ParseException;
import java.util.Map;

import com.yufeng.entity.UserBasicInfo;

/**
 * Created by fishyu on 16/7/23.
 */
public interface UserBasicInfoService {

	boolean isExistedUserBasicInfo(String idType,String idNo);
	UserBasicInfo getUserBasicInfoByInternalCode(String internalCode);
	Map<String,String> insertUserBasicInfo(UserBasicInfo userBasicInfo) throws ParseException ;
    int updateUserBasicInfo(UserBasicInfo userBasicInfo);
    Map<String,String> checkUserBasicInfo(UserBasicInfo userBasicInfo) throws ParseException;
    boolean isExistedUserBasicInfoForUpdate(String idType,String idNo,String internalCode);
    

}
