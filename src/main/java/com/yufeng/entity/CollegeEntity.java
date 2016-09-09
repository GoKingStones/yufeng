package com.yufeng.entity;

import java.util.Date;

/**
 * Created by kingstones on 16/7/27.
 * 学校对象
 */
public class CollegeEntity {

    private String collegeCode;//学校编码
    private String collegeName;//学校名称
    private String cityCode;//城市编码
    private String collegeClassification;//学校分类
    private Date createTime;//创建时间
    private Date modTime;//修改时间

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

    public String getCollegeCode() {
        return collegeCode;
    }

    public void setCollegeCode(String collegeCode) {
        this.collegeCode = collegeCode;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCollegeClassification() {
        return collegeClassification;
    }

    public void setCollegeClassification(String collegeClassification) {
        this.collegeClassification = collegeClassification;
    }
}
