package com.yufeng.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by fishyu on 16/7/26.
 *
 */
public class CityHousePrice implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 2654898491571754189L;
	
	private int uniqueId;//内码
    private String cityCode;//姓名
    private String housePrice;//证件类型
    private String infoStatus;//证件号码
    private Date createTime;//创建时间
    private Date modTime;//修改时间

   
	

	public int getUniqueId() {
		return uniqueId;
	}




	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}




	public String getCityCode() {
		return cityCode;
	}




	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}




	public String getHousePrice() {
		return housePrice;
	}




	public void setHousePrice(String housePrice) {
		this.housePrice = housePrice;
	}




	public String getInfoStatus() {
		return infoStatus;
	}




	public void setInfoStatus(String infoStatus) {
		this.infoStatus = infoStatus;
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
        return uniqueId+"+"+cityCode+"+"+housePrice+"+"+infoStatus
        		+"+"+createTime+"+"+modTime;
    }
}
