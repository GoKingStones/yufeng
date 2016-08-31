CREATE TABLE `guarantee_relationship_info_his_table` (
  `unique_id` varchar(50) NOT NULL COMMENT 'id',
  `internal_code` varchar(50) NOT NULL COMMENT '用户内码(被担保人)',
  `relate_user_internal_code` varchar(50) NOT NULL COMMENT '形成关系用户内码(担保人)',
  `status` tinyint(1) DEFAULT NULL COMMENT '关系状态',
  `assure_money` decimal(10,2) NOT NULL COMMENT '担保金额',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`unique_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
