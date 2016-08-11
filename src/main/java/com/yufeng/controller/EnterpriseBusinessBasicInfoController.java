package com.yufeng.controller;

import com.yufeng.entity.EnterpriseBusinessBasicInfo;
import com.yufeng.entity.UserFamilyInfo;
import com.yufeng.service.EnterpriseBusinessBasicInfoService;
import com.yufeng.service.impl.UserFamilyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 企业商户基本信息Controller层
 * @author kingstones
  */

@RestController
@RequestMapping("EnterpriseBusinessBasicInfo")
public class EnterpriseBusinessBasicInfoController {
	
	@Autowired
	private EnterpriseBusinessBasicInfoService enterpriseBusinessBasicInfoService;
	
	
	//查询企业商户信息
	@RequestMapping("/getEnterpriseBusinessBasicInfo")
	public EnterpriseBusinessBasicInfo getEnterpriseBusinessBasicInfo(String businessName){

		//
		EnterpriseBusinessBasicInfo info=enterpriseBusinessBasicInfoService.getEnterpriseBusinessBasicInfo(businessName);
		return info;
	}
	
	//插入企业商户信息
	@RequestMapping("/insertEnterpriseBusinessBasicInfo")
	public String insertEnterpriseBusinessBasicInfo(EnterpriseBusinessBasicInfo enterpriseBusinessBasicInfo){

		enterpriseBusinessBasicInfoService.insertEnterpriseBusinessBasicInfo(enterpriseBusinessBasicInfo);
		return "ok";	
	}
		
	//企业商户修改
	@RequestMapping("/updateEnterpriseBusinessBasicInfo")
	public String updateEnterpriseBusinessBasicInfo(EnterpriseBusinessBasicInfo  enterpriseBusinessBasicInfo){
		enterpriseBusinessBasicInfoService.updateEnterpriseBusinessBasicInfo(enterpriseBusinessBasicInfo);
		return "ok";	
	}
		
	//删除企业商户
	@RequestMapping("/deleteEnterpriseBusinessBasicInfo")
	public String deleteEnterpriseBusinessBasicInfo(String  businessName){
		enterpriseBusinessBasicInfoService.deleteEnterpriseBusinessBasicInfo(businessName);
		return "ok";	
	}
 
}
