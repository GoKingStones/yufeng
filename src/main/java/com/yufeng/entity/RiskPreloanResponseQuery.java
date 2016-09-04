package com.yufeng.entity;

import java.util.Date;

public class RiskPreloanResponseQuery {
    
    private String success;//接口调用是否成功
    private String reason_code;//错误代码
    private String reason_desc;//错误描述
    private String report_id;//报告编号
    private String application_id;//申请编号
    private String final_decision;//风险结果   Accept:建议通过 ,Review:建议审核 ,Reject:建议拒绝
    private Integer final_score;//风险分数
    private Date apply_time;    //扫描时间
    private Date report_time;   //报告时间
    
    public String getSuccess() {
        return success;
    }
    
    public void setSuccess(String success) {
        this.success = success;
    }
    
    public String getReason_code() {
        return reason_code;
    }
    
    public void setReason_code(String reason_code) {
        this.reason_code = reason_code;
    }
    
    public String getReason_desc() {
        return reason_desc;
    }
    
    public void setReason_desc(String reason_desc) {
        this.reason_desc = reason_desc;
    }
    
    public String getReport_id() {
        return report_id;
    }
    
    public void setReport_id(String report_id) {
        this.report_id = report_id;
    }
    
    public String getApplication_id() {
        return application_id;
    }
    
    public void setApplication_id(String application_id) {
        this.application_id = application_id;
    }
    
    public String getFinal_decision() {
        return final_decision;
    }
    
    public void setFinal_decision(String final_decision) {
        this.final_decision = final_decision;
    }
    
    public Integer getFinal_score() {
        return final_score;
    }
    
    public void setFinal_score(Integer final_score) {
        this.final_score = final_score;
    }
    
    public Date getApply_time() {
        return apply_time;
    }
    
    public void setApply_time(Date apply_time) {
        this.apply_time = apply_time;
    }
    
    public Date getReport_time() {
        return report_time;
    }
    
    public void setReport_time(Date report_time) {
        this.report_time = report_time;
    }
    
    
    
    
    
    
    
}
