CREATE TABLE `bank_card_info_table` (
  `unique_id` int(11) NOT NULL AUTO_INCREMENT,
  `internal_code` varchar(100) NOT NULL COMMENT '内码',
  `bankcard_number` varchar(20) NOT NULL COMMENT '银行卡号',
  `bankcard_type` varchar(2) NOT NULL COMMENT '银行卡类型',
  `expire_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '到期时间',
  `transfer_account` tinyint(2) NOT NULL COMMENT '是否为转入账户',
  `bankcard_state` varchar(2) NOT NULL COMMENT '银行卡状态',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `mod_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `info_status` tinyint(2) DEFAULT '1' COMMENT '是否有效',
  `delete_operator` varchar(50) DEFAULT NULL COMMENT '操作者',
  PRIMARY KEY (`unique_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;