package com.yufeng.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author dh
 * 用户银行卡信息
 */
public class UserBankCardInfo implements Serializable{
	
	/**
     */
    private static final long serialVersionUID = -344226052708458671L;
    
    private String uniqueId;
	//内码
	private String internalCode;
	//银行卡号码
	private String bankCardNumber;
	//银行卡类型
	private String bankCardType;
	//到期时间
	private Date expireTime;
	//是否为转入账户
	private Boolean transferAccount;
	//银行卡状态
	private String bankCardState;
	//创建时间
	private Date createTime;
	//更新时间
	private Date modTime;
	//是否有效
	private String infoStatus;
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
	public String getBankCardNumber() {
		return bankCardNumber;
	}
	public void setBankCardNumber(String bankCardNumber) {
		this.bankCardNumber = bankCardNumber;
	}
	public String getBankCardType() {
		return bankCardType;
	}
	public void setBankCardType(String bankCardType) {
		this.bankCardType = bankCardType;
	}
	public Date getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
	public Boolean getTransferAccount() {
		return transferAccount;
	}
	public void setTransferAccount(Boolean transferAccount) {
		this.transferAccount = transferAccount;
	}
	public String getBankCardState() {
		return bankCardState;
	}
	public void setBankCardState(String bankCardState) {
		this.bankCardState = bankCardState;
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
	public String getInfoStatus() {
		return infoStatus;
	}
	public void setInfoStatus(String infoStatus) {
		this.infoStatus = infoStatus;
	}
	public String getDeleteOperator() {
		return deleteOperator;
	}
	public void setDeleteOperator(String deleteOperator) {
		this.deleteOperator = deleteOperator;
	}
	
	



}
