package com.yufeng.service;

import java.util.List;

import com.yufeng.entity.RewardPunishmentInfo;

/**
 * Created by fishyu on 16/7/23.
 */
public interface RewardPunishmentInfoService {

    boolean isExistedRewardPunishmentInfo(int uniqueId,String internalCode);
    List<RewardPunishmentInfo> getRewardPunishmentInfoByInternalCode(String internalCode);
    int insertRewardPunishmentInfo(RewardPunishmentInfo rewardPunishmentInfo);
    int updateRewardPunishmentInfo(RewardPunishmentInfo rewardPunishmentInfo);
    int deleteRewardPunishmentInfo(RewardPunishmentInfo rewardPunishmentInfo);
    
}
