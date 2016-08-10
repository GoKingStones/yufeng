package com.yufeng.dao;

import com.yufeng.entity.RegisterAccount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by kingstones on 16/7/17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class RegisterAccountDaoTest {

    @Resource
    private RegisterAccountDao registerAccountDao;

    @Test
    public void testGetRegisterAccount() throws Exception {

        RegisterAccount registerAccount =registerAccountDao.getRegisterAccount("ROOT");
        System.out.println(registerAccount);
    }

    @Test
    public void testInsertRegisterAccount() throws Exception {

        RegisterAccount registerAccount=new RegisterAccount();
        registerAccount.setAccountFlag("a");
        registerAccount.setAccountName("wangleilei");
        registerAccount.setPassword("root");
        registerAccount.setPhoneNumber("22222222");
        registerAccount.setSource("a");
        registerAccountDao.insertRegisterAccount(registerAccount);
    }

    @Test
    public void testUpdateRegisterAccount() throws Exception {

        RegisterAccount registerAccount=new RegisterAccount();
        registerAccount.setAccountFlag("a");
        registerAccount.setAccountName("wangleilei");
        registerAccount.setPassword("root");
        registerAccount.setPhoneNumber("33333333");
        registerAccount.setSource("a");
        int x =registerAccountDao.updateRegisterAccount(registerAccount);
        System.out.println(x);
    }

    @Test
    public void testDeleteRegisterAccount() throws Exception {

    }
}