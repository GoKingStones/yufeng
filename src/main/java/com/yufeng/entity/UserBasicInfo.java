package com.yufeng.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by fishyu on 16/7/23.
 *
 */
public class UserBasicInfo implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -3685671263644101749L;
	
	private String internalCode;//内码
    private String name;//姓名
    private String idType;//证件类型
    private String idNo;//证件号码
    private String cellNo;//手机号码
    private String email;//电子邮箱
    private String familyAddress;//家庭住址
    private String maritalStatus;//婚姻状态
    private String postalAddress;//通讯地址
    private String idcardFrontImgUrl;//身份证正面照片地址
    private String idcardBackImgUrl;//身份证背面照片地址
    private String weixinNo;//微信号
    private String qqNo;//QQ号
    private String weiboNo;//微博号码
    private String address;//现居住地址
    private Date createTime;//创建时间
    private Date modTime;//修改时间


    
	public String getInternalCode() {
		return internalCode;
	}







	public void setInternalCode(String internalCode) {
		this.internalCode = internalCode;
	}







	public String getName() {
		return name;
	}







	public void setName(String name) {
		this.name = name;
	}







	public String getIdType() {
		return idType;
	}







	public void setIdType(String idType) {
		this.idType = idType;
	}







	public String getIdNo() {
		return idNo;
	}







	public void setIdNo(String idNo) {
		this.idNo = idNo;
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







	public String getFamilyAddress() {
		return familyAddress;
	}







	public void setFamilyAddress(String familyAddress) {
		this.familyAddress = familyAddress;
	}







	public String getMaritalStatus() {
		return maritalStatus;
	}







	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}







	public String getPostalAddress() {
		return postalAddress;
	}







	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}







	public String getIdcardFrontImgUrl() {
		return idcardFrontImgUrl;
	}







	public void setIdcardFrontImgUrl(String idcardFrontImgUrl) {
		this.idcardFrontImgUrl = idcardFrontImgUrl;
	}







	public String getIdcardBackImgUrl() {
		return idcardBackImgUrl;
	}







	public void setIdcardBackImgUrl(String idcardBackImgUrl) {
		this.idcardBackImgUrl = idcardBackImgUrl;
	}







	public String getWeixinNo() {
		return weixinNo;
	}







	public void setWeixinNo(String weixinNo) {
		this.weixinNo = weixinNo;
	}







	public String getQqNo() {
		return qqNo;
	}







	public void setQqNo(String qqNo) {
		this.qqNo = qqNo;
	}







	public String getAddress() {
		return address;
	}







	public void setAddress(String address) {
		this.address = address;
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





	public String getWeiboNo() {
		return weiboNo;
	}







	public void setWeiboNo(String weiboNo) {
		this.weiboNo = weiboNo;
	}







	@Override
    public String toString(){
        return internalCode+"+"+name+"+"+idType+"+"+idNo
        		+"+"+cellNo+"+"+email+"+"+familyAddress
        		+"+"+maritalStatus+"+"+postalAddress
        		+"+"+idcardFrontImgUrl+"+"+idcardBackImgUrl
        		+"+"+weixinNo+"+"+qqNo+"+"+address+"+"+createTime+"+"+modTime;
    }
}
