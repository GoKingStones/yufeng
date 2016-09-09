package com.yufeng.dao;

import com.yufeng.entity.CollegeEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by kingstones on 16/9/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/*.xml"})
public class CollegeEntityDaoTest {

    @Resource
    private CollegeEntityDao collegeEntityDao;

    @Test
    public void testGetCollegeEntity() throws Exception {

        CollegeEntity collegeEntity = collegeEntityDao.getCollegeEntity("特色");
        System.out.println(collegeEntity);
    }

    @Test
    public void testInsertCollegeEntity() throws Exception {

        CollegeEntity collegeEntity=new CollegeEntity();
        collegeEntity.setCityCode("1");
        collegeEntity.setCityCode("1");
        collegeEntity.setCollegeName("特色");
        int result = collegeEntityDao.insertCollegeEntity(collegeEntity);
        System.out.println(result);
    }

    @Test
    public void testGetCollegeAcademyEntityByCollegeCode() throws Exception {

        CollegeEntity collegeEntity = collegeEntityDao.getCollegeAcademyEntityByCollegeCode("1");
        System.out.println(collegeEntity);
    }
}