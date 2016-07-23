package com.yufeng.service.impl;

import com.yufeng.dao.UserBasicInfoDao;
import com.yufeng.entity.UserBasicInfo;
import com.yufeng.service.UserBasicInfoService;
import com.yufeng.util.CheckMethod;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by fishyu on 16/7/23.
 */
public class UserBasicInfoServiceImpl implements UserBasicInfoService{

    @Autowired
    private UserBasicInfoDao userBasicInfoDao;

	public UserBasicInfo getUserBasicInfoByInternalCode(String internalCode) {
		return userBasicInfoDao.getUserBasicInfoByInternalCode(internalCode);
	}

	public int insertUserBasicInfo(UserBasicInfo userBasicInfo) {
		
		return userBasicInfoDao.insertUserBasicInfo(userBasicInfo);
	}

	public int updateUserBasicInfo(UserBasicInfo userBasicInfo) {
		return userBasicInfoDao.updateUserBasicInfo(userBasicInfo);
	}

	public boolean isExistedUserBasicInfo(String idType, String idNo) {
		int count =userBasicInfoDao.isExistedUserBasicInfo(idType, idNo);
        boolean result =false;
        if(count !=0) result=true;
        return result;
	}

	public Map<String, String> checkUserBasicInfo(UserBasicInfo userBasicInfo) throws ParseException {
		
		Map<String, String> errorMap = new HashMap<String,String>();
		
		if(!CheckMethod.isEmail(userBasicInfo.getEmail())){
			errorMap.put("email", "format error");
		}
		
		if(!CheckMethod.isNumeric(userBasicInfo.getQqNo())){
			errorMap.put("qqNo", "format error");
		}
		
		String iDErrorStr = CheckMethod.IDCardValidate(userBasicInfo.getIdNo());
		
		if(iDErrorStr!=null && !iDErrorStr.equals("")){
			errorMap.put("idNo", iDErrorStr);
		}
		
		return errorMap;
	}

	public boolean isExistedUserBasicInfoForUpdate(String idType, String idNo, String internalCode) {
		int count =userBasicInfoDao.isExistedUserBasicInfoForUpdate(idType, idNo, internalCode);
        boolean result =false;
        if(count !=0) result=true;
        return result;
	}

	
}
