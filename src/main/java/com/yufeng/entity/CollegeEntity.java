package com.yufeng.entity;

/**
 * Created by kingstones on 16/7/27.
 * 学校对象
 */
public class CollegeEntity {

    private String collegeCode;//学校编码
    private String collegeName;//学校名称
    private String cityCode;//城市编码
    private String collegeClassification;//学校分类

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
