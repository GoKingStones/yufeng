package com.yufeng.dto;

import java.util.List;

/**
 * Created by kingstones on 16/9/9.
 * 退还部分货品
 */
public class ReturnCommodityDto {
    private long orderId;
    private List<String> commodityIdList;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public List<String> getCommodityIdList() {
        return commodityIdList;
    }

    public void setCommodityIdList(List<String> commodityIdList) {
        this.commodityIdList = commodityIdList;
    }
}
