package com.yufeng.controller;

import com.yufeng.config.ResultStatus;
import com.yufeng.entity.CustomServiceEntity;
import com.yufeng.entity.UrgeRepaymentServiceEntity;
import com.yufeng.service.CustomServiceEntityService;
import com.yufeng.service.CustomServiceEntityService;
import com.yufeng.util.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 客服服务控制层
 * @author kingstones
  */
@RestController
@RequestMapping("customService")
public class CustomServiceEntityController {
	
	@Autowired
	private CustomServiceEntityService customServiceEntityService;
	
	//通过客服ID获取客服服务信息
	@RequestMapping(value = "/getCustomServiceEntityByWorkerId",method = RequestMethod.GET)
	public  ResponseEntity<ResultModel> getCustomServiceEntityByWorkerId(@RequestParam("workerId") int workerId){

		List<CustomServiceEntity> customServiceEntity = customServiceEntityService.getCustomServiceEntityByWorkerId(workerId);

		if (customServiceEntity!=null) {
			return new ResponseEntity<ResultModel>(ResultModel.ok(customServiceEntity), HttpStatus.OK);
		}else {
			return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
		}

    }

	@RequestMapping(value = "/getCustomServiceEntityByInternalCode",method = RequestMethod.GET)
	public ResponseEntity<ResultModel> getCustomServiceEntityByInternalCode(@RequestParam("internalCode") String internalCode){


		List<CustomServiceEntity> customServiceEntity = customServiceEntityService.getCustomServiceEntityByInternalCode(internalCode);

		if (customServiceEntity!=null) {
			return new ResponseEntity<ResultModel>(ResultModel.ok(customServiceEntity), HttpStatus.OK);
		}else {
			return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
		}

	}


	@RequestMapping(value = "/insertCustomServiceEntity",method = RequestMethod.POST)
	public ResponseEntity<ResultModel> insertCustomServiceEntity(@RequestBody CustomServiceEntity customServiceEntity){

		CustomServiceEntity customServiceEntity1= customServiceEntityService.insertCustomServiceEntity(customServiceEntity);

		if (customServiceEntity1!=null) {
			return new ResponseEntity<ResultModel>(ResultModel.ok(customServiceEntity1), HttpStatus.OK);
		}else {
			return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/updateCustomServiceEntity",method = RequestMethod.POST)
	public ResponseEntity<ResultModel> updateCustomServiceEntity(@RequestBody CustomServiceEntity customServiceEntity){

		CustomServiceEntity customServiceEntity1= customServiceEntityService.updateCustomServiceEntity(customServiceEntity);

		if (customServiceEntity1!=null) {
			return new ResponseEntity<ResultModel>(ResultModel.ok(customServiceEntity1), HttpStatus.OK);
		}else {
			return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
		}
	}





}
