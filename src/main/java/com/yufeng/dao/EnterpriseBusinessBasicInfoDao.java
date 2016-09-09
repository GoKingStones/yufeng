package com.yufeng.dao;

import com.yufeng.entity.EnterpriseBusinessBasicInfo;

/**
 * Created by kingstones on 16/7/24.
 * 企业商户基本信息DAO
 */
public interface EnterpriseBusinessBasicInfoDao {

    int isExistedEnterpriseBusinessBasicInfo(String internalCode);
    //是否存在店铺名称
    int isExistedBusinessName(String businessName);
    int isExistedBusinessLicenseNumber(String businessLicenceNumber);
    EnterpriseBusinessBasicInfo getEnterpriseBusinessBasicInfo(String internalCode);
    int insertEnterpriseBusinessBasicInfo(EnterpriseBusinessBasicInfo enterpriseBusinessBasicInfo);
    int updateEnterpriseBusinessBasicInfo(EnterpriseBusinessBasicInfo enterpriseBusinessBasicInfo);
}
