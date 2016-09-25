package com.yufeng.service;

import java.util.List;

import com.yufeng.entity.RiskPreloanResponse;
import com.yufeng.entity.RiskPreloanResponseQuery;
import com.yufeng.entity.TongdunRiskReport;
import com.yufeng.entity.UserInfo;

public interface TongdunRiskService {
    
    public RiskPreloanResponse submitInformation(UserInfo userInfo);
    public String getQuery(String id);
    public TongdunRiskReport riskAssessment(UserInfo userInfo)  throws Exception;
    //取出报告
    public List<TongdunRiskReport> getTongdunRiskReportByInternalCode(String internalCode);

}
