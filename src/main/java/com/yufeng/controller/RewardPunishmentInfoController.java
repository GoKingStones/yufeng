package com.yufeng.controller;

import com.yufeng.entity.RewardPunishmentInfo;
import com.yufeng.service.RewardPunishmentInfoService;
import com.yufeng.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by fishyu on 16/7/23.
 */
@RestController
public class RewardPunishmentInfoController {

    @Autowired
    private RewardPunishmentInfoService rewardPunishmentInfoService;

    
    @RequestMapping("isExistedRewardPunishmentInfo")

    public boolean isExistedRewardPunishmentInfo(@RequestParam("uniqueId") int uniqueId,@RequestParam("internalCode") String internalCode) {

        boolean result = rewardPunishmentInfoService.isExistedRewardPunishmentInfo(uniqueId, internalCode);
        return result;
    }

    @RequestMapping("getRewardPunishmentInfoByInternalCode")
    public List<RewardPunishmentInfo> getRewardPunishmentInfoByInternalCode(@RequestParam("internalCode") String internalCode){

    	List<RewardPunishmentInfo> rewardPunishmentInfoList = new ArrayList<RewardPunishmentInfo>();
    	rewardPunishmentInfoList = rewardPunishmentInfoService.getRewardPunishmentInfoByInternalCode(internalCode);
        
        return rewardPunishmentInfoList;
    }

    @RequestMapping("insertRewardPunishmentInfo")
    @ResponseBody
    public Map<String,String> insertRewardPunishmentInfo(@RequestBody RewardPunishmentInfo rewardPunishmentInfo) throws ParseException{

    	ResultMap resultMap=new ResultMap();
    	
    	if(rewardPunishmentInfoService.isExistedRewardPunishmentInfo(rewardPunishmentInfo.getUniqueId(), rewardPunishmentInfo.getInternalCode())){
    		
    		return resultMap.getExistIDErrorMap();
    		
    	}else{
    		 
    		int result = rewardPunishmentInfoService.insertRewardPunishmentInfo(rewardPunishmentInfo);
    		
    		if (result==0) {
 	            return resultMap.getErrorMap();
 	        }else {
 	            return resultMap.getSuccessMap();
 	        }
    	}

    }

    @RequestMapping("updateRewardPunishmentInfo")
    public Map<String,String> updateRewardPunishmentInfo(RewardPunishmentInfo rewardPunishmentInfo) {

        ResultMap resultMap=new ResultMap();
        
        if(rewardPunishmentInfoService.isExistedRewardPunishmentInfo(rewardPunishmentInfo.getUniqueId(), rewardPunishmentInfo.getInternalCode())){
        	
    	    int result=rewardPunishmentInfoService.updateRewardPunishmentInfo(rewardPunishmentInfo);
    	    if (result==0) {
    	        return resultMap.getErrorMap();
    	    }else {
    	        return resultMap.getSuccessMap();
    	    }
    	   
        }else{
        	
        	return resultMap.getnotExistIDErrorMap();
        	
        }
    }
    
    
    @RequestMapping("deleteRewardPunishmentInfo")
    public Map<String,String> deleteRewardPunishmentInfo(RewardPunishmentInfo rewardPunishmentInfo) {

        ResultMap resultMap=new ResultMap();
        
        if(rewardPunishmentInfoService.isExistedRewardPunishmentInfo(rewardPunishmentInfo.getUniqueId(), rewardPunishmentInfo.getInternalCode())){
        	
    	    int result=rewardPunishmentInfoService.deleteRewardPunishmentInfo(rewardPunishmentInfo);
    	    if (result==0) {
    	        return resultMap.getErrorMap();
    	    }else {
    	        return resultMap.getSuccessMap();
    	    }
    	   
        }else{
        	
        	return resultMap.getnotExistIDErrorMap();
        	
        }
    }

}
