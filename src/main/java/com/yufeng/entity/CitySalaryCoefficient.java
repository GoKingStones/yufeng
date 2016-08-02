package com.yufeng.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by fishyu on 16/7/26.
 *
 */
public class CitySalaryCoefficient implements Serializable{

	private static final long serialVersionUID = -4900532766879890633L;
	
	private int uniqueId;//id
    private String cityCode;//城市编码
    private String salaryCoefficient;//薪资差异系数
    private String dataPeriod;//数据有效期
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




	public String getSalaryCoefficient() {
		return salaryCoefficient;
	}




	public void setSalaryCoefficient(String salaryCoefficient) {
		this.salaryCoefficient = salaryCoefficient;
	}




	public String getDataPeriod() {
		return dataPeriod;
	}




	public void setDataPeriod(String dataPeriod) {
		this.dataPeriod = dataPeriod;
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
        return uniqueId+"+"+cityCode+"+"+salaryCoefficient+"+"+dataPeriod
        		+"+"+createTime+"+"+modTime;
    }
}
