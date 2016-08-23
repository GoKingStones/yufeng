DROP TABLE IF EXISTS order_ask_money_table;
CREATE TABLE order_ask_money_table(

    order_id VARCHAR(50) NOT NULL COMMENT '订单ID',
    total_amount decimal(50,2) DEFAULT NULL COMMENT '总金额',
    order_state VARCHAR(10) NOT NULL COMMENT '订单状态',
    create_time TIMESTAMP DEFAULT current_timestamp COMMENT '创建时间',
    mod_time timestamp default current_timestamp on update current_timestamp COMMENT '更新时间',
    PRIMARY KEY (order_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单请款表';
