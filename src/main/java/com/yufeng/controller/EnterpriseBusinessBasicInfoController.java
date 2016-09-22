package com.yufeng.controller;

import com.yufeng.config.ResultStatus;
import com.yufeng.entity.EnterpriseBusinessBasicInfo;
import com.yufeng.entity.UserFamilyInfo;
import com.yufeng.service.EnterpriseBusinessBasicInfoService;
import com.yufeng.service.impl.UserFamilyServiceImpl;
import com.yufeng.util.InternalCodeGenerator;
import com.yufeng.util.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 企业商户基本信息Controller层
 * @author kingstones
  */

@RestController
@RequestMapping("enterpriseBusinessBasicInfo")
public class EnterpriseBusinessBasicInfoController {
	
	@Autowired
	private EnterpriseBusinessBasicInfoService enterpriseBusinessBasicInfoService;
	
	
	//查询企业商户信息
	@RequestMapping(value = "/getEnterpriseBusinessBasicInfo",method = RequestMethod.GET)
	public ResponseEntity<ResultModel> getEnterpriseBusinessBasicInfo(@RequestParam String internalCode){

		boolean flag = enterpriseBusinessBasicInfoService.isExistedEnterpriseBusinessBasicInfo(internalCode);
		if (!flag) {
			return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.USER_NOT_FOUND,internalCode),HttpStatus.OK);
		}

		EnterpriseBusinessBasicInfo info=enterpriseBusinessBasicInfoService.getEnterpriseBusinessBasicInfo(internalCode);
		if (info!=null) {
			return new ResponseEntity<ResultModel>(ResultModel.ok(info), HttpStatus.OK);
		}else {
			return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
		}
	}
	
	//插入企业商户信息
	@RequestMapping(value = "/insertEnterpriseBusinessBasicInfo",method = RequestMethod.POST)
	public ResponseEntity<ResultModel> insertEnterpriseBusinessBasicInfo(@RequestBody EnterpriseBusinessBasicInfo enterpriseBusinessBasicInfo){

		String internalCode = InternalCodeGenerator.getCode(enterpriseBusinessBasicInfo.getLegalPersonCertificateType(),enterpriseBusinessBasicInfo.getLegalPersonCertificateNumber());
		enterpriseBusinessBasicInfo.setInternalCode(internalCode);
		boolean flag = enterpriseBusinessBasicInfoService.isExistedEnterpriseBusinessBasicInfo(internalCode);
		if (flag) {
			return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.ALREADY_EXISTED),HttpStatus.OK);
		}

		flag=enterpriseBusinessBasicInfoService.isExistedBusinessName(enterpriseBusinessBasicInfo.getBusinessName());
		if (flag) {
			Map<String,String> map=new HashMap<String,String>();
			map.put("businessName",enterpriseBusinessBasicInfo.getBusinessName());
			return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.ALREADY_EXISTED,map),HttpStatus.OK);
		}

		flag=enterpriseBusinessBasicInfoService.isExistedBusinessLicenseNumber(enterpriseBusinessBasicInfo.getBusinessLicenseNumber());
		if (flag) {
			Map<String,String> map=new HashMap<String,String>();
			map.put("businessLicenseNumber",enterpriseBusinessBasicInfo.getBusinessLicenseNumber());
			return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.ALREADY_EXISTED,map),HttpStatus.OK);
		}

		EnterpriseBusinessBasicInfo enterpriseBusinessBasicInfo1 =enterpriseBusinessBasicInfoService.insertEnterpriseBusinessBasicInfo(enterpriseBusinessBasicInfo);
		if (enterpriseBusinessBasicInfo1!=null) {
			return new ResponseEntity<ResultModel>(ResultModel.ok(enterpriseBusinessBasicInfo1), HttpStatus.OK);
		}else {
			return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
		}
	}
		
	//企业商户修改
	@RequestMapping(value = "/updateEnterpriseBusinessBasicInfo",method = RequestMethod.POST)
	public ResponseEntity<ResultModel> updateEnterpriseBusinessBasicInfo(@RequestBody EnterpriseBusinessBasicInfo  enterpriseBusinessBasicInfo){

		boolean flag;

		if(enterpriseBusinessBasicInfo.getBusinessName()!=null) {
			flag=enterpriseBusinessBasicInfoService.isExistedBusinessName(enterpriseBusinessBasicInfo.getBusinessName());
			if (flag) {
				Map<String,String> map=new HashMap<String,String>();
				map.put("businessName",enterpriseBusinessBasicInfo.getBusinessName());
				return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.ALREADY_EXISTED,map),HttpStatus.OK);
			}
		}

		if(enterpriseBusinessBasicInfo.getBusinessLicenseNumber()!=null) {
			flag=enterpriseBusinessBasicInfoService.isExistedBusinessLicenseNumber(enterpriseBusinessBasicInfo.getBusinessLicenseNumber());
			if (flag) {
				Map<String,String> map=new HashMap<String,String>();
				map.put("businessLicenceNumber",enterpriseBusinessBasicInfo.getBusinessLicenseNumber());
				return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.ALREADY_EXISTED,map),HttpStatus.OK);
			}

		}

		EnterpriseBusinessBasicInfo enterpriseBusinessBasicInfo1 =enterpriseBusinessBasicInfoService.updateEnterpriseBusinessBasicInfo(enterpriseBusinessBasicInfo);
		if (enterpriseBusinessBasicInfo1!=null) {
			return new ResponseEntity<ResultModel>(ResultModel.ok(enterpriseBusinessBasicInfo1), HttpStatus.OK);
		}else {
			return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
		}
	}
		

}
