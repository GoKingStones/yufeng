DROP TABLE if EXISTS boc_pay_order_table;

CREATE TABLE boc_pay_order_table
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    user_internal_code VARCHAR(100) COMMENT '购买用户内码',
    acct_no VARCHAR(13)	COMMENT '中银消费金融账号',
    merchant_code VARCHAR(15) COMMENT '清算機構)商户代号',
    amount DECIMAL(8,2) COMMENT '还款金額',
    return_date DATETIME COMMENT '还款日期',
    ori_merchant_order_id VARCHAR(32) COMMENT '原消费交易订单号码',
    ori_pay_time DATETIME COMMENT '原消費交易时间',
    merchant_order_id VARCHAR(32) COMMENT '还款交易订单号码',
    pay_gate_order_id VARCHAR(32) COMMENT '中银还款交易订单号码',
    return_type VARCHAR(1) COMMENT '还款类型',
    pay_type VARCHAR(1) COMMENT '还款类别',
    debit_card_no VARCHAR(20) COMMENT '借记卡卡号',
    decard_open_bank VARCHAR(50) COMMENT '借记卡开户銀行名称',
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    mod_time TIMESTAMP DEFAULT current_timestamp ON UPDATE  CURRENT_TIMESTAMP COMMENT '更新时间'

)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='中银消费还款表';



