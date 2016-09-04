package com.yufeng.entity;

import java.io.Serializable;
public class RiskPreloanResponse implements Serializable {
    private static final long serialVersionUID = 4152462611121573434L;
    private Boolean success = false;//是否成功
    private String report_id;//报告id
    private String reason_code;//错误编码
    private String reason_desc;//错误详细
    
    // ... 省略若干Getter与Setter
 
    public Boolean getSuccess() {
        return success;
    }
 
    public void setSuccess(Boolean success) {
        this.success = success;
    }
 
    public String getReport_id() {
        return report_id;
    }
 
    public void setReport_id(String report_id) {
        this.report_id = report_id;
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

	@Override
    public String toString() {
        return "RiskpreloanResponse [success=" + success + ", report_id=" + report_id
                +",reason_code="+reason_code+",reason_desc="+reason_desc+"]";
    }
 
}