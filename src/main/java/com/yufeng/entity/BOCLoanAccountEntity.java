package com.yufeng.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by kingstones on 16/12/21.
 * 中银消费账户实体
 */
public class BOCLoanAccountEntity {

    private String userInternalCode; //'购买用户内码',
    private String loanAcctNo;	//中银消费金融账号
    private String mobileNo	; //客戶手机号
    /*
    *"  10：正常贷放中
        22：逾期(关注)
        23：逾期(次级)
        24：逾期(可疑)
        25：逾期(损失)
        81：呆账-人工核销
        89：呆账-已完全收回
        90：已结清"
     */
    private String acctStus	;	//账户状态
    /*
    *10：正常
    21：暂时停用(客户申请)
    22：冻结(逾期，系统自动设定)
    23：冻结(内部人员人工设定)
    24：冻结(中途审核，系统自动设定)
    81：已过激活期限，已失效
    82：已过使用期限，已失效
    90：已注销
     */
    private String creLineStus;	//额度状态
    private BigDecimal acctBalance;	//	贷款余额
    private BigDecimal returnBalance;	//	退货溢出款
    private BigDecimal	baseTotCreLine; // 基础额度总额
    private BigDecimal	baseUsedCreLine; //基础额度已动用额度
    private BigDecimal	baseRestCreLine; //基础额度剩余可使用额度
    private BigDecimal	tempTotCreLine; //临时额度
    private BigDecimal	tempUsedCreLine; //临时额度已动用额度
    private BigDecimal	tempRestCreLine; // 临时额度剩余可使用额度
    private BigDecimal dayPayTotalAmt; //	当日累计消费总金额
    private BigDecimal dayReturnTotalAmt; //	当日累计还款总金额
    private BigDecimal txnPrint; //	償還的本金
    private BigDecimal txnFee; //	償還的费用
    private BigDecimal txnOvdFee; //	償還的滞纳费
    private BigDecimal txnInt; //	償還的利息
    private BigDecimal tempFrozenAmt; //	临时冻结额度
    private Date creLineExpDate; //	基础额度有效期限
    private BigDecimal totalLoanAmt; //	實際欠款合计
    private BigDecimal intTot; //	利息合计
    private BigDecimal expenseTot; //	費用合計
    private BigDecimal ovdFeeTot; //	滞纳费合计
    private BigDecimal ovdFeeAbl; //	可免除之滞纳费
    private BigDecimal returnAmt; //	本期应还款额
    private Date nextPayDate; //	最后还款日
    /*
    *1：逾期
     2：正常
     */
    private String overdueStatus; //	逾期状态
    private int ovdDayCnt; //	逾期天数
    private BigDecimal minReturnAmount; //	解除逾期状态所需偿还金额
    private String debitCardNo; //	借记卡卡号
    private String openBankId; //	借记卡开户銀行代號
    private String decardOpenBank; //	借记卡开户銀行名称
    private String prov	; //借记卡开户行省份
    private String city; //	借记卡开户行城市
    private String decardCardIssuer; //	借记卡发卡行编号
    private String decardCardIssuerName; //	借记卡发卡行名称
    private Date createTime;//创建时间
    private Date modTime;//修改时间

    public String getUserInternalCode() {
        return userInternalCode;
    }

