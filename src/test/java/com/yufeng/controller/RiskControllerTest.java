package com.yufeng.controller;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * 风险评估控制层测试类
 * @author dh
 */
public class RiskControllerTest {
    
    public static final String REST_SERVICE_URI = "http://localhost:8080/yufeng";
    
    @Test
    public void riskAssessmentTest() throws Exception {
        //参数
        String parameter="internalCode=piqingqing";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> resultModelResponseEntity = restTemplate
                .getForEntity(REST_SERVICE_URI + "/risk/riskAssessment?"+parameter,String.class);
        System.out.println(resultModelResponseEntity.getBody());
    }
    


}
