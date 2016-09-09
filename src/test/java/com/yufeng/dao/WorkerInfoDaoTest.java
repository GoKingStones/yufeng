package com.yufeng.dao;

import com.yufeng.entity.WorkerInfo;
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
public class WorkerInfoDaoTest {

    @Resource
    private WorkerInfoDao workerInfoDao;
    @Test
    public void testInsertWorkerInfo() throws Exception {

        WorkerInfo workerInfo = new WorkerInfo();
        workerInfo.setCategory("XX");
        workerInfo.setCreator("ADMIN");
        workerInfo.setEmail("33992991@");
        workerInfo.setIdNumber("150125198912025318");
        workerInfo.setIdType("0");
        workerInfo.setOrgId("XXX");
        workerInfo.setPassword("123456");
        workerInfo.setPhoneNumber("13827847372");
        workerInfo.setPositionLevel("HZONGJI");
        workerInfo.setWeixinNo("3929291");
        workerInfo.setWorkerName("王磊");
        workerInfo.setWorkerPosition("中级");
        workerInfo.setWorkerStatus("在职");
        workerInfo.setWorkPhone("13827277221");
        System.out.println(workerInfoDao.insertWorkerInfo(workerInfo));
    }

    @Test
    public void testUpdateWorkerInfoByAdmin() throws Exception {

        WorkerInfo workerInfo=workerInfoDao.getWorkInfoByWorkerId(1);
        workerInfo.setPhoneNumber("23444");
        workerInfo.setCategory("zzz");
        System.out.println(workerInfoDao.updateWorkerInfoByAdmin(workerInfo));
        WorkerInfo workerInfo1=workerInfoDao.getWorkInfoByWorkerId(1);
        System.out.println(workerInfo1.getCategory());
        System.out.println(workerInfo1.getPhoneNumber());
    }

    @Test
    public void testUpdateWorkerInfo() throws Exception {

        WorkerInfo workerInfo=workerInfoDao.getWorkInfoByWorkerId(1);
        workerInfo.setPhoneNumber("1233232232");
        workerInfo.setCategory("y");
        System.out.println(workerInfoDao.updateWorkerInfo(workerInfo));
        WorkerInfo workerInfo1=workerInfoDao.getWorkInfoByWorkerId(1);
        System.out.println(workerInfo1.getCategory());
        System.out.println(workerInfo1.getPhoneNumber());
    }

    @Test
    public void testGetWorkInfoByWorkerId() throws Exception {

    }

    @Test
    public void testGetWorkerInfoByWorkerName() throws Exception {

        WorkerInfo workerInfo=workerInfoDao.getWorkerInfoByWorkerName("王磊");
        System.out.println(workerInfo);
    }

    @Test
    public void testGetWorkerInfoByPhoneNumber() throws Exception {

        WorkerInfo workerInfo=workerInfoDao.getWorkerInfoByWorkerName("13827277221");
        System.out.println(workerInfo);
    }
}