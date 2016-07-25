package com.yufeng.controller;

import com.yufeng.entity.SchoolExperienceInfo;
import com.yufeng.service.SchoolExperienceInfoService;
import com.yufeng.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by fishyu on 16/7/23.
 */
@RestController
public class SchoolExperienceInfoController {

    @Autowired
    private SchoolExperienceInfoService schoolExperienceInfoService;

    
    @RequestMapping("isExistedSchoolExperienceInfo")

    public boolean isExistedSchoolExperienceInfo(@RequestParam("uniqueId") int uniqueId,@RequestParam("internalCode") String internalCode) {

        boolean result = schoolExperienceInfoService.isExistedSchoolExperienceInfo(uniqueId, internalCode);
        return result;
    }

    @RequestMapping("getSchoolExperienceInfoByInternalCode")
    public List<SchoolExperienceInfo> getSchoolExperienceInfoByInternalCode(@RequestParam("internalCode") String internalCode){

    	List<SchoolExperienceInfo> schoolExperienceInfoList = new ArrayList<SchoolExperienceInfo>();
    	schoolExperienceInfoList = schoolExperienceInfoService.getSchoolExperienceInfoByInternalCode(internalCode);
        
        return schoolExperienceInfoList;
    }

    @RequestMapping("insertSchoolExperienceInfo")
    @ResponseBody
    public Map<String,String> insertSchoolExperienceInfo(@RequestBody SchoolExperienceInfo schoolExperienceInfo) throws ParseException{

    	ResultMap resultMap=new ResultMap();
    	
    	if(schoolExperienceInfoService.isExistedSchoolExperienceInfo(schoolExperienceInfo.getUniqueId(), schoolExperienceInfo.getInternalCode())){
    		
    		return resultMap.getExistIDErrorMap();
    		
    	}else{
    		 
    		int result = schoolExperienceInfoService.insertSchoolExperienceInfo(schoolExperienceInfo);
    		
    		if (result==0) {
 	            return resultMap.getErrorMap();
 	        }else {
 	            return resultMap.getSuccessMap();
 	        }
    	}

    }

    @RequestMapping("updateSchoolExperienceInfo")
    public Map<String,String> updateSchoolExperienceInfo(SchoolExperienceInfo schoolExperienceInfo) {

        ResultMap resultMap=new ResultMap();
        
        if(schoolExperienceInfoService.isExistedSchoolExperienceInfo(schoolExperienceInfo.getUniqueId(), schoolExperienceInfo.getInternalCode())){
        	
    	    int result=schoolExperienceInfoService.updateSchoolExperienceInfo(schoolExperienceInfo);
    	    if (result==0) {
    	        return resultMap.getErrorMap();
    	    }else {
    	        return resultMap.getSuccessMap();
    	    }
    	   
        }else{
        	
        	return resultMap.getnotExistIDErrorMap();
        	
        }
    }
    
    
    @RequestMapping("deleteSchoolExperienceInfo")
    public Map<String,String> deleteSchoolExperienceInfo(SchoolExperienceInfo schoolExperienceInfo) {

        ResultMap resultMap=new ResultMap();
        
        if(schoolExperienceInfoService.isExistedSchoolExperienceInfo(schoolExperienceInfo.getUniqueId(), schoolExperienceInfo.getInternalCode())){
        	
    	    int result=schoolExperienceInfoService.deleteSchoolExperienceInfo(schoolExperienceInfo);
    	    if (result==0) {
    	        return resultMap.getErrorMap();
    	    }else {
    	        return resultMap.getSuccessMap();
    	    }
    	   
        }else{
        	
        	return resultMap.getnotExistIDErrorMap();
        	
        }
    }

}
