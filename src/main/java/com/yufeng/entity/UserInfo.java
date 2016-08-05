package com.yufeng.entity;

import java.util.List;

public class UserInfo {
	
	//客户基本信息
	private UserBasicInfo userBasicInfo;
	
	//客户学业信息
	private List<SchoolExperienceInfo> schoolExperienceInfoList;
	
	//客户银行卡信息
	private List<UserBankCardInfo> userBankCardInfoList;
	
	//客户金融账户信息
	private List<UserFinancialAccountInfo> userFinancialAccountInfoList;
	
	//客户联系人信息
	private List<UserFamilyInfo> userFamilyInfoList;
	
	//客户奖惩信息
	private List<RewardPunishmentInfo> rewardPunishmentInfoList;
	

	public UserBasicInfo getUserBasicInfo() {
		return userBasicInfo;
	}

	public void setUserBasicInfo(UserBasicInfo userBasicInfo) {
		this.userBasicInfo = userBasicInfo;
	}

	public List<SchoolExperienceInfo> getSchoolExperienceInfoList() {
		return schoolExperienceInfoList;
	}

	public void setSchoolExperienceInfoList(List<SchoolExperienceInfo> schoolExperienceInfoList) {
		this.schoolExperienceInfoList = schoolExperienceInfoList;
	}

	public List<UserBankCardInfo> getUserBankCardInfoList() {
		return userBankCardInfoList;
	}

	public void setUserBankCardInfoList(List<UserBankCardInfo> userBankCardInfoList) {
		this.userBankCardInfoList = userBankCardInfoList;
	}

	public List<UserFinancialAccountInfo> getUserFinancialAccountInfoList() {
		return userFinancialAccountInfoList;
	}

	public void setUserFinancialAccountInfoList(List<UserFinancialAccountInfo> userFinancialAccountInfoList) {
		this.userFinancialAccountInfoList = userFinancialAccountInfoList;
	}

	public List<UserFamilyInfo> getUserFamilyInfoList() {
		return userFamilyInfoList;
	}

	public void setUserFamilyInfoList(List<UserFamilyInfo> userFamilyInfoList) {
		this.userFamilyInfoList = userFamilyInfoList;
	}

	public List<RewardPunishmentInfo> getRewardPunishmentInfoList() {
		return rewardPunishmentInfoList;
	}

	public void setRewardPunishmentInfoList(List<RewardPunishmentInfo> rewardPunishmentInfoList) {
		this.rewardPunishmentInfoList = rewardPunishmentInfoList;
	}
	
}
