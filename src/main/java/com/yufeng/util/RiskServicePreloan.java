package com.yufeng.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
 
public class RiskServicePreloan {
    private static final Log log = LogFactory.getLog(RiskServicePreloan.class);
    private static final String apiUrl = "https://apitest.tongdun.cn/preloan/apply/v5?partner_code=xypd&partner_key=f4b5bfc2ca6d42eb873d9c31f9e430cf&app_name=xypd_web";
 
    private HttpURLConnection conn;
 
    public RiskPreloanResponse invoke(Map<String, Object> params) {
        try {
            URL url = new URL(apiUrl);
            // 组织请求参数
            StringBuilder postBody = new StringBuilder();
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                if (entry.getValue() == null) continue;
                postBody.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue().toString(),
                        "utf-8")).append("&");
            }
 
            if (!params.isEmpty()) {
                postBody.deleteCharAt(postBody.length() - 1);
            }
            
          System.out.println(postBody.toString());
 
            conn = (HttpURLConnection) url.openConnection();
            // 设置长链接
            conn.setRequestProperty("Connection", "Keep-Alive");
            // 设置连接超时
            conn.setConnectTimeout(1000);
            // 设置读取超时
            conn.setReadTimeout(500);
            // 提交参数
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.getOutputStream().write(postBody.toString().getBytes());
            conn.getOutputStream().flush();
            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                log.warn("RiskServicePreloan] invoke failed, response status:" + responseCode);
                return null;
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line).append("\n");
            }
            return JSON.parseObject(result.toString().trim(), RiskPreloanResponse.class);
        } catch (Exception e) {
            log.error("[RiskServicePreloan] invoke throw exception, details: " + e);
        }
        return null;
    }
 
    public static void main(String[] args) {
        Map<String, Object> params = new HashMap<String, Object>();
//        params.put("partner_code", "xypd");        // 此处值填写您的合作方标识
//        params.put("partner_key", "f4b5bfca6d42eb873d9c31f9e430cf");                     // 合作方密钥
//        params.put("app_name", "xypd_web");                    // 应用名称
        params.put("loan_amount", "10000");                // 申请借款金额
//        params.put("loan_term", "12");                     // 申请借款期限
//        params.put("loan_term_unit", "DAY");               // 期限单位
//        params.put("loan_date", "2018-11-11");             // 申请借款日期
//        params.put("purpose", "");                         // 借款用途
//        params.put("apply_province", "");                  // 进件省份
//        params.put("apply_city", "");                      // 进件城市
//        params.put("apply_channel", "");                   // 进件渠道
        params.put("name", "杜昊");                        // 姓名
        params.put("id_number", "120106199007311031");     // 身份证号
        params.put("mobile", "13820521383");               // 手机号
//        params.put("card_number", "");                     // 银行卡
//        params.put("work_phone", "");                      // 单位座机
//        params.put("home_phone", "");                      // 家庭座机
//        params.put("qq", "");                              // qq
//        params.put("email", "");                           // 电子邮箱
//        params.put("diploma", "");                         // 学历
//        params.put("marriage", "");                        // 婚姻
//        params.put("house_property", "");                  // 房产情况
//        params.put("house_type", "");                      // 房产类型
//        params.put("registered_address", "");              // 户籍地址
//        params.put("home_address", "");                    // 家庭地址
//        params.put("contact_address", "");                 // 通讯地址
//        params.put("career", "");                          // 职业
//        params.put("applyer_type", "");                    // 申请人类别
//        params.put("work_time", "");                       // 工作时间
//        params.put("company_name", "");                    // 工作单位
//        params.put("company_address","");                  // 单位地址
//        params.put("company_industry", "");                // 公司行业
//        params.put("company_type", "");                    // 公司性质
//        params.put("occupation", "");                      // 职位
//        params.put("annual_income", "");                   // 年收入
//        params.put("is_cross_loan", "");                   // 三个月内是否跨平台申请借款
//        params.put("cross_loan_count", "");                // 三个月内跨平台申请借款平台个数
//        params.put("is_liability_loan", "");               // 三个月内是否跨平台借款负债
//        params.put("liability_loan_count", "");            // 三个月内跨平台借款负债平台个数
//        params.put("is_id_checked", "");                   // 是否通过实名认证
//        params.put("contact1_relation", "");               // 第一联系人社会关系
//        params.put("concatc1_name", "");                   // 第一联系人姓名
//        params.put("contact1_id_number", "");              // 第一联系人身份证
//        params.put("contact1_mobile", "");                 // 第一联系人手机号
//        params.put("contact1_addr", "");                   // 第一联系人家庭地址
//        params.put("contact1_com_name", "");               // 第一联系人工作单位
//        params.put("contact1_com_addr", "");               // 第一联系人工作地址
//        params.put("contact2_relation", "");
//        params.put("contact2_name", "");
//        params.put("contact2_id_number", "");
//        params.put("contact2_mobile", "");
//        params.put("contact2_addr", "");
//        params.put("contact2_com_name", "");
//        params.put("contact2_com_addr", "");
//        params.put("contact3_relation", "");
//        params.put("contact3_name", "");
//        params.put("contact3_id_number", "");
//        params.put("contact3_mobile", "");
//        params.put("contact3_addr", "");
//        params.put("contact3_com_name", "");
//        params.put("contact3_com_addr", "");
//        params.put("contact4_relation", "");
//        params.put("contact4_name", "");
//        params.put("contact4_id_number", "");
//        params.put("contact4_mobile", "");
//        params.put("contact4_addr", "");
//        params.put("contact4_com_name", "");
//        params.put("contact4_com_addr", "");
//        params.put("contact5_relation", "");
//        params.put("contact5_name", "");
//        params.put("contact5_id_number", "");
//        params.put("contact5_mobile", "");
//        params.put("contact5_addr", "");
//        params.put("contact5_com_name", "");
//        params.put("contact5_com_addr", "");
//        params.put("ip_address", "");                       // IP地址
//        params.put("token_id", "");                         // token_id
//        params.put("black_box", "");                        // black_box
        RiskPreloanResponse riskPreloanResponse = new RiskServicePreloan().invoke(params);
        System.out.println(riskPreloanResponse.toString());
        System.out.println(RiskReport.sendGet(riskPreloanResponse.getReport_id()));
    }
    
    //获取报告
    public void getRiskReport(String id){
    	String riskReportUrl="https://apitest.tongdun.cn/preloan/report/v6?partner_code=xypd&partner_key=f4b5bfc2ca6d42eb873d9c31f9e430cf&app_name=xypd_web&report_id="+id;
        
    	System.out.println(riskReportUrl);
    	HttpURLConnection connn;
    	
    	try {
            URL url = new URL(riskReportUrl);
            
            connn = (HttpURLConnection) url.openConnection();
            // 设置长链接
            connn.setRequestProperty("Connection", "Keep-Alive");
            // 设置连接超时
            connn.setConnectTimeout(1000);
            // 设置读取超时
            connn.setReadTimeout(500);
            // 提交参数
            connn.setRequestMethod("GET");
            connn.setDoOutput(true);
            connn.getOutputStream().flush();
            int responseCode = connn.getResponseCode();
            if (responseCode != 200) {
                log.warn("RiskServicePreloan] invoke failed, response status:" + responseCode);
                return;
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connn.getInputStream(), "utf-8"));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line).append("\n");
            }
            System.out.println(result.toString());
        } catch (Exception e) {
            log.error("[RiskServicePreloan] invoke throw exception, details: " + e);
        }
    }
}