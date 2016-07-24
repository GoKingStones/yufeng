package com.yufeng.service.impl;

import com.yufeng.dao.EnterpriseBusinessBasicInfoDao;
import com.yufeng.entity.EnterpriseBusinessBasicInfo;
import com.yufeng.service.EnterpriseBusinessBasicInfoService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kingstones on 16/7/24.
 */
public class EnterpriseBusinessBasicInfoServiceImpl implements EnterpriseBusinessBasicInfoService {

    @Autowired
    private EnterpriseBusinessBasicInfoDao enterpriseBusinessBasicInfoDao;

    public int isExistedEnterpriseBusinessBasicInfo(String businessName) {
        return enterpriseBusinessBasicInfoDao.isExistedEnterpriseBusinessBasicInfo(businessName);
    }

    public EnterpriseBusinessBasicInfo getEnterpriseBusinessBasicInfo(String businessName) {
        return enterpriseBusinessBasicInfoDao.getEnterpriseBusinessBasicInfo(businessName);
    }

    public int insertEnterpriseBusinessBasicInfo(EnterpriseBusinessBasicInfo enterpriseBusinessBasicInfo) {
        return enterpriseBusinessBasicInfoDao.insertEnterpriseBusinessBasicInfo(enterpriseBusinessBasicInfo);
    }

    public int updateEnterpriseBusinessBasicInfo(EnterpriseBusinessBasicInfo enterpriseBusinessBasicInfo) {
        return enterpriseBusinessBasicInfoDao.updateEnterpriseBusinessBasicInfo(enterpriseBusinessBasicInfo);
    }

    public int deleteEnterpriseBusinessBasicInfo(String businessName) {
        return enterpriseBusinessBasicInfoDao.deleteEnterpriseBusinessBasicInfo(businessName);
    }
}
