package com.yufeng.dao;

import com.yufeng.entity.FastConsumerLoanOrder;
import com.yufeng.entity.FastConsumerLoanOrderCommodity;
import com.yufeng.util.OrderStateEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by kingstones on 16/9/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/*.xml"})
public class FastConsumerLoanOrderDaoTest {

    @Resource
    private FastConsumerLoanOrderDao fastConsumerLoanOrderDao;

    @Test
    public void testCancelConsumerLoanOrder() throws Exception {

        FastConsumerLoanOrder fastConsumerLoanOrder=fastConsumerLoanOrderDao.getFastConsumerLoanOrderByOrderId(0);
        fastConsumerLoanOrder.setOrderState(OrderStateEnum.已取消.name());
        fastConsumerLoanOrder.setCancelTime(new Date());
        fastConsumerLoanOrderDao.updateFastConsumerLoanOrder(fastConsumerLoanOrder);

    }

    @Test
    public void testGetFastConsumerLoanOrderByOrderId() throws Exception {

        FastConsumerLoanOrder fastConsumerLoanOrder=fastConsumerLoanOrderDao.getFastConsumerLoanOrderByOrderId(0);

        System.out.println(fastConsumerLoanOrder.getCreateTime().getTime());
    }

    @Test
    public void testInsertFastConsumerLoanOrder() throws Exception {

        FastConsumerLoanOrder fastConsumerLoanOrder=new FastConsumerLoanOrder();
        fastConsumerLoanOrder.setInterest(new BigDecimal(10));
        fastConsumerLoanOrder.setTotalAmount(new BigDecimal(1000));
        fastConsumerLoanOrder.setDiscountAmount(new BigDecimal(900));
        fastConsumerLoanOrder.setFreight(new BigDecimal(10));
        fastConsumerLoanOrder.setInstallType("快消品 ");
        fastConsumerLoanOrder.setInstallCount(12);
        fastConsumerLoanOrder.setUserInternalCode("xxxxx");
        fastConsumerLoanOrder.setActualTotalAmount(new BigDecimal(920));

        long result = fastConsumerLoanOrderDao.insertFastConsumerLoanOrder(fastConsumerLoanOrder);
        System.out.println(fastConsumerLoanOrder.getOrderId());





    }

    @Test
    public void testUpdateFastConsumerLoanOrder() throws Exception {

    }

    @Test
    public void testGetFastConsumerLoanOrderCommodityById() throws Exception {



    }

    @Test
    public void testGetFastConsumerLoanOrderCommodityByOrderId() throws Exception {

    }

    @Test
    public void testInsertFastConsumerLoanOrderCommodityList() throws Exception {

        List<FastConsumerLoanOrderCommodity> list=new ArrayList<FastConsumerLoanOrderCommodity>();
        FastConsumerLoanOrderCommodity fastConsumerLoanOrderCommodity=new FastConsumerLoanOrderCommodity();
        fastConsumerLoanOrderCommodity.setCommodityId("100");
        fastConsumerLoanOrderCommodity.setCommodityName("nokia");
        fastConsumerLoanOrderCommodity.setCommodityNumber(1);
        fastConsumerLoanOrderCommodity.setOrderId(0);
        fastConsumerLoanOrderCommodity.setPrice(new BigDecimal(2000));
        fastConsumerLoanOrderCommodity.setSellerInternalCode("yyyy");
        fastConsumerLoanOrderCommodity.setTotalAmount(new BigDecimal(2000));
        fastConsumerLoanOrderCommodity.setUniqueId("0");
        fastConsumerLoanOrderCommodity.setUserInternalCode("xxxx");

        list.add(fastConsumerLoanOrderCommodity);

        FastConsumerLoanOrderCommodity fastConsumerLoanOrderCommodity1=new FastConsumerLoanOrderCommodity();
        fastConsumerLoanOrderCommodity1.setCommodityId("200");
        fastConsumerLoanOrderCommodity1.setCommodityName("lg");
        fastConsumerLoanOrderCommodity1.setCommodityNumber(2);
        fastConsumerLoanOrderCommodity1.setOrderId(0);
        fastConsumerLoanOrderCommodity1.setPrice(new BigDecimal(1000));
        fastConsumerLoanOrderCommodity1.setSellerInternalCode("yyyy");
        fastConsumerLoanOrderCommodity1.setTotalAmount(new BigDecimal(2000));
        fastConsumerLoanOrderCommodity1.setUniqueId("1");
        fastConsumerLoanOrderCommodity1.setUserInternalCode("xxxx");
        list.add(fastConsumerLoanOrderCommodity1);
        int result = fastConsumerLoanOrderDao.insertFastConsumerLoanOrderCommodityList(list);
        System.out.println(result);
    }

    @Test
    public void testInsertFastConsumerLoanOrderCommodity() throws Exception {

    }

    @Test
    public void testUpdateFastConsumerLoanOrderCommodity() throws Exception {

    }

    @Test
    public void testUpdateFastConsumerLoanOrderCommodityList() throws Exception {

        List<FastConsumerLoanOrderCommodity> list=new ArrayList<FastConsumerLoanOrderCommodity>();
        FastConsumerLoanOrderCommodity fastConsumerLoanOrderCommodity=new FastConsumerLoanOrderCommodity();
        fastConsumerLoanOrderCommodity.setCommodityId("100");
        fastConsumerLoanOrderCommodity.setCommodityName("nokia");
        fastConsumerLoanOrderCommodity.setCommodityNumber(1);
        fastConsumerLoanOrderCommodity.setOrderId(0);
        fastConsumerLoanOrderCommodity.setPrice(new BigDecimal(2000));
        fastConsumerLoanOrderCommodity.setSellerInternalCode("yyyy");
        fastConsumerLoanOrderCommodity.setTotalAmount(new BigDecimal(2000));
        fastConsumerLoanOrderCommodity.setUniqueId("0");
        fastConsumerLoanOrderCommodity.setUserInternalCode("xxxx");

        list.add(fastConsumerLoanOrderCommodity);

        FastConsumerLoanOrderCommodity fastConsumerLoanOrderCommodity1=new FastConsumerLoanOrderCommodity();
        fastConsumerLoanOrderCommodity1.setCommodityId("200");
        fastConsumerLoanOrderCommodity1.setCommodityName("lg");
        fastConsumerLoanOrderCommodity1.setCommodityNumber(2);
        fastConsumerLoanOrderCommodity1.setOrderId(0);
        fastConsumerLoanOrderCommodity1.setPrice(new BigDecimal(1000));
        fastConsumerLoanOrderCommodity1.setSellerInternalCode("yyyy");
        fastConsumerLoanOrderCommodity1.setTotalAmount(new BigDecimal(2000));
        fastConsumerLoanOrderCommodity1.setUniqueId("1");
        fastConsumerLoanOrderCommodity1.setUserInternalCode("xxxx");
        list.add(fastConsumerLoanOrderCommodity1);
        int result = fastConsumerLoanOrderDao.updateFastConsumerLoanOrderCommodityList(list);
        System.out.println(result);
    }

    @Test
    public void testCancelFastConsumerLoanOrderCommodity() throws Exception {

    }
}