package com.yufeng.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by kingstones on 16/9/6.
 * 分期订单每期实体
 */
public class InstallEntity {

    //订单ID
    private long orderId;

    //本期还款金额
    private BigDecimal repaymentAmount;

    //本期是第几期
    private int installNumber;

    //本期最终还款时间
    private Date repaymentDeadlineDate;
    //本期还款时间
    private Date repaymentDate;

    //本期状态，已还款，未还款
    private String state;

    //创建时间
    private Date createTime;
    //修改时间
    private Date modTime;

    public Date getRepaymentDeadlineDate() {

        return repaymentDeadlineDate;
    }

    public void setRepaymentDeadlineDate(Date repaymentDeadlineDate) {
        this.repaymentDeadlineDate = repaymentDeadlineDate;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getRepaymentAmount() {
        return repaymentAmount;
    }

    public void setRepaymentAmount(BigDecimal repaymentAmount) {
        this.repaymentAmount = repaymentAmount;
    }

    public int getInstallNumber() {
        return installNumber;
    }

    public void setInstallNumber(int installNumber) {
        this.installNumber = installNumber;
    }

    public Date getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(Date repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModTime() {
        return modTime;
    }

    public void setModTime(Date modTime) {
        this.modTime = modTime;
    }
}
