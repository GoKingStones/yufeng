package com.yufeng.service;

import com.yufeng.entity.EnterpriseBusinessBasicInfo;

/**
 * Created by kingstones on 16/7/24.
 */
public interface EnterpriseBusinessBasicInfoService {

    boolean isExistedEnterpriseBusinessBasicInfo(String internalCode);

    //是否存在店铺名称
    boolean isExistedBusinessName(String businessName);
    public boolean isExistedBusinessLicenseNumber(String businessLicenceNumber);
    EnterpriseBusinessBasicInfo getEnterpriseBusinessBasicInfo(String internalCode);
    EnterpriseBusinessBasicInfo insertEnterpriseBusinessBasicInfo(EnterpriseBusinessBasicInfo enterpriseBusinessBasicInfo);
    EnterpriseBusinessBasicInfo updateEnterpriseBusinessBasicInfo(EnterpriseBusinessBasicInfo enterpriseBusinessBasicInfo);

}
