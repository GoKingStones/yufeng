package com.yufeng.controller;

import com.yufeng.entity.UrgeRepaymentServiceEntity;
import com.yufeng.service.UrgeRepaymentServiceEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 客服服务控制层
 * @author kingstones
  */
@RestController
@RequestMapping("/urgeRepaymentService")
public class UrgeRepaymentServiceEntityController {
	
	@Autowired
	private UrgeRepaymentServiceEntityService urgeRepaymentServiceEntityService;
	
	//
	@RequestMapping("/getUrgeRepaymentServiceEntityByWorkerId")
	public Map<Object,Object> getUrgeRepaymentServiceEntityByWorkerId(@RequestParam("workerId") int workerId){

		urgeRepaymentServiceEntityService.getUrgeRepaymentServiceEntityByWorkerId(workerId);
		return null;

    }

	@RequestMapping("/getUrgeRepaymentServiceEntityByInternalCode")
	public Map<Object,Object> getUrgeRepaymentServiceEntityByInternalCode(@RequestParam("internalCode") String internalCode){

		urgeRepaymentServiceEntityService.getUrgeRepaymentServiceEntityByInternalCode(internalCode);
		return null;

	}


	@RequestMapping("insertUrgeRepaymentServiceEntity")
	@ResponseBody
	public Map<Object,Object> insertUrgeRepaymentServiceEntity(@RequestBody UrgeRepaymentServiceEntity urgeRepaymentServiceEntity){

		urgeRepaymentServiceEntityService.insertUrgeRepaymentServiceEntity(urgeRepaymentServiceEntity);
		return null;
	}

	@RequestMapping("updateUrgeRepaymentServiceEntity")
	@ResponseBody
	public Map<Object,Object> updateUrgeRepaymentServiceEntity(@RequestBody UrgeRepaymentServiceEntity urgeRepaymentServiceEntity){

		urgeRepaymentServiceEntityService.updateUrgeRepaymentServiceEntity(urgeRepaymentServiceEntity);
		return null;
	}





}
