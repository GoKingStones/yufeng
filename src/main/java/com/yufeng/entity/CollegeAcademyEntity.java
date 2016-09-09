package com.yufeng.entity;

import java.util.Date;

/**
 * Created by kingstones on 16/8/1.
 * 学校院系表
 */
public class CollegeAcademyEntity {

   //信息标识ID
    private String internalCode;
    //学校编号
    private String collegeCode;
    //学院名称
    private String academyName;
    //院编码
    private String academyCode;
    //系编码
    private String departmentCode;
    //系名称
    private String departmentName;
    //年学费
    private double tuitionPerYear;
    //所修学历
    private String coursesTaken;
    //所修专业等级
    private String coursesRank;
    //就业率
    private double employmentRate;
    //当前状态
    private String currentFlag;

    private Date createTime;//创建时间
    private Date modTime;//修改时间

    public String getInternalCode() {
        return internalCode;
    }

    public void setInternalCode(String internalCode) {
        this.internalCode = internalCode;
    }

    public String getCollegeCode() {
        return collegeCode;
    }

    public void setCollegeCode(String collegeCode) {
        this.collegeCode = collegeCode;
    }

    public String getAcademyName() {
        return academyName;
    }

    public void setAcademyName(String academyName) {
        this.academyName = academyName;
    }

    public String getAcademyCode() {
        return academyCode;
    }

    public void setAcademyCode(String academyCode) {
        this.academyCode = academyCode;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public double getTuitionPerYear() {
        return tuitionPerYear;
    }

    public void setTuitionPerYear(double tuitionPerYear) {
        this.tuitionPerYear = tuitionPerYear;
    }

    public String getCoursesTaken() {
        return coursesTaken;
    }

    public void setCoursesTaken(String coursesTaken) {
        this.coursesTaken = coursesTaken;
    }

    public String getCoursesRank() {
        return coursesRank;
    }

    public void setCoursesRank(String coursesRank) {
        this.coursesRank = coursesRank;
    }

    public double getEmploymentRate() {
        return employmentRate;
    }

    public void setEmploymentRate(double employmentRate) {
        this.employmentRate = employmentRate;
    }

    public String getCurrentFlag() {
        return currentFlag;
    }

    public void setCurrentFlag(String currentFlag) {
        this.currentFlag = currentFlag;
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
}
