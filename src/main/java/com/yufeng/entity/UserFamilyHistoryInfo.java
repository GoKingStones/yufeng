package com.yufeng.entity;

import java.util.Date;

/**
 * @author dh
 * 用户家庭联系人信息历史
 */
public class UserFamilyHistoryInfo {
	
    private String uniqueId;
    //内码
    private String internalCode;
    //证件类型
    private String credentialsType;
    //证件号码
    private String credentialsNumber;
    //姓名
    private String name;
    //性别
    private String gender;
    //通讯地址
    private String mailingAddress;
    //工作单位
    private String organization;
    //手机号码
    private String cellNo;
    //电子邮箱
    private String email;
    //与主体关系
    private String relation;
    //最高学历院校
    private String highestEducationSchool;
    //最高学历
    private String highestEducation;
    //创建时间
    private Date createTime;
	//删除操作者
	private String deleteOperator;
    
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
    
    public String getCredentialsType() {
        return credentialsType;
    }
    
    public void setCredentialsType(String credentialsType) {
        this.credentialsType = credentialsType;
    }
    
    public String getCredentialsNumber() {
        return credentialsNumber;
    }
    
    public void setCredentialsNumber(String credentialsNumber) {
        this.credentialsNumber = credentialsNumber;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getMailingAddress() {
        return mailingAddress;
    }
    
    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }
    
    public String getOrganization() {
        return organization;
    }
    
    public void setOrganization(String organization) {
        this.organization = organization;
    }
    
    public String getCellNo() {
        return cellNo;
    }
    
    public void setCellNo(String cellNo) {
        this.cellNo = cellNo;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getRelation() {
        return relation;
    }
    
    public void setRelation(String relation) {
        this.relation = relation;
    }
    
    public String getHighestEducationSchool() {
        return highestEducationSchool;
    }
    
    public void setHighestEducationSchool(String highestEducationSchool) {
        this.highestEducationSchool = highestEducationSchool;
    }
    
    public String getHighestEducation() {
        return highestEducation;
    }
    
    public void setHighestEducation(String highestEducation) {
        this.highestEducation = highestEducation;
    }
    
    public Date getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    
    public String getDeleteOperator() {
        return deleteOperator;
    }

    
    public void setDeleteOperator(String deleteOperator) {
        this.deleteOperator = deleteOperator;
    }
    
    
	
	
	
	
	
	

}
