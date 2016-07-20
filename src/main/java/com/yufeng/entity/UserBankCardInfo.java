package com.yufeng.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author dh
 * 用户银行卡信息
 */
public class UserBankCardInfo implements Serializable{
	
	//银行卡号码
	private String bankCardNumber;
	//银行卡类型
	private String bankCardType;
	//到期时间
	private Date expireTime;
	//是否为转入账户
	private boolean transferAccount;
	//银行卡状态
	private String bankCardState;
	//创建时间
	private Date foundTime;
	//更新时间
	private Date updateTime;
	
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
	public boolean isTransferAccount() {
		return transferAccount;
	}
	public void setTransferAccount(boolean transferAccount) {
		this.transferAccount = transferAccount;
	}
	public String getBankCardState() {
		return bankCardState;
	}
	public void setBankCardState(String bankCardState) {
		this.bankCardState = bankCardState;
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
