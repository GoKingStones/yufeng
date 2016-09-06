package com.yufeng.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yufeng.entity.RiskPreloanResponse;
import com.yufeng.entity.RiskPreloanResponseQuery;
import com.yufeng.entity.UserBankCardInfo;
import com.yufeng.entity.UserInfo;
import com.yufeng.service.RiskService;
import com.yufeng.service.UserInfoService;

/**
 * 风险评估控制层
 * @author dh
 */
@RestController
@RequestMapping("/risk")
public class RiskController {
    
    @Autowired
    private UserInfoService userInfoService; 
    @Autowired
    private RiskService riskService;
    
    //风险评估服务
    @RequestMapping("/riskAssessment")
    public RiskPreloanResponseQuery riskAssessment(String internalCode) throws Exception{
        UserInfo userInfo=userInfoService.getUserInfo(internalCode);
        RiskPreloanResponseQuery query=riskService.riskAssessment(userInfo);
        return query;
    }
    
    //用报告id获取报告详细
    @RequestMapping("/getQuery")
    public RiskPreloanResponseQuery getQuery(String id) throws Exception{
        RiskPreloanResponseQuery query=riskService.getQuery(id);
        return query;
    }
    
    //提交用户信息获得返回值
    @RequestMapping("/submitInformation")
    public RiskPreloanResponse submitInformation(String internalCode) throws Exception{
        UserInfo userInfo=userInfoService.getUserInfo(internalCode);
        RiskPreloanResponse query=riskService.submitInformation(userInfo);
        return query;
    }

}
