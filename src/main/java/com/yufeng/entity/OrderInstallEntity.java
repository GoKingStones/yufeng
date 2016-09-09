package com.yufeng.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by kingstones on 16/9/6.
 * 用户所有订单分期情况
 */
public class OrderInstallEntity {


    //用户内码
    private String internalCode;
    //订单号
    private long orderId;
    //总分期数
    private int totalInstallCount;
    //总分期金额
    private BigDecimal totalInstallAmount;
    //已还款数
    private int alreadyRepaymentCount;
    //剩余还款数
    private int leftRepaymentCount;
    //已还款金额
    private BigDecimal alreadyRepaymentAmount;
    //剩余还款金额
    private BigDecimal leftRepaymentAmount;

    //订单分期状态：已还清，未还清
    private String orderInstallState;

    //还款日期
    private Date repaymentDate;

    //最后还款期限
    private Date repaymentDeadlineDate;

    //创建时间
    private Date createTime;
    //修改时间
    private Date modTime;


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

    public Date getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(Date repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public Date getRepaymentDeadlineDate() {
        return repaymentDeadlineDate;
    }

    public void setRepaymentDeadlineDate(Date repaymentDeadlineDate) {
        this.repaymentDeadlineDate = repaymentDeadlineDate;
    }

    public String getOrderInstallState() {
        return orderInstallState;
    }

    public void setOrderInstallState(String orderInstallState) {
        this.orderInstallState = orderInstallState;
    }

    public String getInternalCode() {
        return internalCode;
    }

    public void setInternalCode(String internalCode) {
        this.internalCode = internalCode;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public int getTotalInstallCount() {
        return totalInstallCount;
    }

    public void setTotalInstallCount(int totalInstallCount) {
        this.totalInstallCount = totalInstallCount;
    }

    public BigDecimal getTotalInstallAmount() {
        return totalInstallAmount;
    }

    public void setTotalInstallAmount(BigDecimal totalInstallAmount) {
        this.totalInstallAmount = totalInstallAmount;
    }

    public int getAlreadyRepaymentCount() {
        return alreadyRepaymentCount;
    }

    public void setAlreadyRepaymentCount(int alreadyRepaymentCount) {
        this.alreadyRepaymentCount = alreadyRepaymentCount;
    }

    public int getLeftRepaymentCount() {
        return leftRepaymentCount;
    }

    public void setLeftRepaymentCount(int leftRepaymentCount) {
        this.leftRepaymentCount = leftRepaymentCount;
    }

    public BigDecimal getAlreadyRepaymentAmount() {
        return alreadyRepaymentAmount;
    }

    public void setAlreadyRepaymentAmount(BigDecimal alreadyRepaymentAmount) {
        this.alreadyRepaymentAmount = alreadyRepaymentAmount;
    }

    public BigDecimal getLeftRepaymentAmount() {
        return leftRepaymentAmount;
    }

    public void setLeftRepaymentAmount(BigDecimal leftRepaymentAmount) {
        this.leftRepaymentAmount = leftRepaymentAmount;
    }
}
