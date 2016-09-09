package com.yufeng.dao;

import com.yufeng.entity.InterviewServiceEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.io.File;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by kingstones on 16/9/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/*.xml"})
public class InterviewServiceEntityDaoTest {

    @Resource
    private InterviewServiceEntityDao interviewServiceEntityDao;
    @Test
    public void testInsertInterviewServiceEntity() throws Exception {

        InterviewServiceEntity interviewServiceEntity=new InterviewServiceEntity();
        interviewServiceEntity.setDetail("xxx");
        interviewServiceEntity.setInternalCode("hello");
        interviewServiceEntity.setInterviewPlace("塘沽");
        interviewServiceEntity.setInterviewResult("不通过");
        interviewServiceEntity.setInterviewTime(new Date());
        interviewServiceEntity.setPhotoUrl("Users"+ File.separator+"kingstones");
        interviewServiceEntity.setWorkerId(1);
        interviewServiceEntityDao.insertInterviewServiceEntity(interviewServiceEntity);
    }

    @Test
    public void testUpdateInterviewServiceEntity() throws Exception {


    }

    @Test
    public void testGetInterviewServiceEntityByWorkerId() throws Exception {

       List<InterviewServiceEntity> interviewServiceEntity=interviewServiceEntityDao.getInterviewServiceEntityByWorkerId(1);
        for (InterviewServiceEntity interviewServiceEntity1:interviewServiceEntity) {
            System.out.println(interviewServiceEntity1.getInterviewResult());
        }
    }

    @Test
    public void testGetInterviewServiceEntityByInternalCode() throws Exception {

        List<InterviewServiceEntity> interviewServiceEntity=interviewServiceEntityDao.getInterviewServiceEntityByInternalCode("hello");
        for (InterviewServiceEntity interviewServiceEntity1:interviewServiceEntity) {
            System.out.println(interviewServiceEntity1.getInterviewResult());
        }
    }

    @Test
    public void testGetInterviewResultByInternalCode() throws Exception {

        String result = interviewServiceEntityDao.getInterviewResultByInternalCode("hello");
        System.out.println(result);
    }
}