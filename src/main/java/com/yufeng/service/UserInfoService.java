package com.yufeng.service;

import com.yufeng.entity.UserInfo;

/**
 * Created by fishyu on 5/8/26.
 */
public interface UserInfoService {
    
   
	UserInfo getUserInfo(String internalCode);
	
	int getStudentUserLevel(UserInfo userInfo);
	
}
