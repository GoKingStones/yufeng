package com.yufeng.dao;

import com.yufeng.entity.CustomServiceEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by kingstones on 16/9/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/*.xml"})
public class CustomServiceEntityDaoTest {

    @Resource
    private CustomServiceEntityDao customServiceEntityDao;

    @Test
    public void testInsertCustomServiceEntity() throws Exception {

        CustomServiceEntity customServiceEntity=new CustomServiceEntity();
        customServiceEntity.setDetail("非常好");
        customServiceEntity.setInternalCode("YYYY");
        customServiceEntity.setServiceLevel("满意");
        customServiceEntity.setServiceMode("面谈");
        customServiceEntity.setServiceTime(new Date());
        customServiceEntity.setServiceType("XXX");
        customServiceEntity.setWorkerId(1);
        System.out.println(customServiceEntityDao.insertCustomServiceEntity(customServiceEntity));
    }

    @Test
    public void testUpdateCustomServiceEntity() throws Exception {


    }

    @Test
    public void testGetCustomServiceEntityByWorkerId() throws Exception {

        List<CustomServiceEntity> customServiceEntities=customServiceEntityDao.getCustomServiceEntityByWorkerId(1);
        for(CustomServiceEntity customServiceEntity:customServiceEntities) {
            System.out.println(customServiceEntity.getInternalCode());
        }
    }

    @Test
    public void testGetCustomServiceEntityByInternalCode() throws Exception {

        List<CustomServiceEntity> customServiceEntities=customServiceEntityDao.getCustomServiceEntityByInternalCode("XXX");
        for(CustomServiceEntity customServiceEntity:customServiceEntities) {
            System.out.println(customServiceEntity.getWorkerId());
        }
    }
}