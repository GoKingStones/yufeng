package com.yufeng.dto;

import com.yufeng.entity.FastConsumerLoanOrder;
import com.yufeng.entity.FastConsumerLoanOrderCommodity;

import java.util.List;

/**
 * Created by kingstones on 16/8/16.
 * 商场分期订单支付请求参数
 */
public class FastConsumerLoanOrderDto {
    /**
     * 订单号
     */
    private FastConsumerLoanOrder fastConsumerLoanOrder;
    /**
     * 订单系列商品
     */
    private List<FastConsumerLoanOrderCommodity> fastConsumerLoanOrderCommodities;

    public FastConsumerLoanOrder getFastConsumerLoanOrder() {
        return fastConsumerLoanOrder;
    }

    public void setFastConsumerLoanOrder(FastConsumerLoanOrder fastConsumerLoanOrder) {
        this.fastConsumerLoanOrder = fastConsumerLoanOrder;
    }

    public List<FastConsumerLoanOrderCommodity> getFastConsumerLoanOrderCommodities() {
        return fastConsumerLoanOrderCommodities;
    }

    public void setFastConsumerLoanOrderCommodities(List<FastConsumerLoanOrderCommodity> fastConsumerLoanOrderCommodities) {
        this.fastConsumerLoanOrderCommodities = fastConsumerLoanOrderCommodities;
    }

    @Override
    public String toString() {
        return "FastConsumerLoanOrderDto{" +
                "fastConsumerLoanOrder=" + fastConsumerLoanOrder +
                ", fastConsumerLoanOrderCommodities=" + fastConsumerLoanOrderCommodities +
                '}';
    }
}
