package com.yufeng.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by fishyu on 16/8/05.
 *
 */
public class CityConsumptionLevel implements Serializable{


	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1034004116880873089L;
	
	private int uniqueId;//id
    private String cityCode;//城市编码
    private double consumptionLevel;//年消费水平
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





	public double getConsumptionLevel() {
		return consumptionLevel;
	}




	public void setConsumptionLevel(double consumptionLevel) {
		this.consumptionLevel = consumptionLevel;
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
        return uniqueId+"+"+cityCode+"+"+consumptionLevel+"+"+dataPeriod
        		+"+"+createTime+"+"+modTime;
    }
}
