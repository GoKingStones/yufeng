package com.yufeng.entity;

import java.util.Date;

/**
 * Created by kingstones on 16/7/24.
 * 个体商户基本信息
 */
public class IndividualBusinessBasicInfo {

    //内码ID
    private String internalCode;
    //店铺名称
    private String shopName;
    //店主名称
    private String shopkeeperName;
    //店铺地址
    private String shopAddr;
    //联系电话
    private String shopTel;
    //店主证件类型
    private String shopkeeperCertificateType;
    //店主证件号码
    private String shopkeeperCertificateNumber;
    //所在地区
    private String localArea;
    //开通时间
    private Date openTime;
    //关闭时间
    private Date closeTime;
    //关闭原因
    private String closeReason;
    //店铺状态
    private String shopStatus;
    //店铺等级
    private String shopRank;
    //店铺积分值
    private double shopScope;
    //店铺信用值
    private double shopCreditValue;

    public String getInternalCode() {
        return internalCode;
    }

    public void setInternalCode(String internalCode) {
        this.internalCode = internalCode;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopkeeperName() {
        return shopkeeperName;
    }

    public void setShopkeeperName(String shopkeeperName) {
        this.shopkeeperName = shopkeeperName;
    }

    public String getShopAddr() {
        return shopAddr;
    }

    public void setShopAddr(String shopAddr) {
        this.shopAddr = shopAddr;
    }

    public String getShopTel() {
        return shopTel;
    }

    public void setShopTel(String shopTel) {
        this.shopTel = shopTel;
    }

    public String getShopkeeperCertificateType() {
        return shopkeeperCertificateType;
    }

    public void setShopkeeperCertificateType(String shopkeeperCertificateType) {
        this.shopkeeperCertificateType = shopkeeperCertificateType;
    }

    public String getShopkeeperCertificateNumber() {
        return shopkeeperCertificateNumber;
    }

    public void setShopkeeperCertificateNumber(String shopkeeperCertificateNumber) {
        this.shopkeeperCertificateNumber = shopkeeperCertificateNumber;
    }

    public String getLocalArea() {
        return localArea;
    }

    public void setLocalArea(String localArea) {
        this.localArea = localArea;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public String getCloseReason() {
        return closeReason;
    }

    public void setCloseReason(String closeReason) {
        this.closeReason = closeReason;
    }

    public String getShopStatus() {
        return shopStatus;
    }

    public void setShopStatus(String shopStatus) {
        this.shopStatus = shopStatus;
    }

    public String getShopRank() {
        return shopRank;
    }

    public void setShopRank(String shopRank) {
        this.shopRank = shopRank;
    }

    public double getShopScope() {
        return shopScope;
    }

    public void setShopScope(double shopScope) {
        this.shopScope = shopScope;
    }

    public double getShopCreditValue() {
        return shopCreditValue;
    }

    public void setShopCreditValue(double shopCreditValue) {
        this.shopCreditValue = shopCreditValue;
    }
}
