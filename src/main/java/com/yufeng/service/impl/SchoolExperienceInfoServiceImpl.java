package com.yufeng.service.impl;

import com.yufeng.dao.SchoolExperienceInfoDao;
import com.yufeng.entity.SchoolExperienceInfo;
import com.yufeng.service.SchoolExperienceInfoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by fishyu on 16/7/23.
 */
public class SchoolExperienceInfoServiceImpl implements SchoolExperienceInfoService{

    @Autowired
    private SchoolExperienceInfoDao schoolExperienceInfoDao;

	public List<SchoolExperienceInfo> getSchoolExperienceInfoByInternalCode(String internalCode) {
		return schoolExperienceInfoDao.getSchoolExperienceInfoByInternalCode(internalCode);
	}

	public int insertSchoolExperienceInfo(SchoolExperienceInfo schoolExperienceInfo) {
		
		return schoolExperienceInfoDao.insertSchoolExperienceInfo(schoolExperienceInfo);
	}

	public int updateSchoolExperienceInfo(SchoolExperienceInfo schoolExperienceInfo) {
		return schoolExperienceInfoDao.updateSchoolExperienceInfo(schoolExperienceInfo);
	}

	public boolean isExistedSchoolExperienceInfo(int uniqueId,String internalCode) {
		int count =schoolExperienceInfoDao.isExistedSchoolExperienceInfo(uniqueId, internalCode);
        boolean result =false;
        if(count !=0) result=true;
        return result;
	}


	public int deleteSchoolExperienceInfo(SchoolExperienceInfo schoolExperienceInfo) {
		
		if(schoolExperienceInfo.getWhoDid()!=null && schoolExperienceInfo.getWhoDid().trim().equals("")){
		
			return schoolExperienceInfoDao.deleteSchoolExperienceInfo(schoolExperienceInfo);
		
		}else{
			
			return 0;
			
		}
		
	}

	
}
