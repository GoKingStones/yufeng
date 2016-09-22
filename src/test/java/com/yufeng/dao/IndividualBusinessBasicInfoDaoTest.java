package com.yufeng.dao;

import com.yufeng.entity.IndividualBusinessBasicInfo;
import com.yufeng.util.InternalCodeGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by kingstones on 16/9/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/*.xml"})
public class IndividualBusinessBasicInfoDaoTest {

    @Resource
    private IndividualBusinessBasicInfoDao individualBusinessBasicInfoDao;

    @Test
    public void testIsExistedIndividualBusinessBasicInfo() throws Exception {

        int result = individualBusinessBasicInfoDao.isExistedIndividualBusinessBasicInfo(InternalCodeGenerator.getCode("150125198912025318"));
        System.out.println(result);

    }

    @Test
    public void testIsExistedShopName() throws Exception {
        int result = individualBusinessBasicInfoDao.isExistedShopName("熊猫小店");
        System.out.println(result);
    }

    @Test
    public void testGetIndividualBusinessBasicInfo() throws Exception {

        IndividualBusinessBasicInfo individualBusinessBasicInfo=individualBusinessBasicInfoDao.getIndividualBusinessBasicInfo(InternalCodeGenerator.getCode("150125198912025318"));
        System.out.println(individualBusinessBasicInfo);
    }

    @Test
    public void testInsertIndividualBusinessBasicInfo() throws Exception {

        IndividualBusinessBasicInfo individualBusinessBasicInfo=new IndividualBusinessBasicInfo();
        individualBusinessBasicInfo.setShopName("熊猫小店");
        individualBusinessBasicInfo.setLocalArea("天津");
        individualBusinessBasicInfo.setOpenTime(new Date());
        individualBusinessBasicInfo.setShopAddr("塘沽");
        individualBusinessBasicInfo.setShopCreditValue(22);
        individualBusinessBasicInfo.setShopkeeperCertificateNumber("150125198912025318");
        individualBusinessBasicInfo.setShopkeeperCertificateType(0);
        individualBusinessBasicInfo.setShopkeeperName("王磊");
        individualBusinessBasicInfo.setShopRank("333");
        individualBusinessBasicInfo.setShopScope(222);
        individualBusinessBasicInfo.setShopStatus("yiyan");
        individualBusinessBasicInfo.setShopTel("13883732712");
        individualBusinessBasicInfo.setInternalCode(InternalCodeGenerator.getCode("150125198912025318"));
        int result = individualBusinessBasicInfoDao.insertIndividualBusinessBasicInfo(individualBusinessBasicInfo);
        System.out.println(result);
    }

    @Test
    public void testUpdateIndividualBusinessBasicInfo() throws Exception {

        IndividualBusinessBasicInfo individualBusinessBasicInfo=individualBusinessBasicInfoDao.getIndividualBusinessBasicInfo(InternalCodeGenerator.getCode("150125198912025318"));
        System.out.println(individualBusinessBasicInfo);
        individualBusinessBasicInfo.setLocalArea("上海");
        individualBusinessBasicInfoDao.updateIndividualBusinessBasicInfo(individualBusinessBasicInfo);
        IndividualBusinessBasicInfo individualBusinessBasicInfo1=individualBusinessBasicInfoDao.getIndividualBusinessBasicInfo(InternalCodeGenerator.getCode("150125198912025318"));
        System.out.println(individualBusinessBasicInfo1);
    }


}