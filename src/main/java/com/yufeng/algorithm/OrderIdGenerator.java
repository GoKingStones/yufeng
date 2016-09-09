package com.yufeng.algorithm;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by kingstones on 16/9/6.
 */
public class OrderIdGenerator {

    private static AtomicLong orderId=new AtomicLong(0);

    public static synchronized  long getIncrementOrderId() {

        return orderId.getAndIncrement();
    }


}
