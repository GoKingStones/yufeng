package com.yufeng.service.impl;

import com.yufeng.dao.EnterpriseBusinessBasicInfoDao;
import com.yufeng.dao.InternalCodeDao;
import com.yufeng.entity.EnterpriseBusinessBasicInfo;
import com.yufeng.entity.InternalCode;
import com.yufeng.service.EnterpriseBusinessBasicInfoService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kingstones on 16/7/24.
 */
public class EnterpriseBusinessBasicInfoServiceImpl implements EnterpriseBusinessBasicInfoService {

    @Autowired
    private EnterpriseBusinessBasicInfoDao enterpriseBusinessBasicInfoDao;

    @Autowired
    private InternalCodeDao internalCodeDao;

    public boolean isExistedEnterpriseBusinessBasicInfo(String businessName) {
        return enterpriseBusinessBasicInfoDao.isExistedEnterpriseBusinessBasicInfo(businessName)==1?true:false;
    }

    public boolean isExistedBusinessName(String businessName) {
        return enterpriseBusinessBasicInfoDao.isExistedBusinessName(businessName)==1?true:false;
    }

    public boolean isExistedBusinessLicenceManagementScope(String businessLicenceManagementScope) {
        return enterpriseBusinessBasicInfoDao.isExistedBusinessLicenceManagementScope(businessLicenceManagementScope)==1?true:false;
    }

    public EnterpriseBusinessBasicInfo getEnterpriseBusinessBasicInfo(String internalCode) {
        return enterpriseBusinessBasicInfoDao.getEnterpriseBusinessBasicInfo(internalCode);
    }

    public EnterpriseBusinessBasicInfo insertEnterpriseBusinessBasicInfo(EnterpriseBusinessBasicInfo enterpriseBusinessBasicInfo) {

        int flag  = internalCodeDao.isExistedInternalCode(enterpriseBusinessBasicInfo.getInternalCode());
        if(flag!=1) {
            InternalCode internalCode=new InternalCode();
            internalCode.setInternalCode(enterpriseBusinessBasicInfo.getInternalCode());
            internalCodeDao.insertInternalCode(internalCode);
        }
        int result = enterpriseBusinessBasicInfoDao.insertEnterpriseBusinessBasicInfo(enterpriseBusinessBasicInfo);
        if(result==1) {
            return enterpriseBusinessBasicInfoDao.getEnterpriseBusinessBasicInfo(enterpriseBusinessBasicInfo.getInternalCode());
        }else {
            return null;
        }

    }

    public EnterpriseBusinessBasicInfo updateEnterpriseBusinessBasicInfo(EnterpriseBusinessBasicInfo enterpriseBusinessBasicInfo) {

        int result =  enterpriseBusinessBasicInfoDao.updateEnterpriseBusinessBasicInfo(enterpriseBusinessBasicInfo);
        if(result==1) {
            return enterpriseBusinessBasicInfoDao.getEnterpriseBusinessBasicInfo(enterpriseBusinessBasicInfo.getInternalCode());
        }else {
            return null;
        }
    }


}
