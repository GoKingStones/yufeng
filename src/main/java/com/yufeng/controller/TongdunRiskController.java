package com.yufeng.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yufeng.entity.RiskPreloanResponse;
import com.yufeng.entity.RiskPreloanResponseQuery;
import com.yufeng.entity.TongdunRiskReport;
import com.yufeng.entity.UserBankCardInfo;
import com.yufeng.entity.UserInfo;
import com.yufeng.service.TongdunRiskService;
import com.yufeng.service.UserInfoService;

/**
 * 风险评估控制层
 * @author dh
 */
@RestController
@RequestMapping("/risk")
public class TongdunRiskController {
    
    @Autowired
    private UserInfoService userInfoService; 
    @Autowired
    private TongdunRiskService tongdunRiskService;
    
    //风险评估服务
    @RequestMapping("/riskAssessment")
    public TongdunRiskReport riskAssessment(HttpServletResponse response,String internalCode){
        response.setContentType("application/json;charset=UTF-8");
        UserInfo userInfo=userInfoService.getUserInfo(internalCode);
        TongdunRiskReport query=tongdunRiskService.riskAssessment(userInfo);
        return query;
    }
    
    //用报告id获取报告详细
    @RequestMapping("/getQuery")
    public String getQuery(String id) throws Exception{
        String query=tongdunRiskService.getQuery(id);
        return query;
    }
    
    //提交用户信息获得返回值
    @RequestMapping("/submitInformation")
    public RiskPreloanResponse submitInformation(String internalCode) throws Exception{
        UserInfo userInfo=userInfoService.getUserInfo(internalCode);
        RiskPreloanResponse query=tongdunRiskService.submitInformation(userInfo);
        return query;
    }
    
    //提取报告
    @RequestMapping("/getTongdunRiskReportByInternalCode")
    public List<TongdunRiskReport> getTongdunRiskReportByInternalCode(String internalCode){
        List<TongdunRiskReport> tongdunRiskReport=tongdunRiskService.getTongdunRiskReportByInternalCode(internalCode);
        return tongdunRiskReport;
    }

}
