-- ----------------------------
-- Table structure for guarantee_relationship_info_table
-- ----------------------------
DROP TABLE IF EXISTS `guarantee_relationship_info_table`;
CREATE TABLE `guarantee_relationship_info_table` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `internal_code` varchar(100) NOT NULL COMMENT '用户内码(被担保人)',
  `relate_user_internal_code` varchar(100) NOT NULL COMMENT '形成关系用户内码(担保人)',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '关系状态',
  `assure_money` decimal(10,2) DEFAULT NULL COMMENT '担保金额',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `mod_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
