package com.yufeng.service;

import com.yufeng.entity.EnterpriseBusinessBasicInfo;
import com.yufeng.entity.IndividualBusinessBasicInfo;

/**
 * Created by kingstones on 16/7/24.
 */
public interface IndividualBusinessBasicInfoService {

    int isExistedIndividualBusinessBasicInfo(String shopName);
    IndividualBusinessBasicInfo getIndividualBusinessBasicInfo(String shopName);
    int insertIndividualBusinessBasicInfo(IndividualBusinessBasicInfo individualBusinessBasicInfo);
    int updateIndividualBusinessBasicInfo(IndividualBusinessBasicInfo individualBusinessBasicInfo);
    int deleteIndividualBusinessBasicInfo(String shopName);
}
