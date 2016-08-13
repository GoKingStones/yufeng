package com.yufeng.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.yufeng.entity.FastConsumerLoanOrder;
import com.yufeng.entity.FastConsumerLoanOrderCommodity;
import com.yufeng.entity.UserBankCardInfo;

/**
 * 快速消费品分期订单控制层测试类
 * @author dh
 */
public class FastConsumerLoanOrderControllerTest {
	
public static final String REST_SERVICE_URI = "http://localhost:8080/yufeng";
	
	@Test
    public void testGetFastConsumerLoanOrder() throws Exception {
        //参数
    	String parameter="order_id=11";
    	RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> resultModelResponseEntity = restTemplate
        		.getForEntity(REST_SERVICE_URI + "/FastConsumerLoanOrder/getFastConsumerLoanOrder?"+parameter,String.class);
        
        System.out.println(resultModelResponseEntity.getBody());
    }
	
	@Test
	public void testInsertFastConsumerLoanOrder() throws Exception {
	    //参数
	    RestTemplate restTemplate = new RestTemplate();
        //订单
	    FastConsumerLoanOrder f=new FastConsumerLoanOrder();
	    f.setDiscount_price(new BigDecimal(11));
	    f.setInvoice_number("11");
	    f.setOrder_discount_price(new BigDecimal(11));
	    f.setOrder_id("11");
	    f.setOrder_state("11");
	    f.setOrder_type("11");
	    f.setTotal_amount(new BigDecimal(11));
	    f.setUser_internal_code("11");
	    //商品
	    FastConsumerLoanOrderCommodity ff=new FastConsumerLoanOrderCommodity();
	    ff.setAnonymous(false);
	    ff.setCommodity_id("11");
	    ff.setCommodity_name("11");
	    ff.setDiscount_price(new BigDecimal(11));
	    ff.setExternal_pay_number("11");
	    ff.setFinish_time(new Date());
	    ff.setInformation_state("11");
	    ff.setNumber(11);
	    ff.setOrder_time(new Date());
	    ff.setPay_code("11");
	    ff.setPay_message("11");
	    ff.setPay_method("11");
	    ff.setPay_name("11");
	    ff.setPay_time(new Date());
	    ff.setPrice(new BigDecimal(11));
	    ff.setReceipt_time(new Date());
	    ff.setSeller_internal_code("11");
	    ff.setSend_time(new Date());
	    ff.setTotal_amount(new BigDecimal(11));
	    ff.setUser_internal_code("11");
	    
	    List<FastConsumerLoanOrderCommodity> list=new ArrayList<FastConsumerLoanOrderCommodity>();
	    list.add(ff);
	    Map<String,Object> map=new HashMap<String,Object>();
	    map.put("loanOrder",f);
	    map.put("loanOrderConsumerList",list);
	    String json=JSON.toJSONString(map);
	    System.out.println(json);
	    
	    HttpEntity<String> httpEntity=new HttpEntity<String>(json);
	    ResponseEntity<String> resultModelResponseEntity = restTemplate.
	        exchange(REST_SERVICE_URI + "/FastConsumerLoanOrder/insertFastConsumerLoanOrder",HttpMethod.POST,httpEntity,String.class);

	    System.out.println(resultModelResponseEntity.getBody());
	}
	
	@Test
	public void testUpdateFastConsumerLoanOrder() throws Exception {
	    //参数
	    RestTemplate restTemplate = new RestTemplate();
        //订单
	    FastConsumerLoanOrder f=new FastConsumerLoanOrder();
	    f.setDiscount_price(new BigDecimal(22));
	    f.setInvoice_number("22");
	    f.setOrder_discount_price(new BigDecimal(22));
	    f.setOrder_id("22");
	    f.setOrder_state("22");
	    f.setOrder_type("22");
	    f.setTotal_amount(new BigDecimal(22));
	    f.setUser_internal_code("22");
	    f.setId("443fd647-a47e-4fc8-bdf1-52aabadcce0c");
	    //商品
	    FastConsumerLoanOrderCommodity ff=new FastConsumerLoanOrderCommodity();
	    ff.setAnonymous(true);
	    ff.setCommodity_id("22");
	    ff.setCommodity_name("22");
	    ff.setDiscount_price(new BigDecimal(22));
	    ff.setExternal_pay_number("22");
	    ff.setFinish_time(new Date());
	    ff.setInformation_state("22");
	    ff.setNumber(22);
	    ff.setOrder_time(new Date());
	    ff.setPay_code("22");
	    ff.setPay_message("22");
	    ff.setPay_method("22");
	    ff.setPay_name("22");
	    ff.setPay_time(new Date());
	    ff.setPrice(new BigDecimal(22));
	    ff.setReceipt_time(new Date());
	    ff.setSeller_internal_code("22");
	    ff.setSend_time(new Date());
	    ff.setTotal_amount(new BigDecimal(22));
	    ff.setUser_internal_code("22");
	    ff.setId("8c5fcd0b-9179-4f4e-bce2-7e07941d3afe");
	    
	    List<FastConsumerLoanOrderCommodity> list=new ArrayList<FastConsumerLoanOrderCommodity>();
	    list.add(ff);
	    Map<String,Object> map=new HashMap<String,Object>();
	    map.put("loanOrder",f);
	    map.put("loanOrderConsumerList",list);
	    String json=JSON.toJSONString(map);
	    System.out.println(json);
	    
	    HttpEntity<String> httpEntity=new HttpEntity<String>(json);
	    ResponseEntity<String> resultModelResponseEntity = restTemplate.
	        exchange(REST_SERVICE_URI + "/FastConsumerLoanOrder/updateFastConsumerLoanOrder",HttpMethod.POST,httpEntity,String.class);

	    System.out.println(resultModelResponseEntity.getBody());
	}
	

}
