package com.yufeng.dao;

import com.yufeng.entity.IndividualBusinessBasicInfo;

/**
 * Created by kingstones on 16/7/24.
 * 个体商户基本信息Dao
 */
public interface IndividualBusinessBasicInfoDao {

    int isExistedIndividualBusinessBasicInfo(String shopName);
    IndividualBusinessBasicInfo getIndividualBusinessBasicInfo(String shopName);
    int insertIndividualBusinessBasicInfo(IndividualBusinessBasicInfo individualBusinessBasicInfo);
    int updateIndividualBusinessBasicInfo(IndividualBusinessBasicInfo individualBusinessBasicInfo);
    int deleteIndividualBusinessBasicInfo(String shopName);
}
