package com.yufeng.entity;

import java.util.Date;

/**
 * Created by kingstones on 16/8/7.
 * 客户服务实体
 */
public class CustomServiceEntity {

    //唯一标识
    private int id;

    //客户经理ID
    private int workerId;

    //客户内码
    private String internalCode;
    //服务时间
    private Date serviceTime;
    //服务方式
    private String serviceMode;
    //服务类型
    private String serviceType;
    //满意度
    private String serviceLevel;
    //详细信息
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

    public Date getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(Date serviceTime) {
        this.serviceTime = serviceTime;
    }

    public String getServiceMode() {
        return serviceMode;
    }

    public void setServiceMode(String serviceMode) {
        this.serviceMode = serviceMode;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceLevel() {
        return serviceLevel;
    }

    public void setServiceLevel(String serviceLevel) {
        this.serviceLevel = serviceLevel;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
