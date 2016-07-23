package com.yufeng.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author dh
 * 用户金融账户信息
 */
public class UserFinancialAccountInfo implements Serializable{
	
	private String id;
	//内码
	private String internal_code;
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
	private Date foundTime;
	//更新时间
	private Date updateTime;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInternal_code() {
		return internal_code;
	}
	public void setInternal_code(String internal_code) {
		this.internal_code = internal_code;
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
	public Date getFoundTime() {
		return foundTime;
	}
	public void setFoundTime(Date foundTime) {
		this.foundTime = foundTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
	
		
	

}
