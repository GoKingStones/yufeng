CREATE TABLE `user_family_info_history_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `internal_code` varchar(255) NOT NULL,
  `credentialsType` varchar(2) NOT NULL COMMENT '证件类型',
  `credentialsNumber` varchar(50) NOT NULL COMMENT '证件号码',
  `name` varchar(50) NOT NULL COMMENT '姓名',
  `gender` varchar(2) DEFAULT NULL COMMENT '性别',
  `mailingAddress` varchar(200) DEFAULT NULL COMMENT '通讯地址',
  `organization` varchar(100) DEFAULT NULL COMMENT '工作单位',
  `phone` varchar(11) NOT NULL COMMENT '手机号码',
  `mailbox` varchar(100) DEFAULT NULL COMMENT '电子邮箱',
  `relation` varchar(2) NOT NULL COMMENT '与主体关系',
  `highestEducationSchool` varchar(100) DEFAULT NULL COMMENT '最高学历院校',
  `highestEducation` varchar(100) DEFAULT NULL COMMENT '最高学历',
  `foundTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '新建时间',
  `updateTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `delete_operator` varchar(50) NOT NULL COMMENT '删除操作者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;