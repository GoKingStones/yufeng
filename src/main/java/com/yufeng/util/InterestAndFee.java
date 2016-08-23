package com.yufeng.util;

import java.math.BigDecimal;

/**
 * Created by kingstones on 16/8/18.
 * 利息和手续费
 */
public class InterestAndFee {

    private BigDecimal interest;

    private BigDecimal fee;

    public InterestAndFee(BigDecimal interest,BigDecimal fee) {
        this.interest=interest;
        this.fee=fee;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }
}
