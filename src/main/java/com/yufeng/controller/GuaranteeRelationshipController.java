package com.yufeng.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yufeng.entity.GuaranteeRelationshipInfo;
import com.yufeng.service.GuaranteeRelationshipService;

/**
 * 担保关系控制层
 * @author dh
  */
@RestController
@RequestMapping("/GuaranteeRelationship")
public class GuaranteeRelationshipController {
	
	@Autowired
	private GuaranteeRelationshipService guaranteeRelationshipService;
	
	//查询银行卡信息(id)
	@RequestMapping("/getById")
	public Map<String, Object> getById(String id){
		return guaranteeRelationshipService.getById(id);
	}
	
	//查看我的担保圈(我被谁担保)
	@RequestMapping("/getByCode")
	public Map<String, Object> getByCode(String code){
		return guaranteeRelationshipService.getByCode(code);
	}
	
	//查看我的担保圈(我担保谁)
	@RequestMapping("/getByRelateCode")
	public Map<String, Object> getByRelateCode(String code){
		return guaranteeRelationshipService.getByRelateCode(code);
	}
	
	//创建担保关系
	@RequestMapping("/foundGuaranteeRelationship")
	public String foundGuaranteeRelationship(GuaranteeRelationshipInfo info){
		return guaranteeRelationshipService.foundGuaranteeRelationship(info);
	}
	
	//取消担保关系
	@RequestMapping("/deleteGuaranteeRelationship")
	public String deleteGuaranteeRelationship(String id){
		return guaranteeRelationshipService.deleteGuaranteeRelationship(id);
	}
	
	//修改担保关系
	@RequestMapping("/updateGuaranteeRelationship")
	public String updateGuaranteeRelationship(GuaranteeRelationshipInfo info){
		return guaranteeRelationshipService.updateGuaranteeRelationship(info);
	}

}
