DROP TABLE  IF EXISTS fast_consumer_loan_order_commodity_table;

CREATE TABLE `fast_consumer_loan_order_commodity_table` (
  `unique_id` varchar(50) NOT NULL COMMENT 'id',
  `commodity_id` varchar(50) NOT NULL COMMENT '商品id',
  `commodity_name` varchar(50) NOT NULL,
  `order_id` varchar(50) NOT NULL COMMENT '订单id',
  `price` decimal(50,2) NOT NULL COMMENT '价格',
  `commodity_number` int(10) NOT NULL COMMENT '数量',
  `user_internal_code` varchar(50) NOT NULL COMMENT '用户内码',
  `seller_internal_code` varchar(50) NOT NULL COMMENT '商户内码',
  `total_amount` decimal(50,2) NOT NULL COMMENT '总金额',
   commodity_state VARCHAR(10) NOT NULL COMMENT '商品状态',
  `create_time` TIMESTAMP DEFAULT current_timestamp COMMENT '创建时间',
  `mod_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`unique_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;