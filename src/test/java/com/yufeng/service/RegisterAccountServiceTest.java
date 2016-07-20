package com.yufeng.service;

import com.yufeng.dao.RegisterAccountDao;
import com.yufeng.entity.RegisterAccount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by kingstones on 16/7/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class RegisterAccountServiceTest {

    @Resource
    private RegisterAccountService registerAccountService;
    @Test
    public void testGetRegisterAccount() throws Exception {

    }

    @Test
    public void testInsertRegisterAccount() throws Exception {

        RegisterAccount registerAccount=new RegisterAccount();
        registerAccount.setAccountFlag("a");
        registerAccount.setName("wangleilei11");
        registerAccount.setPassword("root");
        registerAccount.setPhoneNumber("22222222");
        registerAccount.setSource("a");
        int x =registerAccountService.insertRegisterAccount(registerAccount);
        System.out.println(x);
    }

    @Test
    public void testUpdateRegisterAccount() throws Exception {

    }

    @Test
    public void testDeleteRegisterAccount() throws Exception {

    }
}