package com.yufeng.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by kingstones on 16/8/7.
 * 催收服务实体
 */
public class UrgeRepaymentServiceEntity {

    private int id;
    //客户经理ID
    private int workerId;
    //客户内码
    private String internalCode;
    //催收时间
    private Date urgeTime;
    //催收方式
    private String urgeMode;
    //催收类型
    private String urgeType;
    //应还金额
    private BigDecimal repayment;
    //催收状态
    private String urgeStatus;
    //详细情况
    private String detail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public String getInternalCode() {
        return internalCode;
    }

    public void setInternalCode(String internalCode) {
        this.internalCode = internalCode;
    }

    public Date getUrgeTime() {
        return urgeTime;
    }

    public void setUrgeTime(Date urgeTime) {
        this.urgeTime = urgeTime;
    }

    public String getUrgeMode() {
        return urgeMode;
    }

    public void setUrgeMode(String urgeMode) {
        this.urgeMode = urgeMode;
    }

    public String getUrgeType() {
        return urgeType;
    }

    public void setUrgeType(String urgeType) {
        this.urgeType = urgeType;
    }

    public BigDecimal getRepayment() {
        return repayment;
    }

    public void setRepayment(BigDecimal repayment) {
        this.repayment = repayment;
    }

    public String getUrgeStatus() {
        return urgeStatus;
    }

    public void setUrgeStatus(String urgeStatus) {
        this.urgeStatus = urgeStatus;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
