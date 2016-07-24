package com.yufeng.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by fishyu on 16/7/23.
 *
 */
public class RewardPunishmentInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5731357877492205230L;
	
	private int uniqueId;//信息标识ID
	private String internalCode;//内码
	private String certificateNo;//奖惩证书编号
	private String infoType;//奖惩类型
	private String describeInfo;//描述
	private Date occurrenceDate;//发生时间
	private String occurrenceLocation;//获得地点
	private String dataSource;//数据来源
	private String certificateImgUrl;//证明照片地址
	private String verify;//是否验证
	private Date createTime;//创建时间
	private Date modTime;//更新时间
	private String infoStatus;//信息状态
	private String whoDid;//操作者



	public int getUniqueId() {
		return uniqueId;
	}





	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}





	public String getInternalCode() {
		return internalCode;
	}





	public void setInternalCode(String internalCode) {
		this.internalCode = internalCode;
	}





	public String getCertificateNo() {
		return certificateNo;
	}





	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}





	public String getInfoType() {
		return infoType;
	}





	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}





	public String getDescribeInfo() {
		return describeInfo;
	}





	public void setDescribeInfo(String describeInfo) {
		this.describeInfo = describeInfo;
	}





	public Date getOccurrenceDate() {
		return occurrenceDate;
	}





	public void setOccurrenceDate(Date occurrenceDate) {
		this.occurrenceDate = occurrenceDate;
	}





	public String getOccurrenceLocation() {
		return occurrenceLocation;
	}





	public void setOccurrenceLocation(String occurrenceLocation) {
		this.occurrenceLocation = occurrenceLocation;
	}





	public String getDataSource() {
		return dataSource;
	}





	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}





	public String getCertificateImgUrl() {
		return certificateImgUrl;
	}





	public void setCertificateImgUrl(String certificateImgUrl) {
		this.certificateImgUrl = certificateImgUrl;
	}





	public String getVerify() {
		return verify;
	}





	public void setVerify(String verify) {
		this.verify = verify;
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





	public String getWhoDid() {
		return whoDid;
	}





	public void setWhoDid(String whoDid) {
		this.whoDid = whoDid;
	}





	@Override
    public String toString(){
        return 	uniqueId+"+"+internalCode+"+"+certificateNo+"+"+infoType+"+"+describeInfo
        		+"+"+occurrenceDate+"+"+occurrenceLocation+"+"+dataSource+"+"+certificateImgUrl
        		+"+"+verify+"+"+createTime+"+"+modTime+"+"+infoStatus+"+"+whoDid;
    }
}
