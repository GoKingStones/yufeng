DROP TABLE if EXISTS boc_loan_order_table;

CREATE TABLE boc_loan_order_table
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    user_internal_code VARCHAR(100)  COMMENT '购买用户内码',
    loan_acct_no VARCHAR(13) COMMENT '中银消费金融账号	',
    merchant_code VARCHAR(15) COMMENT '清算商户代号',
    amount DECIMAL(8,2) COMMENT '消费金额	',
    merchant_order_id VARCHAR(32)	COMMENT '消费交易訂单号',
    pay_gate_order_id VARCHAR(32) COMMENT '中银消費(動用)交易订单号码',
    pay_type VARCHAR(1) COMMENT '消费支付类型',
    charge_type VARCHAR(1)	COMMENT '账户充值类型',
    currency VARCHAR(3) COMMENT '币种	',
    use_temp_cre_line VARCHAR(1) COMMENT '是否同意加额',
    pay_description VARCHAR(100) COMMENT '订单备注说明',
    instal_period INT(3) COMMENT '分期期数	',
    instal_type VARCHAR(1)	COMMENT '分期方案	',
    instal_fee_type VARCHAR(1) COMMENT '分期手续费方案',
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    mod_time TIMESTAMP DEFAULT current_timestamp ON UPDATE  CURRENT_TIMESTAMP COMMENT '更新时间'

)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='中银消费订单表';



