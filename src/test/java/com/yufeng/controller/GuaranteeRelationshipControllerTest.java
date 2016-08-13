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
    	String parameter="id=b54edc1c-0675-4bbe-b951-08a4154ad9a5";
    	RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> resultModelResponseEntity = restTemplate
        		.getForEntity(REST_SERVICE_URI + "/GuaranteeRelationship/getById?"+parameter,String.class);
        
        System.out.println(resultModelResponseEntity.getBody());
    }
	
	//@Test
    public void testGetByCode() throws Exception {
        //参数
    	String parameter="code=vrferfre";
    	RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> resultModelResponseEntity = restTemplate
        		.getForEntity(REST_SERVICE_URI + "/GuaranteeRelationship/getByCode?"+parameter,String.class);
        
        System.out.println(resultModelResponseEntity.getBody());
    }
	
	//@Test
    public void testGetByRelateCode() throws Exception {
        //参数
    	String parameter="code=77";
    	RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> resultModelResponseEntity = restTemplate
        		.getForEntity(REST_SERVICE_URI + "/GuaranteeRelationship/getByRelateCode?"+parameter,String.class);
        
        System.out.println(resultModelResponseEntity.getBody());
    }
    
    //@Test
    public void testFoundGuaranteeRelationship() throws Exception {
		//参数
    	RestTemplate restTemplate = new RestTemplate();

    	GuaranteeRelationshipInfo guaranteeRelationshipInfo=new GuaranteeRelationshipInfo();
    	guaranteeRelationshipInfo.setAssure_money(new BigDecimal(11));
    	guaranteeRelationshipInfo.setInternal_code("11");
    	guaranteeRelationshipInfo.setRelate_user_internal_code("11");
    	guaranteeRelationshipInfo.setStatus(11);
    	
        HttpEntity<GuaranteeRelationshipInfo> httpEntity=new HttpEntity<GuaranteeRelationshipInfo>(guaranteeRelationshipInfo);
        ResponseEntity<String> resultModelResponseEntity = restTemplate.
        		exchange(REST_SERVICE_URI + "/GuaranteeRelationship/foundGuaranteeRelationship",HttpMethod.POST,httpEntity,String.class);

        System.out.println(resultModelResponseEntity.getBody());
    }
    
    //@Test
    public void testDeleteGuaranteeRelationship() throws Exception {
    	//参数
    	String parameter="id=0c384bef-6a68-46e8-b115-53a5e2b8f64f";
    	RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> resultModelResponseEntity = restTemplate
        		.getForEntity(REST_SERVICE_URI + "/GuaranteeRelationship/deleteGuaranteeRelationship?"+parameter,String.class);
        
        System.out.println(resultModelResponseEntity.getBody());
    }
    
    @Test
    public void testUpdateGuaranteeRelationship() throws Exception {
    	//参数
    	RestTemplate restTemplate = new RestTemplate();

    	GuaranteeRelationshipInfo guaranteeRelationshipInfo=new GuaranteeRelationshipInfo();
    	guaranteeRelationshipInfo.setAssure_money(new BigDecimal(22));
    	guaranteeRelationshipInfo.setInternal_code("22");
    	guaranteeRelationshipInfo.setRelate_user_internal_code("22");
    	guaranteeRelationshipInfo.setStatus(22);
    	guaranteeRelationshipInfo.setId("0c384bef-6a68-46e8-b115-53a5e2b8f64f");
    	
        HttpEntity<GuaranteeRelationshipInfo> httpEntity=new HttpEntity<GuaranteeRelationshipInfo>(guaranteeRelationshipInfo);
        ResponseEntity<String> resultModelResponseEntity = restTemplate.
        		exchange(REST_SERVICE_URI + "/GuaranteeRelationship/updateGuaranteeRelationship",HttpMethod.POST,httpEntity,String.class);

        System.out.println(resultModelResponseEntity.getBody());
    }

}
