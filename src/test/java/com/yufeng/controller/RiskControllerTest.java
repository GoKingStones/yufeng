package com.yufeng.controller;

import java.util.Iterator;

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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yufeng.entity.TongdunRiskReport;

/**
 * 风险评估控制层测试类
 * @author dh
 */
public class RiskControllerTest {
    
    public static final String REST_SERVICE_URI = "http://localhost:8080/yufeng";
    
    //@Test
    public void riskAssessmentTest() throws Exception {
        //参数
        String parameter="internalCode=piqingqing";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> resultModelResponseEntity = restTemplate
                .getForEntity(REST_SERVICE_URI + "/risk/riskAssessment?"+parameter,String.class);
        System.out.println(resultModelResponseEntity.getBody());
    }
    
    
    @Test
    public void getTongdunRiskReportByInternalCodeTest() throws Exception {
        //参数
        String parameter="internalCode=piqingqing";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> resultModelResponseEntity = restTemplate
                .getForEntity(REST_SERVICE_URI + "/risk/getTongdunRiskReportByInternalCode?"+parameter,String.class);
        
        Iterator<Object> object=JSON.parseArray(resultModelResponseEntity.getBody()).iterator();
        TongdunRiskReport t=JSON.parseObject(String.valueOf(object.next()),TongdunRiskReport.class);
        JSONObject oo=JSON.parseObject(t.getRiskItems());
        String value=String.valueOf(oo.get("674314"));
        JSONObject ooo=JSON.parseObject(value);
        String sss=String.valueOf(ooo.get("item_detail"));
        System.out.println(sss);
    }
    


}
