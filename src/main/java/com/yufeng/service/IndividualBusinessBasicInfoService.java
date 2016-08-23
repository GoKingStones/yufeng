package com.yufeng.service;

import com.yufeng.entity.EnterpriseBusinessBasicInfo;
import com.yufeng.entity.IndividualBusinessBasicInfo;

/**
 * Created by kingstones on 16/7/24.
 */
public interface IndividualBusinessBasicInfoService {

    boolean isExistedIndividualBusinessBasicInfo(String internalCode);
    boolean isExistedShopName(String shopName);
    IndividualBusinessBasicInfo getIndividualBusinessBasicInfo(String internalCode);
    IndividualBusinessBasicInfo insertIndividualBusinessBasicInfo(IndividualBusinessBasicInfo individualBusinessBasicInfo);
    IndividualBusinessBasicInfo updateIndividualBusinessBasicInfo(IndividualBusinessBasicInfo individualBusinessBasicInfo);
}
