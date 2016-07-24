package com.yufeng.dao;

import com.yufeng.entity.EnterpriseBusinessBasicInfo;

/**
 * Created by kingstones on 16/7/24.
 * 企业商户基本信息DAO
 */
public interface EnterpriseBusinessBasicInfoDao {

    int isExistedEnterpriseBusinessBasicInfo(String businessName);
    //根据商户名称来查询，商户名称是全局唯一的
    EnterpriseBusinessBasicInfo getEnterpriseBusinessBasicInfo(String businessName);
    int insertEnterpriseBusinessBasicInfo(EnterpriseBusinessBasicInfo enterpriseBusinessBasicInfo);
    int updateEnterpriseBusinessBasicInfo(EnterpriseBusinessBasicInfo enterpriseBusinessBasicInfo);
    int deleteEnterpriseBusinessBasicInfo(String businessName);
}
