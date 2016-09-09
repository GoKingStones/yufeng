package com.yufeng.util;

import com.yufeng.dto.GetOrderInterestDto;
import com.yufeng.entity.FastConsumerLoanOrderCommodity;

import java.math.BigDecimal;

/**
 * Created by kingstones on 16/8/18.
 * 通过商品类型和商品的金额，商品的期数来获得分期利息和分期手续费
 */
public class OrderInterestUtil {


    public static InterestAndFee get(int installCount,FastConsumerLoanOrderCommodity fastConsumerLoanOrderCommodity) {

        return null;

    }

    public static BigDecimal getInterest(GetOrderInterestDto getOrderInterestDto) {
        return new BigDecimal(0);
    }
}
