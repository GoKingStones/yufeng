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
	private Date openDate;//开户日期
	private String accountType;//账户类型
	private BigDecimal initialCashQuota;//初始现金额度
	private BigDecimal initialGuaranteeQuota;//初始担保额度
	private BigDecimal currentCashQuota;//当前现金额度
	private BigDecimal currentGuaranteeQuota;//当前担保额度
	private BigDecimal availableCashQuota;//当前可用现金额度
	private BigDecimal availableGuaranteeQuota;//当前可用担保额度
    private String accountStatus;//账户状态
    private Date createTime;//创建时间
    private Date modTime;//修改时间

    
	public String getInternalCode() {
		return internalCode;
	}







	public void setInternalCode(String internalCode) {
		this.internalCode = internalCode;
	}







	public Date getOpenDate() {
		return openDate;
	}







	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}







	public String getAccountType() {
		return accountType;
	}







	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}







	public BigDecimal getInitialCashQuota() {
		return initialCashQuota;
	}







	public void setInitialCashQuota(BigDecimal initialCashQuota) {
		this.initialCashQuota = initialCashQuota;
	}







	public BigDecimal getInitialGuaranteeQuota() {
		return initialGuaranteeQuota;
	}







	public void setInitialGuaranteeQuota(BigDecimal initialGuaranteeQuota) {
		this.initialGuaranteeQuota = initialGuaranteeQuota;
	}







	public BigDecimal getCurrentCashQuota() {
		return currentCashQuota;
	}







	public void setCurrentCashQuota(BigDecimal currentCashQuota) {
		this.currentCashQuota = currentCashQuota;
	}







	public BigDecimal getCurrentGuaranteeQuota() {
		return currentGuaranteeQuota;
	}







	public void setCurrentGuaranteeQuota(BigDecimal currentGuaranteeQuota) {
		this.currentGuaranteeQuota = currentGuaranteeQuota;
	}







	public BigDecimal getAvailableCashQuota() {
		return availableCashQuota;
	}







	public void setAvailableCashQuota(BigDecimal availableCashQuota) {
		this.availableCashQuota = availableCashQuota;
	}









	public BigDecimal getAvailableGuaranteeQuota() {
		return availableGuaranteeQuota;
	}







	public void setAvailableGuaranteeQuota(BigDecimal availableGuaranteeQuota) {
		this.availableGuaranteeQuota = availableGuaranteeQuota;
	}







	public String getAccountStatus() {
		return accountStatus;
	}







	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
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
        return internalCode+"+"+openDate+"+"+accountType+"+"+initialCashQuota
        		+"+"+initialGuaranteeQuota+"+"+currentCashQuota+"+"+currentGuaranteeQuota
        		+"+"+availableCashQuota+"+"+availableGuaranteeQuota
        		+"+"+accountStatus+"+"+createTime+"+"+modTime;
    }
}
