package com.yufeng.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by fishyu on 16/7/26.
 *
 */
public class CityCode implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -4142833226533387091L;
	/**
	 * 
	 */
	
	private String cityCode;//城市编号
    private String provinceName;//省直辖市名称
    private String cityName;//市名称
    private String districtName;//区县名称
    private String fullName;//全称
    private Date createTime;//创建时间
    private Date modTime;//修改时间



	public String getCityCode() {
		return cityCode;
	}





	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}





	public String getProvinceName() {
		return provinceName;
	}





	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}





	public String getCityName() {
		return cityName;
	}





	public void setCityName(String cityName) {
		this.cityName = cityName;
	}





	public String getDistrictName() {
		return districtName;
	}





	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}





	public String getFullName() {
		return fullName;
	}





	public void setFullName(String fullName) {
		this.fullName = fullName;
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
        return cityCode+"+"+provinceName+"+"+cityName+"+"+districtName
        		+"+"+fullName+"+"+createTime+"+"+modTime;
    }
}
