package com.yufeng.dao;

import com.yufeng.entity.EnterpriseBusinessBasicInfo;
import com.yufeng.util.InternalCodeGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by kingstones on 16/9/1.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/*.xml"})
public class EnterpriseBusinessBasicInfoDaoTest {

    @Resource
    private EnterpriseBusinessBasicInfoDao enterpriseBusinessBasicInfoDao;

    @Test
    public void testIsExistedEnterpriseBusinessBasicInfo() throws Exception {

        int result = enterpriseBusinessBasicInfoDao.isExistedEnterpriseBusinessBasicInfo(InternalCodeGenerator.getCode(0, "150125198912025318"));
        System.out.println(result);
    }

    @Test
    public void testIsExistedBusinessName() throws Exception {

        int result = enterpriseBusinessBasicInfoDao.isExistedBusinessName("蒂芙尼");
        System.out.println(result);
    }

    @Test
    public void testIsExistedBusinessLicenceNumber() throws Exception {

        int result =  enterpriseBusinessBasicInfoDao.isExistedBusinessLicenseNumber("123456");
        System.out.println(result);
    }

    @Test
    public void testGetEnterpriseBusinessBasicInfo() throws Exception {

        System.out.println(InternalCodeGenerator.getCode(0, "150125198912025318"));
        EnterpriseBusinessBasicInfo enterpriseBusinessBasicInfo=enterpriseBusinessBasicInfoDao.getEnterpriseBusinessBasicInfo(InternalCodeGenerator.getCode(0, "150125198912025318"));
        System.out.println(enterpriseBusinessBasicInfo);
    }

    @Test
    public void testInsertEnterpriseBusinessBasicInfo() throws Exception {

        EnterpriseBusinessBasicInfo enterpriseBusinessBasicInfo=new EnterpriseBusinessBasicInfo();
        enterpriseBusinessBasicInfo.setBusinessName("蒂芙尼");
        enterpriseBusinessBasicInfo.setEnterpriseName("蒂芙尼");
        enterpriseBusinessBasicInfo.setBusinessCreditValue(0);
        enterpriseBusinessBasicInfo.setBusinessScore(100);
        enterpriseBusinessBasicInfo.setBusinessBrand("奢侈品");
        enterpriseBusinessBasicInfo.setBusinessLicenceManagementScope("10000330");
        enterpriseBusinessBasicInfo.setBusinessLicenseNumber("123456");
        enterpriseBusinessBasicInfo.setBusinessRank("中等");
        enterpriseBusinessBasicInfo.setEmail("339192618");
        enterpriseBusinessBasicInfo.setEnterpriseAddr("天津市塘沽区");
        enterpriseBusinessBasicInfo.setFax("11122");
        enterpriseBusinessBasicInfo.setLegalPersonCertificateNumber("150125198912025318");
        enterpriseBusinessBasicInfo.setLegalPersonCertificateType(0);
        enterpriseBusinessBasicInfo.setManageContactName("王磊");
        enterpriseBusinessBasicInfo.setManageContactTel("18727273737");
        enterpriseBusinessBasicInfo.setOpenTime(new Date());
        enterpriseBusinessBasicInfo.setRegisteredCapital(new BigDecimal(222.222));
        enterpriseBusinessBasicInfo.setLegalPersonName("王磊");
        enterpriseBusinessBasicInfo.setWebsite("www.xxx.com");
        enterpriseBusinessBasicInfo.setInternalCode(InternalCodeGenerator.getCode(0,"150125198912025318"));
        int result = enterpriseBusinessBasicInfoDao.insertEnterpriseBusinessBasicInfo(enterpriseBusinessBasicInfo);

        System.out.println(result);
    }

    @Test
    public void testUpdateEnterpriseBusinessBasicInfo() throws Exception {

        EnterpriseBusinessBasicInfo enterpriseBusinessBasicInfo=enterpriseBusinessBasicInfoDao.getEnterpriseBusinessBasicInfo(InternalCodeGenerator.getCode(0,"150125198912025318"));

        enterpriseBusinessBasicInfo.setBusinessBrand("骨瓷");
        int result = enterpriseBusinessBasicInfoDao.updateEnterpriseBusinessBasicInfo(enterpriseBusinessBasicInfo);
        System.out.println(result);
        EnterpriseBusinessBasicInfo enterpriseBusinessBasicInfo1=enterpriseBusinessBasicInfoDao.getEnterpriseBusinessBasicInfo(InternalCodeGenerator.getCode(0,"150125198912025318"));

        System.out.println(enterpriseBusinessBasicInfo1);


    }
}