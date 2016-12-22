DROP TABLE if EXISTS boc_loan_account_table;

CREATE TABLE boc_loan_account_table
(

    user_internal_code  VARCHAR(100) PRIMARY KEY COMMENT '御峰金融账户内码',
    loan_acct_no VARCHAR(13) COMMENT '中银消费金融账户',
    mobile_no VARCHAR(11)	COMMENT '客戶手机号',
    acct_stus VARCHAR(2) COMMENT '账户状态	X(2)',
    creLine_stus VARCHAR(2)	COMMENT '额度状态',
    acct_balance DECIMAL(8,2)	COMMENT '贷款余额',
    return_balance	DECIMAL(8,2) COMMENT '退货溢出款',
    base_tot_creLine DECIMAL(8,2)	COMMENT '基础额度总额',
    base_used_creLine	DECIMAL(8,2) COMMENT '基础额度已动用额度',
    base_rest_creLine	DECIMAL(8,2) COMMENT '基础额度剩余可使用额度',
    temp_tot_creLine	DECIMAL(8,2) COMMENT '临时额度',
    temp_used_creLine DECIMAL(8,2) 	COMMENT '临时额度已动用额度	',
    temp_rest_creLine DECIMAL(8,2)	COMMENT '临时额度剩余可使用额度',
    day_pay_total_amt	DECIMAL(8,2) COMMENT '当日累计消费总金额	',
    day_return_total_amt	DECIMAL(8,2) COMMENT '当日累计还款总金额',
    txn_print DECIMAL(8,2)	COMMENT '償還的本金',
    txn_fee DECIMAL(8,2)	COMMENT '償還的费用',
    txn_ovd_fee DECIMAL(8,2)	COMMENT '償還的滞纳费',
    txn_int DECIMAL(8,2)	COMMENT '償還的利息',
    temp_frozen_amt DECIMAL(8,2)	COMMENT '临时冻结额度',
    creLine_expDate DECIMAL(8,2)	COMMENT '基础额度有效期限',
    total_loan_amt DECIMAL(8,2) 	COMMENT '實際欠款合计	',
    int_tot DECIMAL(8,2)	COMMENT '利息合计',
    expense_tot DECIMAL(8,2)	COMMENT '費用合計',
    ovd_fee_tot DECIMAL(8,2) 	COMMENT '滞纳费合计',
    ovd_fee_abl DECIMAL(8,2)	COMMENT '可免除之滞纳费',
    return_amt DECIMAL(8,2)	COMMENT '本期应还款额',
    next_pay_date DATETIME	COMMENT '最后还款日',
    overdue_status	VARCHAR(1) COMMENT '逾期状态',
    ovd_day_cnt INT(3)	COMMENT '逾期天数',
    min_return_amount	DECIMAL(8,2) COMMENT '解除逾期状态所需偿还金额	',
    debit_card_no	VARCHAR(20) COMMENT '借记卡卡号',
    open_bank_id	VARCHAR(4) COMMENT '借记卡开户銀行代號',
    decard_open_bank VARCHAR(50) COMMENT '借记卡开户銀行名称',
    prov VARCHAR(20)	COMMENT '借记卡开户行省份',
    city VARCHAR(40)	COMMENT '借记卡开户行城市',
    decard_card_issuer	VARCHAR(10) COMMENT '借记卡发卡行编号',
    decard_card_issuer_name VARCHAR(100) COMMENT '借记卡发卡行名称',
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    mod_time TIMESTAMP DEFAULT current_timestamp ON UPDATE  CURRENT_TIMESTAMP COMMENT '更新时间'

)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='中银消费账户表';



