package com.yufeng.controller;

import com.yufeng.algorithm.MD5Util;
import com.yufeng.entity.InterviewServiceEntity;
import com.yufeng.entity.WorkerInfo;
import com.yufeng.service.InterviewServiceEntityService;
import com.yufeng.service.WorkerInfoService;
import com.yufeng.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 面签服务控制层
 * @author kingstones
  */
@RestController
@RequestMapping("/interviewService")
public class InterviewServiceEntityController {
	
	@Autowired
	private InterviewServiceEntityService interviewServiceEntityService;
	
	//
	@RequestMapping("/getInterviewServiceEntityByWorkerId")
	public Map<Object,Object> getInterviewServiceEntityByWorkerId(@RequestParam("workerId") int workerId){

		interviewServiceEntityService.getInterviewServiceEntityByWorkerId(workerId);
		return null;

    }

	@RequestMapping("/getInterviewServiceEntityByInternalCode")
	public Map<Object,Object> getInterviewServiceEntityByInternalCode(@RequestParam("internalCode") String internalCode){

		interviewServiceEntityService.getInterviewServiceEntityByInternalCode(internalCode);
		return null;

	}


	@RequestMapping("insertInterviewServiceEntity")
	@ResponseBody
	public Map<Object,Object> insertInterviewServiceEntity(@RequestBody InterviewServiceEntity interviewServiceEntity){

		interviewServiceEntityService.insertInterviewServiceEntity(interviewServiceEntity);
		return null;
	}

	@RequestMapping("updateInterviewServiceEntity")
	@ResponseBody
	public Map<Object,Object> updateInterviewServiceEntity(@RequestBody InterviewServiceEntity interviewServiceEntity){

		interviewServiceEntityService.updateInterviewServiceEntity(interviewServiceEntity);
		return null;
	}





}
