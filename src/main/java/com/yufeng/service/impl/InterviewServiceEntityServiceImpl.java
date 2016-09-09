package com.yufeng.service.impl;

import com.yufeng.dao.InterviewServiceEntityDao;
import com.yufeng.entity.InterviewServiceEntity;
import com.yufeng.service.InterviewServiceEntityService;
import com.yufeng.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

/**
 * Created by kingstones on 16/8/7.
 */
public class InterviewServiceEntityServiceImpl implements InterviewServiceEntityService {

    @Autowired
    private InterviewServiceEntityDao interviewServiceEntityDao;


    public InterviewServiceEntity insertInterviewServiceEntity(InterviewServiceEntity interviewServiceEntity) {

        int result =  interviewServiceEntityDao.insertInterviewServiceEntity(interviewServiceEntity);
        if(result==1) {
            return interviewServiceEntityDao.getSingleInterviewServiceEntity(interviewServiceEntity.getWorkerId(),interviewServiceEntity.getInternalCode(), DateUtil.dateToString(interviewServiceEntity.getInterviewTime()));
        }else {
            return null;
        }
    }

    public InterviewServiceEntity updateInterviewServiceEntity(InterviewServiceEntity interviewServiceEntity) {
        int result =  interviewServiceEntityDao.updateInterviewServiceEntity(interviewServiceEntity);
        if(result==1) {
            return  interviewServiceEntityDao.getInterviewServiceEntityById(interviewServiceEntity.getId());
        }else {
            return null;
        }
    }

    public List<InterviewServiceEntity> getInterviewServiceEntityByWorkerId(int workerId) {
        return interviewServiceEntityDao.getInterviewServiceEntityByWorkerId(workerId);
    }

    public List<InterviewServiceEntity> getInterviewServiceEntityByInternalCode(String internalCode) {
        return interviewServiceEntityDao.getInterviewServiceEntityByInternalCode(internalCode);
    }

    public String getInterviewResultByInternalCode(String internalCode) {
        return interviewServiceEntityDao.getInterviewResultByInternalCode(internalCode);
    }
}
