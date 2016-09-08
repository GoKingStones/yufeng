package com.yufeng.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yufeng.config.ResultStatus;
import com.yufeng.entity.GuaranteeRelationshipInfo;
import com.yufeng.service.GuaranteeRelationshipService;
import com.yufeng.util.ResultModel;
import com.yufeng.util.Utils;

/**
 * 担保关系控制层
 * @author dh
 */
@RestController
@RequestMapping("/GuaranteeRelationship")
public class GuaranteeRelationshipController {
	
	@Autowired
	private GuaranteeRelationshipService guaranteeRelationshipService;
	
	//查询我的担保圈(id)
	@RequestMapping("/getByUniqueId")
	public Map<String, Object> getById(String uniqueId){
		return guaranteeRelationshipService.getById(uniqueId);
	}
	
	//查看我的担保圈(我被谁担保)
	@RequestMapping("/getByInternalCode")
	public Map<String, Object> getByCode(String internalCode){
		return guaranteeRelationshipService.getByCode(internalCode);
	}
	
	//查看我的担保圈(我担保谁)
	@RequestMapping("/getByRelateInternalCode")
	public Map<String, Object> getByRelateCode(String relateUserInternalCode){
		return guaranteeRelationshipService.getByRelateCode(relateUserInternalCode);
	}
	
	//创建担保关系
	@RequestMapping("/foundGuaranteeRelationship")
	public ResponseEntity<ResultModel> foundGuaranteeRelationship(@RequestBody GuaranteeRelationshipInfo info){
		String type=guaranteeRelationshipService.foundGuaranteeRelationship(info);
		if(Utils.RETURN_VALUE_CODE_1.equals(type)){
            return new ResponseEntity<ResultModel>(ResultModel.ok(),HttpStatus.OK);
        }else if(Utils.RETURN_VALUE_CODE_2.equals(type)){
            return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.GUARANTEERELATION_NUMBER_ERROR),HttpStatus.OK);
        }else if(Utils.RETURN_VALUE_CODE_3.equals(type)){
            return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.GUARANTEERELATION_NUMBER1_ERROR),HttpStatus.OK);
        }else if(Utils.RETURN_VALUE_CODE_99.equals(type)){
            return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.GUARANTEERELATION_REPEAT),HttpStatus.OK);
        }else{
            return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
        }
	}
	
	//取消担保关系
	@RequestMapping("/deleteGuaranteeRelationshipByUniqueId")
	public ResponseEntity<ResultModel> deleteGuaranteeRelationship(String uniqueId){
		String type=guaranteeRelationshipService.deleteGuaranteeRelationship(uniqueId);
		if(Utils.RETURN_VALUE_CODE_1.equals(type)){
            return new ResponseEntity<ResultModel>(ResultModel.ok(),HttpStatus.OK);
        }else{
            return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
        }
	}
	
	//修改担保关系
	@RequestMapping("/updateGuaranteeRelationship")
	public ResponseEntity<ResultModel> updateGuaranteeRelationship(@RequestBody GuaranteeRelationshipInfo info){
	    String type=guaranteeRelationshipService.updateGuaranteeRelationship(info);
		if(Utils.RETURN_VALUE_CODE_1.equals(type)){
            return new ResponseEntity<ResultModel>(ResultModel.ok(),HttpStatus.OK);
        }else{
            return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.OPERATION_FAILURE),HttpStatus.OK);
        }
	}

}
