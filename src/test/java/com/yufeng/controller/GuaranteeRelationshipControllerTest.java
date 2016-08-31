package com.yufeng.controller;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.yufeng.entity.GuaranteeRelationshipInfo;
import com.yufeng.entity.UserBankCardInfo;

/**
 * 担保关系控制层测试类
 * @author dh
  */
public class GuaranteeRelationshipControllerTest {
	
public static final String REST_SERVICE_URI = "http://localhost:8080/yufeng";
	
	//@Test
    public void testGetById() throws Exception {
        //参数
    	String parameter="uniqueId=3";
    	RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> resultModelResponseEntity = restTemplate
        		.getForEntity(REST_SERVICE_URI + "/GuaranteeRelationship/getByUniqueId?"+parameter,String.class);
        
        System.out.println(resultModelResponseEntity.getBody());
    }
	
	//@Test
    public void testGetByCode() throws Exception {
        //参数
    	String parameter="internalCode=11";
    	RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> resultModelResponseEntity = restTemplate
        		.getForEntity(REST_SERVICE_URI + "/GuaranteeRelationship/getByInternalCode?"+parameter,String.class);
        
        System.out.println(resultModelResponseEntity.getBody());
    }
	
	//@Test
    public void testGetByRelateCode() throws Exception {
        //参数
    	String parameter="relateUserInternalCode=22";
    	RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> resultModelResponseEntity = restTemplate
        		.getForEntity(REST_SERVICE_URI + "/GuaranteeRelationship/getByRelateInternalCode?"+parameter,String.class);
        
        System.out.println(resultModelResponseEntity.getBody());
    }
    
    //@Test
    public void testFoundGuaranteeRelationship() throws Exception {
		//参数
    	RestTemplate restTemplate = new RestTemplate();

    	GuaranteeRelationshipInfo guaranteeRelationshipInfo=new GuaranteeRelationshipInfo();
    	guaranteeRelationshipInfo.setAssureMoney(new BigDecimal(11));
    	guaranteeRelationshipInfo.setInternalCode("xx");
    	guaranteeRelationshipInfo.setRelateUserInternalCode("1xdx");
    	guaranteeRelationshipInfo.setStatus(1);
    	
        HttpEntity<GuaranteeRelationshipInfo> httpEntity=new HttpEntity<GuaranteeRelationshipInfo>(guaranteeRelationshipInfo);
        ResponseEntity<String> resultModelResponseEntity = restTemplate.
        		exchange(REST_SERVICE_URI + "/GuaranteeRelationship/foundGuaranteeRelationship",HttpMethod.POST,httpEntity,String.class);

        System.out.println(resultModelResponseEntity.getBody());
    }
    
    //@Test
    public void testDeleteGuaranteeRelationship() throws Exception {
    	//参数
    	String parameter="uniqueId=3";
    	RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> resultModelResponseEntity = restTemplate
        		.getForEntity(REST_SERVICE_URI + "/GuaranteeRelationship/deleteGuaranteeRelationshipByUniqueId?"+parameter,String.class);
        
        System.out.println(resultModelResponseEntity.getBody());
    }
    
    @Test
    public void testUpdateGuaranteeRelationship() throws Exception {
    	//参数
    	RestTemplate restTemplate = new RestTemplate();

    	GuaranteeRelationshipInfo guaranteeRelationshipInfo=new GuaranteeRelationshipInfo();
    	guaranteeRelationshipInfo.setAssureMoney(new BigDecimal(99));
    	guaranteeRelationshipInfo.setInternalCode("ii");
    	guaranteeRelationshipInfo.setRelateUserInternalCode("ii");
    	guaranteeRelationshipInfo.setStatus(1);
    	guaranteeRelationshipInfo.setUniqueId("634c8603-ae13-4102-9688-7f8e7242d7e8");
    	
        HttpEntity<GuaranteeRelationshipInfo> httpEntity=new HttpEntity<GuaranteeRelationshipInfo>(guaranteeRelationshipInfo);
        ResponseEntity<String> resultModelResponseEntity = restTemplate.
        		exchange(REST_SERVICE_URI + "/GuaranteeRelationship/updateGuaranteeRelationship",HttpMethod.POST,httpEntity,String.class);

        System.out.println(resultModelResponseEntity.getBody());
    }

}
