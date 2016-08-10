package com.yufeng.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by fishyu on 16/8/11.
 *
 */
public class CreditAccountInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7498883212424029270L;
	
	private String internalCode;//内码
	private Date open_date;//开户日期
	private String account_type;//账户类型
	private BigDecimal initial_cash_quota;//初始现金额度
	private BigDecimal initial_guarantee_quota;//初始担保额度
	private BigDecimal current_cash_quota;//当前现金额度
	private BigDecimal current_guarantee_quota;//当前担保额度
	private BigDecimal available_cash_quota;//当前可用现金额度
	private BigDecimal available_guarantee_quota;//当前可用担保额度
    private String account_status;//账户状态
    private Date createTime;//创建时间
    private Date modTime;//修改时间

    
	public String getInternalCode() {
		return internalCode;
	}







	public void setInternalCode(String internalCode) {
		this.internalCode = internalCode;
	}








	public Date getOpen_date() {
		return open_date;
	}







	public void setOpen_date(Date open_date) {
		this.open_date = open_date;
	}







	public String getAccount_type() {
		return account_type;
	}







	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}







	public BigDecimal getInitial_cash_quota() {
		return initial_cash_quota;
	}







	public void setInitial_cash_quota(BigDecimal initial_cash_quota) {
		this.initial_cash_quota = initial_cash_quota;
	}







	public BigDecimal getInitial_guarantee_quota() {
		return initial_guarantee_quota;
	}







	public void setInitial_guarantee_quota(BigDecimal initial_guarantee_quota) {
		this.initial_guarantee_quota = initial_guarantee_quota;
	}







	public BigDecimal getCurrent_cash_quota() {
		return current_cash_quota;
	}







	public void setCurrent_cash_quota(BigDecimal current_cash_quota) {
		this.current_cash_quota = current_cash_quota;
	}







	public BigDecimal getCurrent_guarantee_quota() {
		return current_guarantee_quota;
	}







	public void setCurrent_guarantee_quota(BigDecimal current_guarantee_quota) {
		this.current_guarantee_quota = current_guarantee_quota;
	}







	public BigDecimal getAvailable_cash_quota() {
		return available_cash_quota;
	}







	public void setAvailable_cash_quota(BigDecimal available_cash_quota) {
		this.available_cash_quota = available_cash_quota;
	}







	public BigDecimal getAvailable_guarantee_quota() {
		return available_guarantee_quota;
	}







	public void setAvailable_guarantee_quota(BigDecimal available_guarantee_quota) {
		this.available_guarantee_quota = available_guarantee_quota;
	}







	public String getAccount_status() {
		return account_status;
	}







	public void setAccount_status(String account_status) {
		this.account_status = account_status;
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


	@Override
    public String toString(){
        return internalCode+"+"+open_date+"+"+account_type+"+"+initial_cash_quota
        		+"+"+initial_guarantee_quota+"+"+current_cash_quota+"+"+current_guarantee_quota
        		+"+"+available_cash_quota+"+"+available_guarantee_quota
        		+"+"+account_status+"+"+createTime+"+"+modTime;
    }
}
