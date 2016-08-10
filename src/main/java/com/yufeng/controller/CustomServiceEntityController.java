package com.yufeng.controller;

import com.yufeng.entity.CustomServiceEntity;
import com.yufeng.service.CustomServiceEntityService;
import com.yufeng.service.CustomServiceEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 客服服务控制层
 * @author kingstones
  */
@RestController
@RequestMapping("/customService")
public class CustomServiceEntityController {
	
	@Autowired
	private CustomServiceEntityService customServiceEntityService;
	
	//
	@RequestMapping("/getCustomServiceEntityByWorkerId")
	public Map<Object,Object> getCustomServiceEntityByWorkerId(@RequestParam("workerId") int workerId){

		customServiceEntityService.getCustomServiceEntityByWorkerId(workerId);
		return null;

    }

	@RequestMapping("/getCustomServiceEntityByInternalCode")
	public Map<Object,Object> getCustomServiceEntityByInternalCode(@RequestParam("internalCode") String internalCode){

		customServiceEntityService.getCustomServiceEntityByInternalCode(internalCode);
		return null;

	}


	@RequestMapping("insertCustomServiceEntity")
	@ResponseBody
	public Map<Object,Object> insertCustomServiceEntity(@RequestBody CustomServiceEntity customServiceEntity){

		customServiceEntityService.insertCustomServiceEntity(customServiceEntity);
		return null;
	}

	@RequestMapping("updateCustomServiceEntity")
	@ResponseBody
	public Map<Object,Object> updateCustomServiceEntity(@RequestBody CustomServiceEntity customServiceEntity){

		customServiceEntityService.updateCustomServiceEntity(customServiceEntity);
		return null;
	}





}
