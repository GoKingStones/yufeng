package com.yufeng.service.impl;

import com.yufeng.dao.WorkerInfoDao;
import com.yufeng.entity.WorkerInfo;
import com.yufeng.service.WorkerInfoService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kingstones on 16/8/7.
 */
public class WorkerInfoServiceImpl implements WorkerInfoService {



    @Autowired
    private WorkerInfoDao workerInfoDao;

    public int insertWorkerInfo(WorkerInfo workerInfo) {
        return workerInfoDao.insertWorkerInfo(workerInfo);
    }

    public int updateWorkerInfo(WorkerInfo workerInfo) {

        //员工可以修改自己的基本信息：电话号码、工位固定号码、电子邮箱、微信号


        //管理员权限的员工可以修改其他员工的信息：1、信息修改；2密码重置
        return workerInfoDao.updateWorkerInfo(workerInfo);
    }

    public WorkerInfo getWorkerInfoByOrgId(String orgId) {
        return workerInfoDao.getWorkerInfoByOrgId(orgId);
    }

    public WorkerInfo getWorkerInfoByWorkerName(String workerName) {
        return workerInfoDao.getWorkerInfoByWorkerName(workerName);
    }

    public WorkerInfo getWorkerInfoByPhoneNumber(String phoneNumber) {
        return workerInfoDao.getWorkerInfoByPhoneNumber(phoneNumber);
    }


}
