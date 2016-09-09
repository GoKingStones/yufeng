package com.yufeng.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by kingstones on 16/7/24.
 * 企业商户基本信息
 */
public class EnterpriseBusinessBasicInfo {

    //内码ID
    private String internalCode;
    //商户名称
    private String businessName;
    //公司名称
    private String enterpriseName;
    //公司地址
    private String enterpriseAddr;
    //电子邮件
    private String email;
    //网址
    private String website;
    //传真
    private String fax;
    //管理层联系人名称
    private String manageContactName;

    //管理层联系人电话
    private String manageContactTel;
    //运营联系人名称
    private String operateContactName;
    //运营联系人电话
    private String operateContactTel;
    //工商营业执照号
    private String businessLicenseNumber;
    //法人证件类型
    private int legalPersonCertificateType;
    //法人证件号码
    private String legalPersonCertificateNumber;
    //法人姓名
    private String legalPersonName;
    //经营执照营业范围
    private String businessLicenceManagementScope;
    //经营品牌
    private String businessBrand;
    //注册资金
    private BigDecimal registeredCapital;

    //开通时间
    private Date openTime;
    //商户等级
    private String businessRank;
    //商户积分
    private double businessScore;
    //商户信用值
    private double businessCreditValue;

    private Date createTime;//创建时间
    private Date modTime;//修改时间

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModTime() {
        return modTime;
    }

    public void setModTime(Date modTime) {
        this.modTime = modTime;
    }

    public String getInternalCode() {
        return internalCode;
    }

    public void setInternalCode(String internalCode) {
        this.internalCode = internalCode;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getEnterpriseAddr() {
        return enterpriseAddr;
    }

    public void setEnterpriseAddr(String enterpriseAddr) {
        this.enterpriseAddr = enterpriseAddr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getManageContactName() {
        return manageContactName;
    }

    public void setManageContactName(String manageContactName) {
        this.manageContactName = manageContactName;
    }

    public String getManageContactTel() {
        return manageContactTel;
    }

    public void setManageContactTel(String manageContactTel) {
        this.manageContactTel = manageContactTel;
    }

    public String getOperateContactName() {
        return operateContactName;
    }

    public void setOperateContactName(String operateContactName) {
        this.operateContactName = operateContactName;
    }

    public String getOperateContactTel() {
        return operateContactTel;
    }

    public void setOperateContactTel(String operateContactTel) {
        this.operateContactTel = operateContactTel;
    }

    public String getBusinessLicenseNumber() {
        return businessLicenseNumber;
    }

    public void setBusinessLicenseNumber(String businessLicenseNumber) {
        this.businessLicenseNumber = businessLicenseNumber;
    }

    public int getLegalPersonCertificateType() {
        return legalPersonCertificateType;
    }

    public void setLegalPersonCertificateType(int legalPersonCertificateType) {
        this.legalPersonCertificateType = legalPersonCertificateType;
    }

    public String getLegalPersonCertificateNumber() {
        return legalPersonCertificateNumber;
    }

    public void setLegalPersonCertificateNumber(String legalPersonCertificateNumber) {
        this.legalPersonCertificateNumber = legalPersonCertificateNumber;
    }

    public String getLegalPersonName() {
        return legalPersonName;
    }

    public void setLegalPersonName(String legalPersonName) {
        this.legalPersonName = legalPersonName;
    }

    public String getBusinessLicenceManagementScope() {
        return businessLicenceManagementScope;
    }

    public void setBusinessLicenceManagementScope(String businessLicenceManagementScope) {
        this.businessLicenceManagementScope = businessLicenceManagementScope;
    }

    public String getBusinessBrand() {
        return businessBrand;
    }

    public void setBusinessBrand(String businessBrand) {
        this.businessBrand = businessBrand;
    }

    public BigDecimal getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(BigDecimal registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public String getBusinessRank() {
        return businessRank;
    }

    public void setBusinessRank(String businessRank) {
        this.businessRank = businessRank;
    }

    public double getBusinessScore() {
        return businessScore;
    }

    public void setBusinessScore(double businessScore) {
        this.businessScore = businessScore;
    }

    public double getBusinessCreditValue() {
        return businessCreditValue;
    }

    public void setBusinessCreditValue(double businessCreditValue) {
        this.businessCreditValue = businessCreditValue;
    }
}
