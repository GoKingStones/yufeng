package com.yufeng.dao;

import com.yufeng.entity.InterviewServiceEntity;

/**
 * Created by kingstones on 16/8/7.
 * 面签服务DAO层
 */
public interface InterviewServiceEntityDao {

    //插入面签服务entity
    public int insertInterviewServiceEntity(InterviewServiceEntity interviewServiceEntity);

    //更新面签服务
    public int updateInterviewServiceEntity(InterviewServiceEntity interviewServiceEntity);

    //根据客户经理ID查询面签服务
    public InterviewServiceEntity getInterviewServiceEntityByWorkerId(int workerId);

    //根据用户内码查询面签服务
    public InterviewServiceEntity getInterviewServiceEntityByInternalCode(String internalCode);

}
