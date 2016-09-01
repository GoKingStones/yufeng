package com.yufeng.service.impl;

import com.yufeng.config.ResultStatus;
import com.yufeng.dao.SchoolExperienceInfoDao;
import com.yufeng.entity.SchoolExperienceInfo;
import com.yufeng.service.SchoolExperienceInfoService;
import com.yufeng.util.ResultModel;

import java.util.ArrayList;
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

	
	/**插入学业信息
	 * @param SchoolExperienceInfo schoolExperienceInfo
	 * @return ResultModel
	 * */
	public ResultModel insertSchoolExperienceInfo(SchoolExperienceInfo schoolExperienceInfo) {
		
		try{
			List<SchoolExperienceInfo> schoolExperienceInfoList = new ArrayList<SchoolExperienceInfo>();
			
			schoolExperienceInfoList = getSchoolExperienceInfoByInternalCodeAndSchoolName(schoolExperienceInfo.getInternalCode(),schoolExperienceInfo.getSchoolCode());
			//判断是否已经有该学业信息，通过此人的内码以及学校编号，一个人在一个学校只有一条数据。双学历不考虑在内。
			if(schoolExperienceInfoList.isEmpty()){
				schoolExperienceInfoDao.insertSchoolExperienceInfo(schoolExperienceInfo);
				
				List<SchoolExperienceInfo> schoolExperienceInfoListInserted = new ArrayList<SchoolExperienceInfo>();
				schoolExperienceInfoListInserted = getSchoolExperienceInfoByInternalCodeAndSchoolName(schoolExperienceInfo.getInternalCode(),schoolExperienceInfo.getSchoolCode());
				//查询是否插入成功
				if(schoolExperienceInfoListInserted.size()==1){
					for(SchoolExperienceInfo tmpSchoolExperienceInfo:schoolExperienceInfoListInserted){
						schoolExperienceInfo.setUniqueId(tmpSchoolExperienceInfo.getUniqueId());
					}
				}else{
					return ResultModel.error(ResultStatus.INTERNAL_SERVER_ERROR,schoolExperienceInfo);
				}
				
				return ResultModel.ok(schoolExperienceInfo);
			
			}else{
				return ResultModel.error(ResultStatus.ALREADY_EXISTED,schoolExperienceInfo);	
			}
			
		}catch(Exception e){
			return ResultModel.error(ResultStatus.INTERNAL_SERVER_ERROR,schoolExperienceInfo);
		}
		
	}

	
	
	/**更新一条学业信息
	 * @param SchoolExperienceInfo schoolExperienceInfo
	 * @return ResultModel
	 * */
	public ResultModel updateSchoolExperienceInfo(SchoolExperienceInfo schoolExperienceInfo) {
		
		try{
			SchoolExperienceInfo schoolExperienceInfoNow = getSchoolExperienceInfo(schoolExperienceInfo.getUniqueId(),schoolExperienceInfo.getInternalCode());
			//判断是否已经有该学业信息
			if(schoolExperienceInfoNow!=null){
				schoolExperienceInfoDao.updateSchoolExperienceInfo(schoolExperienceInfo);
				
				SchoolExperienceInfo schoolExperienceInfoUpdated = getSchoolExperienceInfo(schoolExperienceInfo.getUniqueId(),schoolExperienceInfo.getInternalCode());
				//查询是否修改成功
				if(schoolExperienceInfoUpdated!=null){
					return ResultModel.ok(schoolExperienceInfoUpdated);
				}else{
					return ResultModel.error(ResultStatus.INTERNAL_SERVER_ERROR,schoolExperienceInfo);
				}
			}else{
				//数据不存在
				return ResultModel.error(ResultStatus.NOT_EXISTED,schoolExperienceInfo);	
			}
			
		}catch(Exception e){
			return ResultModel.error(ResultStatus.INTERNAL_SERVER_ERROR,schoolExperienceInfo);
		}
		
		
	}

	public boolean isExistedSchoolExperienceInfo(int uniqueId,String internalCode) {
		int count =schoolExperienceInfoDao.isExistedSchoolExperienceInfo(uniqueId, internalCode);
        boolean result =false;
        if(count !=0) result=true;
        return result;
	}


	public ResultModel deleteSchoolExperienceInfo(SchoolExperienceInfo schoolExperienceInfo) {
				
		try{	
			SchoolExperienceInfo schoolExperienceInfoNow = getSchoolExperienceInfo(schoolExperienceInfo.getUniqueId(),schoolExperienceInfo.getInternalCode());
			//判断是否已经有该学业信息
			if(schoolExperienceInfoNow!=null){
				schoolExperienceInfoDao.deleteSchoolExperienceInfo(schoolExperienceInfo);
				
				SchoolExperienceInfo schoolExperienceInfoDeleted = getSchoolExperienceInfo(schoolExperienceInfo.getUniqueId(),schoolExperienceInfo.getInternalCode());
				//查询是否删除成功
				if(schoolExperienceInfoDeleted!=null){
					return ResultModel.ok(schoolExperienceInfoDeleted);
				}else{
					return ResultModel.error(ResultStatus.INTERNAL_SERVER_ERROR,schoolExperienceInfo);
				}
			}else{
				//数据不存在
				return ResultModel.error(ResultStatus.NOT_EXISTED,schoolExperienceInfo);	
			}
			
		}catch(Exception e){
			return ResultModel.error(ResultStatus.INTERNAL_SERVER_ERROR,schoolExperienceInfo);
		}
	}
	
	
	public SchoolExperienceInfo getSchoolExperienceInfo(int uniqueId,String internalCode) {
		return schoolExperienceInfoDao.getSchoolExperienceInfo(uniqueId,internalCode);
	}
	

	public List<SchoolExperienceInfo> getSchoolExperienceInfoByInternalCodeForCreditLine(String internalCode) {
		return schoolExperienceInfoDao.getSchoolExperienceInfoByInternalCodeForCreditLine(internalCode);
	}
	
	
	public List<SchoolExperienceInfo> getSchoolExperienceInfoByInternalCodeAndSchoolName(String internalCode,String schoolCode) {
		return schoolExperienceInfoDao.getSchoolExperienceInfoByInternalCodeAndSchoolName(internalCode, schoolCode);
	}
}
