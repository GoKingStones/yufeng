package com.yufeng.service.impl;

import com.yufeng.dao.RewardPunishmentInfoDao;
import com.yufeng.entity.RewardPunishmentInfo;
import com.yufeng.service.RewardPunishmentInfoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by fishyu on 16/7/23.
 */
public class RewardPunishmentInfoServiceImpl implements RewardPunishmentInfoService{

    @Autowired
    private RewardPunishmentInfoDao rewardPunishmentInfoDao;

	public List<RewardPunishmentInfo> getRewardPunishmentInfoByInternalCode(String internalCode) {
		return rewardPunishmentInfoDao.getRewardPunishmentInfoByInternalCode(internalCode);
	}

	public int insertRewardPunishmentInfo(RewardPunishmentInfo rewardPunishmentInfo) {
		
		return rewardPunishmentInfoDao.insertRewardPunishmentInfo(rewardPunishmentInfo);
	}

	public int updateRewardPunishmentInfo(RewardPunishmentInfo rewardPunishmentInfo) {
		return rewardPunishmentInfoDao.updateRewardPunishmentInfo(rewardPunishmentInfo);
	}

	public boolean isExistedRewardPunishmentInfo(int uniqueId,String internalCode) {
		int count =rewardPunishmentInfoDao.isExistedRewardPunishmentInfo(uniqueId, internalCode);
        boolean result =false;
        if(count !=0) result=true;
        return result;
	}


	public int deleteRewardPunishmentInfo(RewardPunishmentInfo rewardPunishmentInfo) {
		
		if(rewardPunishmentInfo.getWhoDid()!=null && rewardPunishmentInfo.getWhoDid().trim().equals("")){
		
			return rewardPunishmentInfoDao.deleteRewardPunishmentInfo(rewardPunishmentInfo);
		
		}else{
			
			return 0;
			
		}
		
	}

	
}
