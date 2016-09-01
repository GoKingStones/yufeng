package com.yufeng.service;

import java.util.List;

import com.yufeng.entity.SchoolExperienceInfo;
import com.yufeng.util.ResultModel;

/**
 * Created by fishyu on 16/7/23.
 */
public interface SchoolExperienceInfoService {

    boolean isExistedSchoolExperienceInfo(int uniqueId,String internalCode);
    List<SchoolExperienceInfo> getSchoolExperienceInfoByInternalCode(String internalCode);
    ResultModel insertSchoolExperienceInfo(SchoolExperienceInfo schoolExperienceInfo);
    ResultModel updateSchoolExperienceInfo(SchoolExperienceInfo schoolExperienceInfo);
    ResultModel deleteSchoolExperienceInfo(SchoolExperienceInfo schoolExperienceInfo);
    List<SchoolExperienceInfo> getSchoolExperienceInfoByInternalCodeForCreditLine(String internalCode);
    
}
