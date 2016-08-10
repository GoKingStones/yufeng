package com.yufeng.controller;

import com.yufeng.algorithm.MD5Util;
import com.yufeng.entity.RegisterAccount;
import com.yufeng.entity.UserBankCardInfo;
import com.yufeng.entity.WorkerInfo;
import com.yufeng.service.WorkerInfoService;
import com.yufeng.service.impl.BankCardServiceImpl;
import com.yufeng.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 客服员工控制层
 * @author kingstones
  */
@RestController
@RequestMapping("/workerInfo")
public class WorkerInfoController {
	
	@Autowired
	private WorkerInfoService workerInfoService;
	
	//
	@RequestMapping("/getWorkerInfoByWorkerName")
	public Map<String,String> getWorkerInfoByWorkerName(@RequestParam("workerName") String workerName){

		WorkerInfo workerInfo=null;
		ResultMap resultMap=new ResultMap();
		Map<String,String> result=new HashMap<String, String>();
		if(!workerName.equals("")) {
			workerInfo=workerInfoService.getWorkerInfoByWorkerName(workerName);
			if (workerInfo!=null) {
				result=resultMap.getSuccessMap();
				result.put("workerInfo",workerInfo.toString());
			}else {
				result=resultMap.getErrorMap();
				result.put("content","select error");
			}

		}

		return result;

    }

	//
	@RequestMapping("/getWorkerInfoByOrgId")
	public Map<String,String> getWorkerInfoByOrgId(@RequestParam("orgId") String orgId){

		WorkerInfo workerInfo=null;
		ResultMap resultMap=new ResultMap();
		Map<String,String> result=new HashMap<String, String>();
		if(!orgId.equals("")) {
			workerInfo=workerInfoService.getWorkerInfoByOrgId(orgId);
			if (workerInfo!=null) {
				result=resultMap.getSuccessMap();
				result.put("workerInfo",workerInfo.toString());
			}else {
				result=resultMap.getErrorMap();
				result.put("content","select error");
			}

		}

		return result;


	}

	//
	@RequestMapping("/getWorkerInfoByPhoneNumber")
	public Map<String,String> getWorkerInfoByPhoneNumber(@RequestParam("phoneNumber") String phoneNumber){

		WorkerInfo workerInfo=null;
		ResultMap resultMap=new ResultMap();
		Map<String,String> result=new HashMap<String, String>();
		if(!phoneNumber.equals("")) {
			workerInfo=workerInfoService.getWorkerInfoByPhoneNumber(phoneNumber);
			if (workerInfo!=null) {
				result=resultMap.getSuccessMap();
				result.put("workerInfo",workerInfo.toString());
			}else {
				result=resultMap.getErrorMap();
				result.put("content","select error");
			}

		}

		return result;
	}


	@RequestMapping("insertWorkerInfo")
	@ResponseBody
	public Map<String,String> insertWorkerInfo(@RequestBody WorkerInfo workerInfo){


		ResultMap resultMap=new ResultMap();


		workerInfo.setPassword(MD5Util.string2MD5(workerInfo.getPassword()));
		int result = workerInfoService.insertWorkerInfo(workerInfo);

		if (result==0) {
			return resultMap.getErrorMap();
		}else {
			return resultMap.getSuccessMap();
		}
	}

	@RequestMapping("updateWorkerInfo")
	@ResponseBody
	public Map<String,String> updateWorkerInfo(@RequestBody WorkerInfo workerInfo){


		ResultMap resultMap=new ResultMap();

		workerInfo.setPassword(MD5Util.string2MD5(workerInfo.getPassword()));
		int result = workerInfoService.updateWorkerInfo(workerInfo);

		if (result==0) {
			return resultMap.getErrorMap();
		}else {
			return resultMap.getSuccessMap();
		}
	}





}
