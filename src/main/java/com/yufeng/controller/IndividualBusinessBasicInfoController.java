package com.yufeng.controller;

import com.yufeng.entity.IndividualBusinessBasicInfo;
import com.yufeng.service.IndividualBusinessBasicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 个体商户基本信息Controller层
 * @author kingstones
  */

@RestController
@RequestMapping("/IndividualBusinessBasicInfo")
public class IndividualBusinessBasicInfoController {
	
	@Autowired
	private IndividualBusinessBasicInfoService individualBusinessBasicInfoService;
	
	
	//查询个体商户信息
	@RequestMapping("/getIndividualBusinessBasicInfo")
	public IndividualBusinessBasicInfo getIndividualBusinessBasicInfo(String shopName){

		individualBusinessBasicInfoService.isExistedIndividualBusinessBasicInfo(shopName);
		IndividualBusinessBasicInfo info=individualBusinessBasicInfoService.getIndividualBusinessBasicInfo(shopName);
		return info;
	}
	
	//插入个体商户信息
	@RequestMapping("/insertIndividualBusinessBasicInfo")
	public String insertIndividualBusinessBasicInfo(IndividualBusinessBasicInfo individualBusinessBasicInfo){

		individualBusinessBasicInfoService.insertIndividualBusinessBasicInfo(individualBusinessBasicInfo);
		return "ok";	
	}
		
	//个体商户修改
	@RequestMapping("/updateIndividualBusinessBasicInfo")
	public String updateIndividualBusinessBasicInfo(IndividualBusinessBasicInfo  individualBusinessBasicInfo){
		individualBusinessBasicInfoService.updateIndividualBusinessBasicInfo(individualBusinessBasicInfo);
		return "ok";	
	}
		
	//删除个体商户
	@RequestMapping("/deleteIndividualBusinessBasicInfo")
	public String deleteIndividualBusinessBasicInfo(String  businessName){
		individualBusinessBasicInfoService.deleteIndividualBusinessBasicInfo(businessName);
		return "ok";	
	}
 
}
