CREATE TABLE `fast_consumer_loan_order_table` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `order_id` varchar(50) NOT NULL COMMENT '订单id',
  `order_type` varchar(10) NOT NULL COMMENT '订单类型',
  `user_internal_code` varchar(50) NOT NULL COMMENT '购买用户内码',
  `order_state` varchar(10) NOT NULL COMMENT '订单状态',
  `invoice_number` varchar(50) DEFAULT NULL COMMENT '发票号码',
  `total_amount` decimal(50,2) NOT NULL COMMENT '总金额',
  `discount_price` decimal(50,2) DEFAULT NULL COMMENT '折扣价',
  `order_discount_price` decimal(50,2) DEFAULT NULL COMMENT '订单折扣价',
  `found_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;