package com.yufeng.dto;

import java.math.BigDecimal;

/**
 * Created by kingstones on 16/9/6.
 */
public class GetOrderInterestDto {

    private BigDecimal totalAmount;
    private int installCount;
    private String installType;

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getInstallCount() {
        return installCount;
    }

    public void setInstallCount(int installCount) {
        this.installCount = installCount;
    }

    public String getInstallType() {
        return installType;
    }

    public void setInstallType(String installType) {
        this.installType = installType;
    }

    @Override
    public String toString() {
        return "GetOrderInterestDto{" +
                "totalAmount=" + totalAmount +
                ", installCount=" + installCount +
                ", installType='" + installType + '\'' +
                '}';
    }
}
