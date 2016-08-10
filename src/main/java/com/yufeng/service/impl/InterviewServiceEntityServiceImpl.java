package com.yufeng.service.impl;

import com.yufeng.dao.InterviewServiceEntityDao;
import com.yufeng.entity.InterviewServiceEntity;
import com.yufeng.service.InterviewServiceEntityService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kingstones on 16/8/7.
 */
public class InterviewServiceEntityServiceImpl implements InterviewServiceEntityService {

    @Autowired
    private InterviewServiceEntityDao interviewServiceEntityDao;
    public int insertInterviewServiceEntity(InterviewServiceEntity interviewServiceEntity) {
        return interviewServiceEntityDao.insertInterviewServiceEntity(interviewServiceEntity);
    }

    public int updateInterviewServiceEntity(InterviewServiceEntity interviewServiceEntity) {
        return interviewServiceEntityDao.updateInterviewServiceEntity(interviewServiceEntity);
    }

    public InterviewServiceEntity getInterviewServiceEntityByWorkerId(int workerId) {
        return interviewServiceEntityDao.getInterviewServiceEntityByWorkerId(workerId);
    }

    public InterviewServiceEntity getInterviewServiceEntityByInternalCode(String internalCode) {
        return interviewServiceEntityDao.getInterviewServiceEntityByInternalCode(internalCode);
    }
}
