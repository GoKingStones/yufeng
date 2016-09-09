package com.yufeng.dao;

import com.yufeng.entity.UrgeRepaymentServiceEntity;
import com.yufeng.util.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by kingstones on 16/9/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/*.xml"})
public class UrgeRepaymentServiceEntityDaoTest {

    @Resource
    private UrgeRepaymentServiceEntityDao urgeRepaymentServiceEntityDao;

    @Test
    public void testInsertUrgeRepaymentServiceEntity() throws Exception {
        UrgeRepaymentServiceEntity urgeRepaymentServiceEntity=new UrgeRepaymentServiceEntity();
        urgeRepaymentServiceEntity.setDetail("xxx");
        urgeRepaymentServiceEntity.setInternalCode("hello");
        urgeRepaymentServiceEntity.setRepayment(new BigDecimal(122.2));
        urgeRepaymentServiceEntity.setUrgeMode("电话催款");
        urgeRepaymentServiceEntity.setUrgeStatus("未还");
        urgeRepaymentServiceEntity.setUrgeTime(new Date());
        urgeRepaymentServiceEntity.setUrgeType("电话催款");
        urgeRepaymentServiceEntity.setWorkerId(1);
        urgeRepaymentServiceEntityDao.insertUrgeRepaymentServiceEntity(urgeRepaymentServiceEntity);
    }

    @Test
    public void testUpdateUrgeRepaymentServiceEntity() throws Exception {

        UrgeRepaymentServiceEntity urgeRepaymentServiceEntity=new UrgeRepaymentServiceEntity();
        urgeRepaymentServiceEntity.setId(1);
        urgeRepaymentServiceEntity.setWorkerId(1);
        urgeRepaymentServiceEntity.setRepayment(new BigDecimal(12));
        urgeRepaymentServiceEntityDao.updateUrgeRepaymentServiceEntity(urgeRepaymentServiceEntity);
        List<UrgeRepaymentServiceEntity> urgeRepaymentServiceEntities=urgeRepaymentServiceEntityDao.getUrgeRepaymentServiceEntityByWorkerId(1);
        for(UrgeRepaymentServiceEntity urgeRepaymentServiceEntity1:urgeRepaymentServiceEntities) {
            System.out.println(urgeRepaymentServiceEntity1.getRepayment());
        }
    }

    @Test
    public void testGetUrgeRepaymentServiceEntityByWorkerId() throws Exception {

        List<UrgeRepaymentServiceEntity> urgeRepaymentServiceEntities=urgeRepaymentServiceEntityDao.getUrgeRepaymentServiceEntityByWorkerId(1);
        for(UrgeRepaymentServiceEntity urgeRepaymentServiceEntity:urgeRepaymentServiceEntities) {
            System.out.println(urgeRepaymentServiceEntity.getRepayment());
        }
    }

    @Test
    public void testGetUrgeRepaymentServiceEntityByInternalCode() throws Exception {

        List<UrgeRepaymentServiceEntity> urgeRepaymentServiceEntities=urgeRepaymentServiceEntityDao.getUrgeRepaymentServiceEntityByInternalCode("hello");

        for(UrgeRepaymentServiceEntity urgeRepaymentServiceEntity:urgeRepaymentServiceEntities) {
            System.out.println(urgeRepaymentServiceEntity.getRepayment());
        }
    }

    @Test
    public void testGetSingleUrgeRepaymentServiceEntity() throws Exception {

        UrgeRepaymentServiceEntity urgeRepaymentServiceEntity = urgeRepaymentServiceEntityDao.getSingleUrgeRepaymentServiceEntity(1, "hello", "2016-09-05 10:21:48");

        System.out.println(urgeRepaymentServiceEntity.getInternalCode());
    }

}