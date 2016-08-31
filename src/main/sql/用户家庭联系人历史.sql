CREATE TABLE `user_family_info_history_table` (
  `unique_id` int(11) NOT NULL AUTO_INCREMENT,
  `internal_code` varchar(255) NOT NULL,
  `credentials_type` varchar(2) NOT NULL COMMENT '证件类型',
  `credentials_number` varchar(50) NOT NULL COMMENT '证件号码',
  `name` varchar(50) NOT NULL COMMENT '姓名',
  `gender` varchar(2) DEFAULT NULL COMMENT '性别',
  `mailing_address` varchar(200) DEFAULT NULL COMMENT '通讯地址',
  `organization` varchar(100) DEFAULT NULL COMMENT '工作单位',
  `cell_no` varchar(11) NOT NULL COMMENT '手机号码',
  `email` varchar(100) DEFAULT NULL COMMENT '电子邮箱',
  `relation` varchar(2) NOT NULL COMMENT '与主体关系',
  `highest_education_school` varchar(100) DEFAULT NULL COMMENT '最高学历院校',
  `highest_education` varchar(100) DEFAULT NULL COMMENT '最高学历',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '新建时间',
  `delete_operator` varchar(50) NOT NULL COMMENT '删除操作者',
  PRIMARY KEY (`unique_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;