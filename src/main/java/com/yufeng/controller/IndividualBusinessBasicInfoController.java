package com.yufeng.controller;

import com.yufeng.config.ResultStatus;
import com.yufeng.entity.EnterpriseBusinessBasicInfo;
import com.yufeng.entity.IndividualBusinessBasicInfo;
import com.yufeng.service.IndividualBusinessBasicInfoService;
import com.yufeng.util.InternalCodeGenerator;
import com.yufeng.util.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 个体商户基本信息Controller层
 * @author kingstones
  */

@RestController
@RequestMapping("individualBusinessBasicInfo")
public class IndividualBusinessBasicInfoController {
	
	@Autowired
	private IndividualBusinessBasicInfoService individualBusinessBasicInfoService;
	
	
	//查询个体商户信息
	@RequestMapping(value = "/getIndividualBusinessBasicInfo",method = RequestMethod.GET)
	public ResponseEntity<ResultModel> getIndividualBusinessBasicInfo(@RequestParam String internalCode){

		boolean flag = individualBusinessBasicInfoService.isExistedIndividualBusinessBasicInfo(internalCode);
		if (!flag) {
			return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.USER_NOT_FOUND), HttpStatus.OK);
		}
		IndividualBusinessBasicInfo info=individualBusinessBasicInfoService.getIndividualBusinessBasicInfo(internalCode);
		if (info!=null) {
			return new ResponseEntity<ResultModel>(ResultModel.ok(info), HttpStatus.OK);
		}else {
			return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
		}
	}
	
	//插入个体商户信息
	@RequestMapping(value = "/insertIndividualBusinessBasicInfo",method = RequestMethod.POST)
	public ResponseEntity<ResultModel> insertIndividualBusinessBasicInfo(@RequestBody IndividualBusinessBasicInfo individualBusinessBasicInfo){
		String internalCode = InternalCodeGenerator.getCode(individualBusinessBasicInfo.getShopkeeperCertificateType(), individualBusinessBasicInfo.getShopkeeperCertificateNumber());
		individualBusinessBasicInfo.setInternalCode(internalCode);
		boolean flag = individualBusinessBasicInfoService.isExistedIndividualBusinessBasicInfo(internalCode);
		if (flag) {
			return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.ALREADY_EXISTED,individualBusinessBasicInfo.getShopkeeperCertificateNumber()),HttpStatus.OK);
		}

		flag=individualBusinessBasicInfoService.isExistedShopName(individualBusinessBasicInfo.getShopName());
		if (flag) {
			Map<String,String> map=new HashMap<String,String>();
			map.put("shopName",individualBusinessBasicInfo.getShopName());
			return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.ALREADY_EXISTED,map),HttpStatus.OK);
		}

		IndividualBusinessBasicInfo individualBusinessBasicInfo1 =individualBusinessBasicInfoService.insertIndividualBusinessBasicInfo(individualBusinessBasicInfo);
		if (individualBusinessBasicInfo1!=null) {
			return new ResponseEntity<ResultModel>(ResultModel.ok(individualBusinessBasicInfo1), HttpStatus.OK);
		}else {
			return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
		}
	}
		
	//个体商户修改
	@RequestMapping(value = "/updateIndividualBusinessBasicInfo",method = RequestMethod.POST)
	public ResponseEntity<ResultModel> updateIndividualBusinessBasicInfo(@RequestBody IndividualBusinessBasicInfo  individualBusinessBasicInfo){

		if(individualBusinessBasicInfo.getShopName()!=null) {
			boolean flag=individualBusinessBasicInfoService.isExistedShopName(individualBusinessBasicInfo.getShopName());
			if (flag) {
				Map<String,String> map=new HashMap<String,String>();
				map.put("shopName",individualBusinessBasicInfo.getShopName());
				return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.ALREADY_EXISTED,map),HttpStatus.OK);
			}
		}

		IndividualBusinessBasicInfo individualBusinessBasicInfo1 =individualBusinessBasicInfoService.updateIndividualBusinessBasicInfo(individualBusinessBasicInfo);
		if (individualBusinessBasicInfo1!=null) {
			return new ResponseEntity<ResultModel>(ResultModel.ok(individualBusinessBasicInfo1), HttpStatus.OK);
		}else {
			return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
		}
	}

 
}
