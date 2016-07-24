package com.yufeng.dao;

import java.util.List;

import com.yufeng.entity.RewardPunishmentInfo;

/**
 * Created by fishyu on 16/7/23
 */
public interface RewardPunishmentInfoDao {

    int isExistedRewardPunishmentInfo(int uniqueId,String internalCode);
    List<RewardPunishmentInfo> getRewardPunishmentInfoByInternalCode(String internalCode);
    int insertRewardPunishmentInfo(RewardPunishmentInfo rewardPunishmentInfo);
    int updateRewardPunishmentInfo(RewardPunishmentInfo rewardPunishmentInfo);
    int deleteRewardPunishmentInfo(RewardPunishmentInfo userBasicInfo);
    
}