    public void setUserInternalCode(String userInternalCode) {
        this.userInternalCode = userInternalCode;
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

    public String getLoanAcctNo() {
        return loanAcctNo;
    }

    public void setLoanAcctNo(String loanAcctNo) {
        this.loanAcctNo = loanAcctNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAcctStus() {
        return acctStus;
    }

    public void setAcctStus(String acctStus) {
        this.acctStus = acctStus;
    }

    public String getCreLineStus() {
        return creLineStus;
    }

    public void setCreLineStus(String creLineStus) {
        this.creLineStus = creLineStus;
    }

    public BigDecimal getAcctBalance() {
        return acctBalance;
    }

    public void setAcctBalance(BigDecimal acctBalance) {
        this.acctBalance = acctBalance;
    }

    public BigDecimal getReturnBalance() {
        return returnBalance;
    }

    public void setReturnBalance(BigDecimal returnBalance) {
        this.returnBalance = returnBalance;
    }

    public BigDecimal getBaseTotCreLine() {
        return baseTotCreLine;
    }

    public void setBaseTotCreLine(BigDecimal baseTotCreLine) {
        this.baseTotCreLine = baseTotCreLine;
    }

    public BigDecimal getBaseUsedCreLine() {
        return baseUsedCreLine;
    }

    public void setBaseUsedCreLine(BigDecimal baseUsedCreLine) {
        this.baseUsedCreLine = baseUsedCreLine;
    }

    public BigDecimal getBaseRestCreLine() {
        return baseRestCreLine;
    }

    public void setBaseRestCreLine(BigDecimal baseRestCreLine) {
        this.baseRestCreLine = baseRestCreLine;
    }

    public BigDecimal getTempTotCreLine() {
        return tempTotCreLine;
    }

    public void setTempTotCreLine(BigDecimal tempTotCreLine) {
        this.tempTotCreLine = tempTotCreLine;
    }

    public BigDecimal getTempUsedCreLine() {
        return tempUsedCreLine;
    }

    public void setTempUsedCreLine(BigDecimal tempUsedCreLine) {
        this.tempUsedCreLine = tempUsedCreLine;
    }

    public BigDecimal getTempRestCreLine() {
        return tempRestCreLine;
    }

    public void setTempRestCreLine(BigDecimal tempRestCreLine) {
        this.tempRestCreLine = tempRestCreLine;
    }

    public BigDecimal getDayPayTotalAmt() {
        return dayPayTotalAmt;
    }

    public void setDayPayTotalAmt(BigDecimal dayPayTotalAmt) {
        this.dayPayTotalAmt = dayPayTotalAmt;
    }

    public BigDecimal getDayReturnTotalAmt() {
        return dayReturnTotalAmt;
    }

    public void setDayReturnTotalAmt(BigDecimal dayReturnTotalAmt) {
        this.dayReturnTotalAmt = dayReturnTotalAmt;
    }

    public BigDecimal getTxnPrint() {
        return txnPrint;
    }

    public void setTxnPrint(BigDecimal txnPrint) {
        this.txnPrint = txnPrint;
    }

    public BigDecimal getTxnFee() {
        return txnFee;
    }

    public void setTxnFee(BigDecimal txnFee) {
        this.txnFee = txnFee;
    }

    public BigDecimal getTxnOvdFee() {
        return txnOvdFee;
    }

    public void setTxnOvdFee(BigDecimal txnOvdFee) {
        this.txnOvdFee = txnOvdFee;
    }

    public BigDecimal getTxnInt() {
        return txnInt;
    }

    public void setTxnInt(BigDecimal txnInt) {
        this.txnInt = txnInt;
    }

    public BigDecimal getTempFrozenAmt() {
        return tempFrozenAmt;
    }

    public void setTempFrozenAmt(BigDecimal tempFrozenAmt) {
        this.tempFrozenAmt = tempFrozenAmt;
    }

    public Date getCreLineExpDate() {
        return creLineExpDate;
    }

    public void setCreLineExpDate(Date creLineExpDate) {
        this.creLineExpDate = creLineExpDate;
    }

    public BigDecimal getTotalLoanAmt() {
        return totalLoanAmt;
    }

    public void setTotalLoanAmt(BigDecimal totalLoanAmt) {
        this.totalLoanAmt = totalLoanAmt;
    }

    public BigDecimal getIntTot() {
        return intTot;
    }

    public void setIntTot(BigDecimal intTot) {
        this.intTot = intTot;
    }

    public BigDecimal getExpenseTot() {
        return expenseTot;
    }

    public void setExpenseTot(BigDecimal expenseTot) {
        this.expenseTot = expenseTot;
    }

    public BigDecimal getOvdFeeTot() {
        return ovdFeeTot;
    }

    public void setOvdFeeTot(BigDecimal ovdFeeTot) {
        this.ovdFeeTot = ovdFeeTot;
    }

    public BigDecimal getOvdFeeAbl() {
        return ovdFeeAbl;
    }

    public void setOvdFeeAbl(BigDecimal ovdFeeAbl) {
        this.ovdFeeAbl = ovdFeeAbl;
    }

    public BigDecimal getReturnAmt() {
        return returnAmt;
    }

    public void setReturnAmt(BigDecimal returnAmt) {
        this.returnAmt = returnAmt;
    }

    public Date getNextPayDate() {
        return nextPayDate;
    }

    public void setNextPayDate(Date nextPayDate) {
        this.nextPayDate = nextPayDate;
    }

    public String getOverdueStatus() {
        return overdueStatus;
    }

    public void setOverdueStatus(String overdueStatus) {
        this.overdueStatus = overdueStatus;
    }

    public int getOvdDayCnt() {
        return ovdDayCnt;
    }

    public void setOvdDayCnt(int ovdDayCnt) {
        this.ovdDayCnt = ovdDayCnt;
    }

    public BigDecimal getMinReturnAmount() {
        return minReturnAmount;
    }

    public void setMinReturnAmount(BigDecimal minReturnAmount) {
        this.minReturnAmount = minReturnAmount;
    }

    public String getDebitCardNo() {
        return debitCardNo;
    }

    public void setDebitCardNo(String debitCardNo) {
        this.debitCardNo = debitCardNo;
    }

    public String getOpenBankId() {
        return openBankId;
    }

    public void setOpenBankId(String openBankId) {
        this.openBankId = openBankId;
    }

    public String getDecardOpenBank() {
        return decardOpenBank;
    }

    public void setDecardOpenBank(String decardOpenBank) {
        this.decardOpenBank = decardOpenBank;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDecardCardIssuer() {
        return decardCardIssuer;
    }

    public void setDecardCardIssuer(String decardCardIssuer) {
        this.decardCardIssuer = decardCardIssuer;
    }

    public String getDecardCardIssuerName() {
        return decardCardIssuerName;
    }

    public void setDecardCardIssuerName(String decardCardIssuerName) {
        this.decardCardIssuerName = decardCardIssuerName;
    }

    @Override
    public String toString() {
        return "BOCLoanAccountEntity{" +
                "loanAcctNo='" + loanAcctNo + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", acctStus='" + acctStus + '\'' +
                ", creLineStus='" + creLineStus + '\'' +
                ", acctBalance=" + acctBalance +
                ", returnBalance=" + returnBalance +
                ", baseTotCreLine=" + baseTotCreLine +
                ", baseUsedCreLine=" + baseUsedCreLine +
                ", baseRestCreLine=" + baseRestCreLine +
                ", tempTotCreLine=" + tempTotCreLine +
                ", tempUsedCreLine=" + tempUsedCreLine +
                ", tempRestCreLine=" + tempRestCreLine +
                ", dayPayTotalAmt=" + dayPayTotalAmt +
                ", dayReturnTotalAmt=" + dayReturnTotalAmt +
                ", txnPrint=" + txnPrint +
                ", txnFee=" + txnFee +
                ", txnOvdFee=" + txnOvdFee +
                ", txnInt=" + txnInt +
                ", tempFrozenAmt=" + tempFrozenAmt +
                ", creLineExpDate=" + creLineExpDate +
                ", totalLoanAmt=" + totalLoanAmt +
                ", intTot=" + intTot +
                ", expenseTot=" + expenseTot +
                ", ovdFeeTot=" + ovdFeeTot +
                ", ovdFeeAbl=" + ovdFeeAbl +
                ", returnAmt=" + returnAmt +
                ", nextPayDate=" + nextPayDate +
                ", overdueStatus='" + overdueStatus + '\'' +
                ", ovdDayCnt=" + ovdDayCnt +
                ", minReturnAmount=" + minReturnAmount +
                ", debitCardNo='" + debitCardNo + '\'' +
                ", openBankId='" + openBankId + '\'' +
                ", decardOpenBank='" + decardOpenBank + '\'' +
                ", prov='" + prov + '\'' +
                ", city='" + city + '\'' +
                ", decardCardIssuer='" + decardCardIssuer + '\'' +
                ", decardCardIssuerName='" + decardCardIssuerName + '\'' +
                '}';
    }
}
