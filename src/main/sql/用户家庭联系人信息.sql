--数据库初始化脚本

--创建数据库
CREATE DATABASE yufeng;

--使用数据库

use yufeng;

--创建注册账户表
CREATE TABLE `user_family_info_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `internal_code` varchar(255) DEFAULT NULL,
  `credentialsType` varchar(2) DEFAULT NULL COMMENT '证件类型',
  `credentialsNumber` varchar(50) DEFAULT NULL COMMENT '证件号码',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `gender` varchar(2) DEFAULT NULL COMMENT '性别',
  `mailingAddress` varchar(200) DEFAULT NULL COMMENT '通讯地址',
  `organization` varchar(100) DEFAULT NULL COMMENT '工作单位',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `mailbox` varchar(100) DEFAULT NULL COMMENT '电子邮箱',
  `relation` varchar(2) DEFAULT NULL COMMENT '与主体关系',
  `highestEducationSchool` varchar(100) DEFAULT NULL COMMENT '最高学历院校',
  `highestEducation` varchar(100) DEFAULT NULL COMMENT '最高学历',
  `foundTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updateTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
