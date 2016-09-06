package com.yufeng.service;

import com.yufeng.entity.RiskPreloanResponse;
import com.yufeng.entity.RiskPreloanResponseQuery;
import com.yufeng.entity.UserInfo;

public interface RiskService {
    
    public RiskPreloanResponse submitInformation(UserInfo userInfo);
    public RiskPreloanResponseQuery getQuery(String id);
    public RiskPreloanResponseQuery riskAssessment(UserInfo userInfo)  throws Exception;

}
