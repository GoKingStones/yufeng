package com.yufeng.dao;

import com.yufeng.entity.InterviewServiceEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

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
    public List<InterviewServiceEntity> getInterviewServiceEntityByWorkerId(int workerId);

    //根据用户内码查询面签服务
    public List<InterviewServiceEntity> getInterviewServiceEntityByInternalCode(String internalCode);

    //获取用户的面签结果
    public String getInterviewResultByInternalCode(String internalCode);

    public InterviewServiceEntity getInterviewServiceEntityById(int id);

    public InterviewServiceEntity getSingleInterviewServiceEntity(@Param("workerId")int workerId,@Param("internalCode")String internalCode,@Param("interviewTime")String interviewTime);
}
