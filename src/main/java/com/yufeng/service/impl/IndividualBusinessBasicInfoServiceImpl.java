package com.yufeng.service.impl;

import com.yufeng.dao.EnterpriseBusinessBasicInfoDao;
import com.yufeng.dao.IndividualBusinessBasicInfoDao;
import com.yufeng.dao.InternalCodeDao;
import com.yufeng.entity.EnterpriseBusinessBasicInfo;
import com.yufeng.entity.IndividualBusinessBasicInfo;
import com.yufeng.entity.InternalCode;
import com.yufeng.service.EnterpriseBusinessBasicInfoService;
import com.yufeng.service.IndividualBusinessBasicInfoService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kingstones on 16/7/24.
 */
public class IndividualBusinessBasicInfoServiceImpl implements IndividualBusinessBasicInfoService {


    @Autowired
    private IndividualBusinessBasicInfoDao individualBusinessBasicInfoDao;

    @Autowired
    private InternalCodeDao internalCodeDao;

    public boolean isExistedIndividualBusinessBasicInfo(String internalCode) {
        return individualBusinessBasicInfoDao.isExistedIndividualBusinessBasicInfo(internalCode)==1?true:false;
    }

    public boolean isExistedShopName(String shopName) {
        return individualBusinessBasicInfoDao.isExistedShopName(shopName)==1?true:false;
    }

    public IndividualBusinessBasicInfo getIndividualBusinessBasicInfo(String internalCode) {
        return individualBusinessBasicInfoDao.getIndividualBusinessBasicInfo(internalCode);
    }

    public IndividualBusinessBasicInfo insertIndividualBusinessBasicInfo(IndividualBusinessBasicInfo individualBusinessBasicInfo) {

        int flag  = internalCodeDao.isExistedInternalCode(individualBusinessBasicInfo.getInternalCode());
        if(flag!=1) {
            InternalCode internalCode=new InternalCode();
            internalCode.setInternalCode(individualBusinessBasicInfo.getInternalCode());
            internalCodeDao.insertInternalCode(internalCode);
        }
        int result = individualBusinessBasicInfoDao.insertIndividualBusinessBasicInfo(individualBusinessBasicInfo);
        IndividualBusinessBasicInfo individualBusinessBasicInfo1 = null;
        if(result==1) {
          individualBusinessBasicInfo1 = individualBusinessBasicInfoDao.getIndividualBusinessBasicInfo(individualBusinessBasicInfo.getInternalCode());
        }

        return individualBusinessBasicInfo1;
    }

    public IndividualBusinessBasicInfo updateIndividualBusinessBasicInfo(IndividualBusinessBasicInfo individualBusinessBasicInfo) {
        int result =  individualBusinessBasicInfoDao.updateIndividualBusinessBasicInfo(individualBusinessBasicInfo);
        IndividualBusinessBasicInfo individualBusinessBasicInfo1 = null;

        if(result==1) {
            individualBusinessBasicInfo1 =  individualBusinessBasicInfoDao.getIndividualBusinessBasicInfo(individualBusinessBasicInfo.getInternalCode());
        }

        return individualBusinessBasicInfo1;
    }

}
