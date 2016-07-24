package com.yufeng.service.impl;

import com.yufeng.dao.EnterpriseBusinessBasicInfoDao;
import com.yufeng.dao.IndividualBusinessBasicInfoDao;
import com.yufeng.entity.EnterpriseBusinessBasicInfo;
import com.yufeng.entity.IndividualBusinessBasicInfo;
import com.yufeng.service.EnterpriseBusinessBasicInfoService;
import com.yufeng.service.IndividualBusinessBasicInfoService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kingstones on 16/7/24.
 */
public class IndividualBusinessBasicInfoServiceImpl implements IndividualBusinessBasicInfoService {


    @Autowired
    IndividualBusinessBasicInfoDao individualBusinessBasicInfoDao;

    public int isExistedIndividualBusinessBasicInfo(String shopName) {
        return individualBusinessBasicInfoDao.isExistedIndividualBusinessBasicInfo(shopName);
    }

    public IndividualBusinessBasicInfo getIndividualBusinessBasicInfo(String shopName) {
        return individualBusinessBasicInfoDao.getIndividualBusinessBasicInfo(shopName);
    }

    public int insertIndividualBusinessBasicInfo(IndividualBusinessBasicInfo individualBusinessBasicInfo) {
        return individualBusinessBasicInfoDao.insertIndividualBusinessBasicInfo(individualBusinessBasicInfo);
    }

    public int updateIndividualBusinessBasicInfo(IndividualBusinessBasicInfo individualBusinessBasicInfo) {
        return individualBusinessBasicInfoDao.updateIndividualBusinessBasicInfo(individualBusinessBasicInfo);
    }

    public int deleteIndividualBusinessBasicInfo(String shopName) {
        return individualBusinessBasicInfoDao.deleteIndividualBusinessBasicInfo(shopName);
    }
}
