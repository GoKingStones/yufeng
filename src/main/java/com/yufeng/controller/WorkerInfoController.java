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
	@RequestMapping(value = "/getWorkerInfoByWorkerName",method = RequestMethod.GET)
	public ResponseEntity<ResultModel> getWorkerInfoByWorkerName(@RequestParam("workerName") String workerName){

		WorkerInfo  workerInfo =workerInfoService.getWorkerInfoByWorkerName(workerName);
		if (workerInfo!=null) {
			return new ResponseEntity<ResultModel>(ResultModel.ok(workerInfo), HttpStatus.OK);
		}else {
			return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.USER_NOT_FOUND),HttpStatus.OK);
		}

    }


	@RequestMapping(value = "/getWorkerInfoByPhoneNumber",method = RequestMethod.GET)
	public ResponseEntity<ResultModel> getWorkerInfoByPhoneNumber(@RequestParam("phoneNumber") String phoneNumber){

		WorkerInfo  workerInfo =workerInfoService.getWorkerInfoByPhoneNumber(phoneNumber);
		if (workerInfo!=null) {
			return new ResponseEntity<ResultModel>(ResultModel.ok(workerInfo), HttpStatus.OK);
		}else {
			return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.USER_NOT_FOUND),HttpStatus.OK);
		}
	}


	@RequestMapping(value = "/insertWorkerInfo",method = RequestMethod.POST)
	public ResponseEntity<ResultModel> insertWorkerInfo(@RequestBody WorkerInfo workerInfo){
		WorkerInfo workerInfo2=workerInfoService.getWorkerInfoByWorkerName(workerInfo.getWorkerName());
		if (workerInfo==null) {

			Map<String,String> map=new HashMap<String, String>();
			map.put("workerName","is existed");
			return new ResponseEntity<ResultModel>(ResultModel.ok(map),HttpStatus.OK);
		}

		WorkerInfo workerInfo3=workerInfoService.getWorkerInfoByPhoneNumber(workerInfo.getPhoneNumber());
		if (workerInfo==null) {
			Map<String,String> map=new HashMap<String, String>();
			map.put("workerPhoneNumber","is existed");
			return new ResponseEntity<ResultModel>(ResultModel.ok(map),HttpStatus.OK);

		}

		WorkerInfo  workerInfo1 =workerInfoService.insertWorkerInfo(workerInfo);
		if (workerInfo1!=null) {
			return new ResponseEntity<ResultModel>(ResultModel.ok(workerInfo1), HttpStatus.OK);
		}else {
			return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.USER_NOT_FOUND),HttpStatus.OK);
		}
	}

	@RequestMapping(value = "updateWorkerInfo",method = RequestMethod.POST)
	public ResponseEntity<ResultModel> updateWorkerInfo(@RequestBody WorkerInfo workerInfo){

		if(workerInfo.getPhoneNumber()!=null) {
			WorkerInfo workerInfo3=workerInfoService.getWorkerInfoByPhoneNumber(workerInfo.getPhoneNumber());
			if (workerInfo==null) {
				Map<String,String> map=new HashMap<String, String>();
				map.put("workerPhoneNumber","is existed");
				return new ResponseEntity<ResultModel>(ResultModel.ok(map),HttpStatus.OK);

			}
		}

		WorkerInfo  workerInfo1 =workerInfoService.updateWorkerInfo(workerInfo);
		if (workerInfo1!=null) {
			return new ResponseEntity<ResultModel>(ResultModel.ok(workerInfo1), HttpStatus.OK);
		}else {
			return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.USER_NOT_FOUND),HttpStatus.OK);
		}

	}

	@RequestMapping(value = "updateWorkerInfoByAdmin",method = RequestMethod.POST)
	public ResponseEntity<ResultModel> updateWorkerInfoByAdmin(@RequestBody WorkerInfo workerInfo){

		if (workerInfo.getWorkerName()!=null) {
			WorkerInfo workerInfo2=workerInfoService.getWorkerInfoByWorkerName(workerInfo.getWorkerName());
			if (workerInfo==null) {

				Map<String,String> map=new HashMap<String, String>();
				map.put("workerName","is existed");
				return new ResponseEntity<ResultModel>(ResultModel.ok(map),HttpStatus.OK);
			}
		}

		if(workerInfo.getPhoneNumber()!=null) {
			WorkerInfo workerInfo3=workerInfoService.getWorkerInfoByPhoneNumber(workerInfo.getPhoneNumber());
			if (workerInfo==null) {
				Map<String,String> map=new HashMap<String, String>();
				map.put("workerPhoneNumber","is existed");
				return new ResponseEntity<ResultModel>(ResultModel.ok(map),HttpStatus.OK);

			}
		}

		WorkerInfo  workerInfo1 =workerInfoService.updateWorkerInfoByAdmin(workerInfo);
		if (workerInfo1!=null) {
			return new ResponseEntity<ResultModel>(ResultModel.ok(workerInfo1), HttpStatus.OK);
		}else {
			return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.USER_NOT_FOUND),HttpStatus.OK);
		}
	}




}
