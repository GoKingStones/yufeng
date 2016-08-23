package com.yufeng.controller;

import com.yufeng.algorithm.MD5Util;
import com.yufeng.config.ResultStatus;
import com.yufeng.entity.InterviewServiceEntity;
import com.yufeng.entity.WorkerInfo;
import com.yufeng.service.InterviewServiceEntityService;
import com.yufeng.service.WorkerInfoService;
import com.yufeng.util.ResultMap;
import com.yufeng.util.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 面签服务控制层
 * @author kingstones
  */
@RestController
@RequestMapping("interviewService")
public class InterviewServiceEntityController {
	
	@Autowired
	private InterviewServiceEntityService interviewServiceEntityService;
	
	//
	@RequestMapping("/getInterviewServiceEntityByWorkerId")
	public ResponseEntity<ResultModel> getInterviewServiceEntityByWorkerId(@RequestParam("workerId") int workerId){

		List<InterviewServiceEntity> interviewServiceEntity = interviewServiceEntityService.getInterviewServiceEntityByWorkerId(workerId);
		if (interviewServiceEntity!=null) {
			return new ResponseEntity<ResultModel>(ResultModel.ok(interviewServiceEntity), HttpStatus.OK);
		}else {
			return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
		}

    }

	@RequestMapping("/getInterviewServiceEntityByInternalCode")
	public ResponseEntity<ResultModel> getInterviewServiceEntityByInternalCode(@RequestParam("internalCode") String internalCode){

		List<InterviewServiceEntity> interviewServiceEntity = interviewServiceEntityService.getInterviewServiceEntityByInternalCode(internalCode);
		if (interviewServiceEntity!=null) {
			return new ResponseEntity<ResultModel>(ResultModel.ok(interviewServiceEntity), HttpStatus.OK);
		}else {
			return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
		}

	}


	@RequestMapping("/insertInterviewServiceEntity")
	public ResponseEntity<ResultModel> insertInterviewServiceEntity(@RequestBody InterviewServiceEntity interviewServiceEntity){

		InterviewServiceEntity interviewServiceEntity1 = interviewServiceEntityService.insertInterviewServiceEntity(interviewServiceEntity);
		if (interviewServiceEntity1!=null) {
			return new ResponseEntity<ResultModel>(ResultModel.ok(interviewServiceEntity1), HttpStatus.OK);
		}else {
			return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
		}
	}

	@RequestMapping("/updateInterviewServiceEntity")
	public ResponseEntity<ResultModel> updateInterviewServiceEntity(@RequestBody InterviewServiceEntity interviewServiceEntity){

		InterviewServiceEntity interviewServiceEntity1 = interviewServiceEntityService.updateInterviewServiceEntity(interviewServiceEntity);
		if (interviewServiceEntity1!=null) {
			return new ResponseEntity<ResultModel>(ResultModel.ok(interviewServiceEntity1), HttpStatus.OK);
		}else {
			return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
		}
	}





}
