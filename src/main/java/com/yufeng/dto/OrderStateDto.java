package com.yufeng.dto;

import org.springframework.core.annotation.Order;

/**
 * Created by kingstones on 16/9/12.
 *
 */
public class OrderStateDto {

    private long orderId;
    private String orderState;


    public OrderStateDto() {

    }

    public long getOrderId() {

        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    @Override
    public String toString() {
        return "OrderStateDto{" +
                "orderId=" + orderId +
                ", orderState='" + orderState + '\'' +
                '}';
    }
}
