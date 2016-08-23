package com.yufeng.controller;

import com.yufeng.algorithm.MD5Util;
import com.yufeng.config.ResultStatus;
import com.yufeng.entity.RegisterAccount;
import com.yufeng.entity.UserBankCardInfo;
import com.yufeng.entity.WorkerInfo;
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
 * 客服员工控制层
 * @author kingstones
  */
@RestController
@RequestMapping("workerInfo")
public class WorkerInfoController {
	
	@Autowired
	private WorkerInfoService workerInfoService;
	
	//
	@RequestMapping("/getWorkerInfoByWorkerName")
	public ResponseEntity<ResultModel> getWorkerInfoByWorkerName(@RequestParam("workerName") String workerName){

		WorkerInfo  workerInfo =workerInfoService.getWorkerInfoByWorkerName(workerName);
		if (workerInfo!=null) {
			return new ResponseEntity<ResultModel>(ResultModel.ok(workerInfo), HttpStatus.OK);
		}else {
			return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.USER_NOT_FOUND),HttpStatus.OK);
		}

    }

	//
	@RequestMapping("/getWorkerInfoByOrgId")
	public ResponseEntity<ResultModel> getWorkerInfoByOrgId(@RequestParam("orgId") String orgId){

		WorkerInfo  workerInfo =workerInfoService.getWorkerInfoByOrgId(orgId);
		if (workerInfo!=null) {
			return new ResponseEntity<ResultModel>(ResultModel.ok(workerInfo), HttpStatus.OK);
		}else {
			return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.USER_NOT_FOUND),HttpStatus.OK);
		}

	}

	//
	@RequestMapping("/getWorkerInfoByPhoneNumber")
	public ResponseEntity<ResultModel> getWorkerInfoByPhoneNumber(@RequestParam("phoneNumber") String phoneNumber){

		WorkerInfo  workerInfo =workerInfoService.getWorkerInfoByPhoneNumber(phoneNumber);
		if (workerInfo!=null) {
			return new ResponseEntity<ResultModel>(ResultModel.ok(workerInfo), HttpStatus.OK);
		}else {
			return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.USER_NOT_FOUND),HttpStatus.OK);
		}
	}


	@RequestMapping("/insertWorkerInfo")
	public ResponseEntity<ResultModel> insertWorkerInfo(@RequestBody WorkerInfo workerInfo){



		WorkerInfo  workerInfo1 =workerInfoService.insertWorkerInfo(workerInfo);
		if (workerInfo1!=null) {
			return new ResponseEntity<ResultModel>(ResultModel.ok(workerInfo1), HttpStatus.OK);
		}else {
			return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.USER_NOT_FOUND),HttpStatus.OK);
		}
	}

	@RequestMapping("updateWorkerInfo")
	public ResponseEntity<ResultModel> updateWorkerInfo(@RequestBody WorkerInfo workerInfo){

		WorkerInfo  workerInfo1 =workerInfoService.updateWorkerInfo(workerInfo);
		if (workerInfo1!=null) {
			return new ResponseEntity<ResultModel>(ResultModel.ok(workerInfo1), HttpStatus.OK);
		}else {
			return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.USER_NOT_FOUND),HttpStatus.OK);
		}

	}

	@RequestMapping("updateWorkerInfoByAdmin")
	public ResponseEntity<ResultModel> updateWorkerInfoByAdmin(@RequestBody WorkerInfo workerInfo){

		WorkerInfo  workerInfo1 =workerInfoService.updateWorkerInfo(workerInfo);
		if (workerInfo1!=null) {
			return new ResponseEntity<ResultModel>(ResultModel.ok(workerInfo1), HttpStatus.OK);
		}else {
			return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.USER_NOT_FOUND),HttpStatus.OK);
		}
	}




}
