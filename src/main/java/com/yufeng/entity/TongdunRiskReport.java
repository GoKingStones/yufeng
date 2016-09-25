package com.yufeng.entity;

import java.util.Date;

/**
 * 同盾风险报告
 * @author dh
 */
public class TongdunRiskReport {
    
    //id
    public String uniqueId;
    //用户内码
    public String internalCode;
    //接口调用是否成功
    public Boolean success;
    //扫描出来的风险项
    public String riskItems;
    //报告编号
    public String reportId;
    //扫描时间
    public Date applyTime;
    //风险结果
    public String finalDecision;
    //申请编号
    public String applicationId;
    //风险分数
    public Integer finalScore;
    //报告时间
    public Date reportTime;
    //归属地解析
    public String addressDetect;
    //详细结果路径
    public String resultPath;
    
    
    public String getUniqueId() {
        return uniqueId;
    }
    
    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }
    
    public String getInternalCode() {
        return internalCode;
    }
    
    public void setInternalCode(String internalCode) {
        this.internalCode = internalCode;
    }
    
    public Boolean getSuccess() {
        return success;
    }
    
    public void setSuccess(Boolean success) {
        this.success = success;
    }
    
    public String getRiskItems() {
        return riskItems;
    }
    
    public void setRiskItems(String riskItems) {
        this.riskItems = riskItems;
    }
    
    public String getReportId() {
        return reportId;
    }
    
    public void setReportId(String reportId) {
        this.reportId = reportId;
    }
    
    public Date getApplyTime() {
        return applyTime;
    }
    
    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }
    
    public String getFinalDecision() {
        return finalDecision;
    }
    
    public void setFinalDecision(String finalDecision) {
        this.finalDecision = finalDecision;
    }
    
    public String getApplicationId() {
        return applicationId;
    }
    
    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }
    
    public Integer getFinalScore() {
        return finalScore;
    }
    
    public void setFinalScore(Integer finalScore) {
        this.finalScore = finalScore;
    }
    
    public Date getReportTime() {
        return reportTime;
    }
    
    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }
    
    public String getAddressDetect() {
        return addressDetect;
    }
    
    public void setAddressDetect(String addressDetect) {
        this.addressDetect = addressDetect;
    }
    
    public String getResultPath() {
        return resultPath;
    }
    
    public void setResultPath(String resultPath) {
        this.resultPath = resultPath;
    }
    

}
