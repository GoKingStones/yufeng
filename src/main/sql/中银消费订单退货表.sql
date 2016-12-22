DROP TABLE if EXISTS boc_return_order_table;

CREATE TABLE boc_return_order_table
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,

    user_internal_code VARCHAR(100) COMMENT '购买用户内码',
    acct_no VARCHAR(13)	COMMENT '中银消费金融账号',
    merchant_code VARCHAR(15) COMMENT '清算機構)商户代号',
    return_amt DECIMAL(8,2) COMMENT '退货金額',
    ori_merchant_order_id VARCHAR(32) COMMENT '原消费交易订单号码',
    ori_pay_time DATETIME COMMENT '原消費交易时间',
    merchant_order_id VARCHAR(32) COMMENT '退货订单号码',
    pay_gate_order_id VARCHAR(32) COMMENT '中银退货订单号码',
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    mod_time TIMESTAMP DEFAULT current_timestamp ON UPDATE  CURRENT_TIMESTAMP COMMENT '更新时间'

)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='中银消费订单退货表';



