package com.yufeng.dao;

import java.util.List;

import com.yufeng.entity.SchoolExperienceInfo;

/**
 * Created by fishyu on 16/7/23
 */
public interface SchoolExperienceInfoDao {

    int isExistedSchoolExperienceInfo(int uniqueId,String internalCode);
    List<SchoolExperienceInfo> getSchoolExperienceInfoByInternalCode(String internalCode);
    int insertSchoolExperienceInfo(SchoolExperienceInfo schoolExperienceInfo);
    int updateSchoolExperienceInfo(SchoolExperienceInfo schoolExperienceInfo);
    int deleteSchoolExperienceInfo(SchoolExperienceInfo schoolExperienceInfo);
    
}
