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
	@RequestMapping(value = "/getInterviewServiceEntityByWorkerId",method = RequestMethod.GET)
	public ResponseEntity<ResultModel> getInterviewServiceEntityByWorkerId(@RequestParam("workerId") int workerId){

		List<InterviewServiceEntity> interviewServiceEntity = interviewServiceEntityService.getInterviewServiceEntityByWorkerId(workerId);
		if (interviewServiceEntity!=null) {
			return new ResponseEntity<ResultModel>(ResultModel.ok(interviewServiceEntity), HttpStatus.OK);
		}else {
			return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
		}

    }

	@RequestMapping(value = "/getInterviewServiceEntityByInternalCode",method = RequestMethod.GET)
	public ResponseEntity<ResultModel> getInterviewServiceEntityByInternalCode(@RequestParam("internalCode") String internalCode){

		List<InterviewServiceEntity> interviewServiceEntity = interviewServiceEntityService.getInterviewServiceEntityByInternalCode(internalCode);
		if (interviewServiceEntity!=null) {
			return new ResponseEntity<ResultModel>(ResultModel.ok(interviewServiceEntity), HttpStatus.OK);
		}else {
			return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
		}

	}


	@RequestMapping(value = "/insertInterviewServiceEntity",method = RequestMethod.POST)
	public ResponseEntity<ResultModel> insertInterviewServiceEntity(@RequestBody InterviewServiceEntity interviewServiceEntity){

		InterviewServiceEntity interviewServiceEntity1 = interviewServiceEntityService.insertInterviewServiceEntity(interviewServiceEntity);
		if (interviewServiceEntity1!=null) {
			return new ResponseEntity<ResultModel>(ResultModel.ok(interviewServiceEntity1), HttpStatus.OK);
		}else {
			return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/updateInterviewServiceEntity",method = RequestMethod.POST)
	public ResponseEntity<ResultModel> updateInterviewServiceEntity(@RequestBody InterviewServiceEntity interviewServiceEntity){

		InterviewServiceEntity interviewServiceEntity1 = interviewServiceEntityService.updateInterviewServiceEntity(interviewServiceEntity);
		if (interviewServiceEntity1!=null) {
			return new ResponseEntity<ResultModel>(ResultModel.ok(interviewServiceEntity1), HttpStatus.OK);
		}else {
			return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
		}
	}

	//获取用户的面签结果
	@RequestMapping(value = "/getInterviewResultByInternalCode",method = RequestMethod.GET)
	public ResponseEntity<ResultModel> getInterviewResultByInternalCode(@RequestParam("internalCode") String internalCode){

		String interviewResult =interviewServiceEntityService.getInterviewResultByInternalCode(internalCode);
		Map<String,String> map = new HashMap<String, String>();
		if (interviewResult==null) {
			map.put("internalCode",internalCode);
			map.put("interviewResult","无面签纪录");
			return new ResponseEntity<ResultModel>(ResultModel.ok(map), HttpStatus.OK);

		}else {
			map.put("internalCode",internalCode);
			map.put("interviewResult",interviewResult);
			return new ResponseEntity<ResultModel>(ResultModel.ok(map), HttpStatus.OK);
		}
	}

}
