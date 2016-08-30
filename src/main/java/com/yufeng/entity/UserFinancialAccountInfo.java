package com.yufeng.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author dh
 * 用户金融账户信息
 */
public class UserFinancialAccountInfo implements Serializable{
	
	/**
     */
    private static final long serialVersionUID = 4299505920916240269L;
    
    private String uniqueId;
	//内码
	private String internalCode;
	//信息标识ID
	private String signId;
	//金融消费账户ID
	private String financialConsumeAccountId;
	//金融消费公司
	private String financialConsumeCompany;
	//金融消费账户状态
	private String financialConsumeAccountState;
	//信用评分
	private Integer creditScoring;
	//是否授权
	private String authorize;
	//创建时间
	private Date createTime;
	//更新时间
	private Date modTime;
	//是否有效
	private Boolean infoStatus;
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
	public String getSignId() {
		return signId;
	}
	public void setSignId(String signId) {
		this.signId = signId;
	}
	public String getFinancialConsumeAccountId() {
		return financialConsumeAccountId;
	}
	public void setFinancialConsumeAccountId(String financialConsumeAccountId) {
		this.financialConsumeAccountId = financialConsumeAccountId;
	}
	public String getFinancialConsumeCompany() {
		return financialConsumeCompany;
	}
	public void setFinancialConsumeCompany(String financialConsumeCompany) {
		this.financialConsumeCompany = financialConsumeCompany;
	}
	public String getFinancialConsumeAccountState() {
		return financialConsumeAccountState;
	}
	public void setFinancialConsumeAccountState(String financialConsumeAccountState) {
		this.financialConsumeAccountState = financialConsumeAccountState;
	}
	public Integer getCreditScoring() {
		return creditScoring;
	}
	public void setCreditScoring(Integer creditScoring) {
		this.creditScoring = creditScoring;
	}
	public String getAuthorize() {
		return authorize;
	}
	public void setAuthorize(String authorize) {
		this.authorize = authorize;
	}
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
	public Boolean getInfoStatus() {
		return infoStatus;
	}
	public void setInfoStatus(Boolean infoStatus) {
		this.infoStatus = infoStatus;
	}
	public String getDeleteOperator() {
		return deleteOperator;
	}
	public void setDeleteOperator(String deleteOperator) {
		this.deleteOperator = deleteOperator;
	}
	
	
	
	
	
}
