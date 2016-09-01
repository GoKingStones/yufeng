package com.yufeng.controller;

import com.yufeng.config.ResultStatus;
import com.yufeng.entity.SchoolExperienceInfo;
import com.yufeng.service.SchoolExperienceInfoService;
import com.yufeng.util.ResultModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by fishyu on 16/7/23.
 */
@RestController
@RequestMapping("schoolExperienceInfo")
public class SchoolExperienceInfoController {

    @Autowired
    private SchoolExperienceInfoService schoolExperienceInfoService;

    @RequestMapping(value = "/getSchoolExperienceInfoByInternalCode",method = RequestMethod.GET)
    public ResponseEntity<ResultModel> getSchoolExperienceInfoByInternalCode(@RequestParam("internalCode") String internalCode){

    	List<SchoolExperienceInfo> schoolExperienceInfoList = new ArrayList<SchoolExperienceInfo>();
    	schoolExperienceInfoList = schoolExperienceInfoService.getSchoolExperienceInfoByInternalCode(internalCode);
        
    	if (schoolExperienceInfoList!=null && schoolExperienceInfoList.size()>0) {
            return new ResponseEntity<ResultModel>(ResultModel.ok(schoolExperienceInfoList),HttpStatus.OK);
        }else {
            return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
        }
        
        
    }

    @RequestMapping(value = "/insertSchoolExperienceInfo",method = RequestMethod.POST)
    public ResponseEntity<ResultModel> insertSchoolExperienceInfo(@RequestBody SchoolExperienceInfo schoolExperienceInfoList) throws ParseException{

    	ResultModel resultModel = schoolExperienceInfoService.insertSchoolExperienceInfo(schoolExperienceInfoList);
    	return new ResponseEntity<ResultModel>(resultModel,HttpStatus.OK);

    }

    @RequestMapping(value = "/updateSchoolExperienceInfo",method = RequestMethod.POST)
    public ResponseEntity<ResultModel> updateSchoolExperienceInfo(@RequestBody SchoolExperienceInfo schoolExperienceInfo) {
    	
    	ResultModel resultModel = schoolExperienceInfoService.updateSchoolExperienceInfo(schoolExperienceInfo);
    	return new ResponseEntity<ResultModel>(resultModel,HttpStatus.OK);
    	
    }
    
    
    @RequestMapping(value = "/deleteSchoolExperienceInfo",method = RequestMethod.POST)
    public ResponseEntity<ResultModel> deleteSchoolExperienceInfo(@RequestBody SchoolExperienceInfo schoolExperienceInfo) {

    	ResultModel resultModel = schoolExperienceInfoService.deleteSchoolExperienceInfo(schoolExperienceInfo);
    	return new ResponseEntity<ResultModel>(resultModel,HttpStatus.OK);
    }

}
