CREATE TABLE `user_financial_account_info_table` (
  `unique_id` int(11) NOT NULL AUTO_INCREMENT,
  `internal_code` varchar(50) NOT NULL COMMENT '内码',
  `sign_id` varchar(100) DEFAULT NULL COMMENT '信息标识ID',
  `financial_consume_account_id` varchar(100) NOT NULL COMMENT '金融消费账户ID',
  `financial_consume_company` varchar(100) NOT NULL COMMENT '金融消费公司',
  `financial_consume_account_state` varchar(2) NOT NULL COMMENT '金融消费账户状态',
  `credit_scoring` int(11) DEFAULT NULL COMMENT '信用评分',
  `authorize` varchar(2) NOT NULL COMMENT '是否授权',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `mod_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `info_status` tinyint(2) DEFAULT '1' COMMENT '是否有效',
  `delete_operator` varchar(50) DEFAULT NULL COMMENT '删除操作者',
  PRIMARY KEY (`unique_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;