package com.yufeng.entity;

import java.io.Serializable;
import java.util.Date;

public class SchoolExperienceInfo implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7832025381005663464L;
	/**
	 * 
	 */
	
	private int uniqueId;//信息标识ID
	private String internalCode;//内码
	private String studentCode;//学籍编号
	private String schoolCode;//学校编号
	private String academyCode;//学院编号
	private String majorCode;//专业编号
	private String otherSchoolName;//其他学校名称
	private String otherAcademyName;//其他学院名称
	private String otherMajorName;//其他专业名称
	private Date admissionDate;//入学时间
	private Date finishSchoolDate;//毕业时间
	private String classNo;//班级
	private String schoolStudentId;//学号
	private String educationType;//就读学历
	private String education;//取得学历
	private Date createTime;//创建时间
	private Date modTime;//更新时间
	private String infoStatus;//信息状态
	private String whoDid;//操作者
	private String completing;//是否在读
	
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
	public String getStudentCode() {
		return studentCode;
	}
	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}
	public String getSchoolCode() {
		return schoolCode;
	}
	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}
	public String getAcademyCode() {
		return academyCode;
	}
	public void setAcademyCode(String academyCode) {
		this.academyCode = academyCode;
	}
	public String getMajorCode() {
		return majorCode;
	}
	public void setMajorCode(String majorCode) {
		this.majorCode = majorCode;
	}
	public String getOtherSchoolName() {
		return otherSchoolName;
	}
	public void setOtherSchoolName(String otherSchoolName) {
		this.otherSchoolName = otherSchoolName;
	}
	public String getOtherAcademyName() {
		return otherAcademyName;
	}
	public void setOtherAcademyName(String otherAcademyName) {
		this.otherAcademyName = otherAcademyName;
	}
	public String getOtherMajorName() {
		return otherMajorName;
	}
	public void setOtherMajorName(String otherMajorName) {
		this.otherMajorName = otherMajorName;
	}
	public Date getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}
	public Date getFinishSchoolDate() {
		return finishSchoolDate;
	}
	public void setFinishSchoolDate(Date finishSchoolDate) {
		this.finishSchoolDate = finishSchoolDate;
	}
	public String getClassNo() {
		return classNo;
	}
	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}
	public String getSchoolStudentId() {
		return schoolStudentId;
	}
	public void setSchoolStudentId(String schoolStudentId) {
		this.schoolStudentId = schoolStudentId;
	}
	public String getEducationType() {
		return educationType;
	}
	public void setEducationType(String educationType) {
		this.educationType = educationType;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
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
	
	
	public String getCompleting() {
		return completing;
	}
	public void setCompleting(String completing) {
		this.completing = completing;
	}
	@Override
    public String toString(){
        return 	uniqueId+"+"+internalCode+"+"+studentCode+"+"+schoolCode+"+"+academyCode
        		+"+"+majorCode+"+"+otherSchoolName+"+"+otherAcademyName+"+"+otherMajorName
        		+"+"+admissionDate+"+"+finishSchoolDate+"+"+classNo+"+"+schoolStudentId+"+"+educationType+"+"+education+"+"
        		+createTime+"+"+modTime+"+"+infoStatus+"+"+whoDid;
    }


	
}
