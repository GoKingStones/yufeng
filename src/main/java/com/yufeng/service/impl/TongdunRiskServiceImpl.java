package com.yufeng.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yufeng.dao.TongdunRiskDao;
import com.yufeng.entity.RiskPreloanResponse;
import com.yufeng.entity.RiskPreloanResponseQuery;
import com.yufeng.entity.TongdunRiskReport;
import com.yufeng.entity.UserBankCardInfo;
import com.yufeng.entity.UserBasicInfo;
import com.yufeng.entity.UserInfo;
import com.yufeng.service.TongdunRiskService;
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
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

@Service
public class TongdunRiskServiceImpl implements TongdunRiskService {
    
    @Autowired
    public TongdunRiskDao tongdunRiskDao;

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
        List<UserBankCardInfo> UserBankCardInfoList=userInfo.getUserBankCardInfoList();
        // 添加参数
        params.put("name", userBasic.getName()); // 姓名
        params.put("id_number", userBasic.getIdNo()); // 身份证号
        params.put("mobile", userBasic.getCellNo()); // 电话
        params.put("qq", userBasic.getQqNo()); // qq
        params.put("email", userBasic.getEmail()); // 电子邮箱
        params.put("home_address", userBasic.getFamilyAddress()); // 家庭地址
        params.put("contact_address", userBasic.getPostalAddress()); // 通讯地址
        if(UserBankCardInfoList.size()>0){
            params.put("card_number", UserBankCardInfoList.get(0).getBankCardNumber()); // 通讯地址
        }

        RiskPreloanResponse riskPreloanResponse = new TongdunRiskServiceImpl().invoke(params);
        return riskPreloanResponse;
    }

    // 获取报告
    public String getQuery(String id) {

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
        return result.toString().trim();
    }

    // 风险评估服务
    public TongdunRiskReport riskAssessment(UserInfo userInfo) throws Exception {
        // 调用submit接口获得报告
        RiskPreloanResponse riskPreloanResponse = submitInformation(userInfo);
        //尝试获取报告次数
        int count=5;
        riskPreloanResponse.setSuccess(false);
        while(count>0){
            Thread.sleep(1000);
            if (riskPreloanResponse.getSuccess() == false){
                count--;
                System.out.println("尝试了1回");
                continue;
            }
            String result = getQuery(riskPreloanResponse.getReport_id());
            //保存报告
            TongdunRiskReport tongdunRiskReport=saveRiskReport(result,userInfo.getUserBasicInfo().getInternalCode());

            return tongdunRiskReport;
            
        }
        return null;
        
    }

    //保存报告
    public TongdunRiskReport saveRiskReport(String result,String internalCode){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        TongdunRiskReport riskReport=new TongdunRiskReport();
        JSONObject jsonObject=JSON.parseObject(result);
        //提取主要属性
        riskReport.setAddressDetect(jsonObject.getString("address_detect"));
        riskReport.setApplicationId(jsonObject.getString("application_id"));
        riskReport.setApplyTime(new Date(Long.parseLong(jsonObject.getString("apply_time"))));
        riskReport.setFinalDecision(jsonObject.getString("final_decision"));
        riskReport.setFinalScore(Integer.parseInt(jsonObject.getString("final_score")));
        riskReport.setReportId(jsonObject.getString("report_id"));
        riskReport.setReportTime(new Date(Long.parseLong(jsonObject.getString("report_time"))));
        //riskReport.setRiskItems(jsonObject.getString("risk_items"));
        riskReport.setSuccess(Boolean.parseBoolean(jsonObject.getString("success")));
        
        riskReport.setInternalCode(internalCode);
        riskReport.setUniqueId(UUID.randomUUID().toString());
        //保存至本地
        String path=saveAsFileWriter(result,riskReport.getReportId());
        riskReport.setResultPath(path);
        //保存报告详细
        JSONArray itemsArray=JSON.parseArray(jsonObject.getString("risk_items"));
        Iterator<Object> itemsIterator=itemsArray.iterator();
        //结果map
        Map<String,Object> itemsMap=new HashMap<String,Object>();
        while(itemsIterator.hasNext()){
            String itemsObjectString=JSON.toJSONString(itemsIterator.next());
            JSONObject itemsJO=JSON.parseObject(itemsObjectString);
            String itemDetailString=JSON.toJSONString(itemsJO.get("item_detail"));
            //详细属性
            Map<String,Object> itemsArrayMap=new HashMap<String,Object>();
            itemsArrayMap.put("item_detail",itemDetailString);
            
            itemsArrayMap.put("risk_level",itemsJO.get("risk_level"));
            itemsArrayMap.put("item_name",itemsJO.get("item_name"));
            itemsArrayMap.put("group",itemsJO.get("group"));
            itemsMap.put("item_detail",itemDetailString);
            
        }
        
        riskReport.setRiskItems(JSON.toJSONString(itemsArray));
        
        tongdunRiskDao.insertTongdunRiskReport(riskReport);
        
        
        
        return riskReport;
    }
    
    //保存字符串到文件中
    private String saveAsFileWriter(String content,String reportId) {
        //路径
        String filePath=Utils.result_path+reportId+".txt";
        FileWriter fwriter = null;
        try{
            fwriter = new FileWriter(filePath);
            fwriter.write(content);
            return filePath;
        }catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }finally{
            try{
                fwriter.flush();
                fwriter.close();
            }catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
