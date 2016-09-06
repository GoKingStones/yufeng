package com.yufeng.service.impl;

import com.alibaba.fastjson.JSON;
import com.yufeng.entity.RiskPreloanResponse;
import com.yufeng.entity.RiskPreloanResponseQuery;
import com.yufeng.entity.UserBasicInfo;
import com.yufeng.entity.UserInfo;
import com.yufeng.service.RiskService;
import com.yufeng.service.UserBasicInfoService;
import com.yufeng.service.UserInfoService;
import com.yufeng.service.impl.UserBasicInfoServiceImpl;
import com.yufeng.service.impl.UserInfoServiceImpl;
import com.yufeng.util.Utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Service
public class RiskServiceImpl implements RiskService {

    public RiskPreloanResponse invoke(Map<String, Object> params) {
        HttpURLConnection conn;
        String apiUrl = Utils.submitRrl + "?partner_code=" + Utils.partner_code + "&partner_key=" + Utils.partner_key + "&app_name=" + Utils.app_name;

        try {
            URL url = new URL(apiUrl);
            // 组织请求参数
            StringBuilder postBody = new StringBuilder();
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                if (entry.getValue() == null) continue;
                postBody.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue().toString(), "utf-8")).append("&");
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

        }
        return null;
    }

    // 提交信息获取信用评级
    public RiskPreloanResponse submitInformation(UserInfo userInfo) {
        Map<String, Object> params = new HashMap<String, Object>();// 参数
        // UserInfo userInfo=userInfoService.getUserInfo(internalCode);
        UserBasicInfo userBasic = userInfo.getUserBasicInfo();

        // 添加参数
        params.put("name", userBasic.getName()); // 姓名
        params.put("id_number", userBasic.getIdNo()); // 身份证号
        params.put("mobile", userBasic.getCellNo()); // 电话
        params.put("qq", userBasic.getQqNo()); // qq
        params.put("email", userBasic.getEmail()); // 电子邮箱
        params.put("home_address", userBasic.getFamilyAddress()); // 家庭地址
        params.put("contact_address", userBasic.getPostalAddress()); // 通讯地址

        RiskPreloanResponse riskPreloanResponse = new RiskServiceImpl().invoke(params);
        System.out.println(riskPreloanResponse.toString());
        return riskPreloanResponse;
    }

    // 获取报告
    public RiskPreloanResponseQuery getQuery(String id) {

        String url = Utils.queryRrl + "?partner_code=" + Utils.partner_code + "&partner_key=" + Utils.partner_key + "&app_name=" + Utils.app_name + "&report_id=" + id;
        String result = "";
        BufferedReader in = null;
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("connection", "Keep-Alive");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return JSON.parseObject(result.toString().trim(), RiskPreloanResponseQuery.class);
    }

    // 风险评估服务
    public RiskPreloanResponseQuery riskAssessment(UserInfo userInfo) throws Exception {
        // 调用submit接口获得报告
        RiskPreloanResponse riskPreloanResponse = submitInformation(userInfo);

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("loan_amount", "10000"); // 申请借款金额
        params.put("name", "张三"); // 姓名
        params.put("id_number", "1201231231231"); // 身份证号
        params.put("mobile", "1383838438"); // 手机号
        // RiskPreloanResponse riskPreloanResponse = invoke(params);

        if (riskPreloanResponse.getSuccess() == false) return null;// 错误
        // 生成报告需要一定的时间
        Thread.sleep(500);
        // 获取报告
        RiskPreloanResponseQuery result = getQuery(riskPreloanResponse.getReport_id());
        System.out.println(result);

        return result;
    }

    // public static void main(String[] args) throws Exception {
    // RiskPreloanResponseQuery r=new RiskServiceImpl().riskService(null);
    //
    // System.out.println(r.getApplication_id());
    // System.out.println(r.getFinal_decision());
    // System.out.println(r.getReport_id());
    // System.out.println(r.getSuccess());
    // System.out.println(r.getApply_time());
    // System.out.println(r.getFinal_score());
    // System.out.println(r.getReport_time());
    //
    //
    //
    // }
    //
}
