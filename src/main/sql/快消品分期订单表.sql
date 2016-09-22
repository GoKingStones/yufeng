DROP TABLE if EXISTS fast_consumer_loan_order_table;
CREATE TABLE `fast_consumer_loan_order_table` (
  `order_id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT NOT NULL COMMENT '订单id',
  `user_internal_code` varchar(50) NOT NULL COMMENT '购买用户内码',
  `order_state` varchar(10) NOT NULL COMMENT '订单状态',
  `total_amount` decimal(50,2) NOT NULL COMMENT '总金额',
  discount_amount DECIMAL(50,2) NOT NULL COMMENT '折扣金额',
  actual_total_amount DECIMAL(50,2) NOT NULL COMMENT '实付总金额',
  install_count int NOT NULL COMMENT '分期数',
  install_type VARCHAR(10) NOT NULL COMMENT '分期类型',
  interest DECIMAL(50,2) NOT NULL COMMENT '利息',
  freight DECIMAL(50,2) NOT NULL COMMENT '运费',
  submit_time DATETIME COMMENT '订单生成时间',
  cancel_time DATETIME COMMENT '订单取消时间',
  send_time DATETIME COMMENT '发货时间',
  receipt_time DATETIME COMMENT '收货时间',
  return_order_time DATETIME COMMENT '全部退货时间',
  return_commodity_time DATETIME COMMENT '部分退货时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `mod_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='快消品分期订单表';