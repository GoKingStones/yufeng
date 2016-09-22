package com.yufeng.entity;

import java.io.Serializable;

public class ChinaUnionPayRequest implements Serializable{
	
		
	/**
	 * 
	 */
	private static final long serialVersionUID = -4571392825975373469L;
			
	//商户订单号
	private String orderId;
	//交易金额
	private String txnAmt;
	//企业编号
	private String enterpriseNo; 
	//商户代码
	private String merId;
	//收款人账号
	private String accNo;
	//后台通知地址
	private String backUrl;
	//收款人银行中文名称
	private String BankName;
	//收款人名称
	private String payName;
	//清算时效标志
	private String settType;
	//收款人开户行行号
	private String bankNo;
	//手机号
	private String phone;
	//备注
	private String note;
	//原消费交易商户号
	private String oldMerid;
	
//	//交易类型
//	private String txnType;
//	//订单发送时间
//	private String txnTime;	
//	//签名方法
//	private String signMethod;
//	//公/私标识
//	private String ppType;
//	//签名
//	private String signature;
//	//版本号
//	private String version;
	
	public String getOrderId() {
		return orderId;
	}





	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}





	public String getTxnAmt() {
		return txnAmt;
	}





	public void setTxnAmt(String txnAmt) {
		this.txnAmt = txnAmt;
	}





	public String getEnterpriseNo() {
		return enterpriseNo;
	}





	public void setEnterpriseNo(String enterpriseNo) {
		this.enterpriseNo = enterpriseNo;
	}





	public String getNote() {
		return note;
	}





	public void setNote(String note) {
		this.note = note;
	}











	public String getMerId() {
		return merId;
	}





	public void setMerId(String merId) {
		this.merId = merId;
	}











	public String getAccNo() {
		return accNo;
	}





	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}





	public String getBackUrl() {
		return backUrl;
	}





	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
	}





	public String getBankName() {
		return BankName;
	}





	public void setBankName(String bankName) {
		BankName = bankName;
	}





	public String getPayName() {
		return payName;
	}





	public void setPayName(String payName) {
		this.payName = payName;
	}







	public String getSettType() {
		return settType;
	}





	public void setSettType(String settType) {
		this.settType = settType;
	}





	public String getBankNo() {
		return bankNo;
	}





	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}





	public String getPhone() {
		return phone;
	}





	public void setPhone(String phone) {
		this.phone = phone;
	}





	public String getOldMerid() {
		return oldMerid;
	}





	public void setOldMerid(String oldMerid) {
		this.oldMerid = oldMerid;
	}

	
	
	

//	public String getSignMethod() {
//	return signMethod;
//}
//
//
//
//
//
//public void setSignMethod(String signMethod) {
//	this.signMethod = signMethod;
//}
//
//
//
//
//
//public String getPpType() {
//	return ppType;
//}
//
//
//
//
//
//public void setPpType(String ppType) {
//	this.ppType = ppType;
//}
//
//
//
//
//
//public String getSignature() {
//	return signature;
//}
//
//
//
//
//
//public void setSignature(String signature) {
//	this.signature = signature;
//}




//public String getVersion() {
//return version;
//}
//
//
//
//
//
//public void setVersion(String version) {
//this.version = version;
//}



//public String getTxnType() {
//return txnType;
//}
//
//
//
//
//
//public void setTxnType(String txnType) {
//this.txnType = txnType;
//}
//
//
//
//
//
//public String getTxnTime() {
//return txnTime;
//}
//
//
//
//
//
//public void setTxnTime(String txnTime) {
//this.txnTime = txnTime;
//}


	@Override
    public String toString(){
		return "";
	}
	
}
