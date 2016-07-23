package com.yufeng.service;

import com.yufeng.dao.RegisterAccountDao;
import com.yufeng.entity.RegisterAccount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by kingstones on 16/7/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/*.xml"})
public class RegisterAccountServiceTest {

    @Resource
    private RegisterAccountDao registerAccountDao;

    @Resource
    private RegisterAccountService registerAccountService;

    @Test
    public void testGetRegisterAccount() throws Exception {

        registerAccountService.getRegisterAccount("wrong");
        int x = registerAccountService.updateRegisterAccountPassword("wangleilei","cccc");
        System.out.println(x);
    }

    @Test
    public void testInsertRegisterAccount() throws Exception {

        RegisterAccount registerAccount=new RegisterAccount();
        registerAccount.setAccountFlag("a");
        registerAccount.setName("wangleilei6666");
        registerAccount.setPassword("root");
        registerAccount.setPhoneNumber("22222222");
        registerAccount.setSource("a");
        registerAccount.setCreateTime(new Date(-100000));
        int x =registerAccountDao.insertRegisterAccount(registerAccount);
        System.out.println(x);
        registerAccount.setPhoneNumber("666666666");
        int y = registerAccountDao.updateRegisterAccount(registerAccount);
        System.out.println(y);
    }

    @Test
    public void testUpdateRegisterAccount() throws Exception {

        RegisterAccount registerAccount=new RegisterAccount();
        registerAccount.setAccountFlag("a");
        registerAccount.setName("wangle");
        registerAccount.setPassword("root");
        registerAccount.setPhoneNumber("22222222");
        registerAccount.setSource("a");
        registerAccount.setPhoneNumber("5555ffff");
        int y = registerAccountDao.updateRegisterAccount(registerAccount);
        System.out.println(y);
    }

    @Test
    public void testDeleteRegisterAccount() throws Exception {

    }

    @Test
    public void testUpdateRegisterAccountPassword(){
        int x = registerAccountDao.updateRegisterAccountPassword("wangleilei","wangleilei");
        System.out.println(x);
    }
}