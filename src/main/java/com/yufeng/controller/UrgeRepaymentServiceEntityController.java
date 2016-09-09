package com.yufeng.controller;

import com.yufeng.config.ResultStatus;
import com.yufeng.entity.UrgeRepaymentServiceEntity;
import com.yufeng.entity.WorkerInfo;
import com.yufeng.service.UrgeRepaymentServiceEntityService;
import com.yufeng.util.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 催收服务控制层
 * @author kingstones
  */
@RestController
@RequestMapping("urgeRepaymentService")
public class UrgeRepaymentServiceEntityController {
	
	@Autowired
	private UrgeRepaymentServiceEntityService urgeRepaymentServiceEntityService;

	@RequestMapping(value = "/getUrgeRepaymentServiceEntityByWorkerId",method = RequestMethod.GET)
	public ResponseEntity<ResultModel> getUrgeRepaymentServiceEntityByWorkerId(@RequestParam("workerId") int workerId){

		List<UrgeRepaymentServiceEntity> urgeRepaymentServiceEntity = urgeRepaymentServiceEntityService.getUrgeRepaymentServiceEntityByWorkerId(workerId);

		if (urgeRepaymentServiceEntity!=null) {
			return new ResponseEntity<ResultModel>(ResultModel.ok(urgeRepaymentServiceEntity), HttpStatus.OK);
		}else {
			return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
		}
    }

	@RequestMapping(value = "/getUrgeRepaymentServiceEntityByInternalCode",method = RequestMethod.GET)
	public ResponseEntity<ResultModel> getUrgeRepaymentServiceEntityByInternalCode(@RequestParam("internalCode") String internalCode){

		List<UrgeRepaymentServiceEntity> urgeRepaymentServiceEntity = urgeRepaymentServiceEntityService.getUrgeRepaymentServiceEntityByInternalCode(internalCode);

		if (urgeRepaymentServiceEntity!=null) {
			return new ResponseEntity<ResultModel>(ResultModel.ok(urgeRepaymentServiceEntity), HttpStatus.OK);
		}else {
			return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
		}

	}

	@RequestMapping(value = "/insertUrgeRepaymentServiceEntity",method = RequestMethod.POST)
	public ResponseEntity<ResultModel> insertUrgeRepaymentServiceEntity(@RequestBody UrgeRepaymentServiceEntity urgeRepaymentServiceEntity){

		UrgeRepaymentServiceEntity urgeRepaymentServiceEntity1 = urgeRepaymentServiceEntityService.insertUrgeRepaymentServiceEntity(urgeRepaymentServiceEntity);
		if (urgeRepaymentServiceEntity1!=null) {
			return new ResponseEntity<ResultModel>(ResultModel.ok(urgeRepaymentServiceEntity1), HttpStatus.OK);
		}else {
			return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/updateUrgeRepaymentServiceEntity",method = RequestMethod.POST)
	public ResponseEntity<ResultModel> updateUrgeRepaymentServiceEntity(@RequestBody UrgeRepaymentServiceEntity urgeRepaymentServiceEntity){
		UrgeRepaymentServiceEntity urgeRepaymentServiceEntity1 = urgeRepaymentServiceEntityService.updateUrgeRepaymentServiceEntity(urgeRepaymentServiceEntity);
		if (urgeRepaymentServiceEntity1!=null) {
			return new ResponseEntity<ResultModel>(ResultModel.ok(urgeRepaymentServiceEntity1), HttpStatus.OK);
		}else {
			return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
		}
	}





}
