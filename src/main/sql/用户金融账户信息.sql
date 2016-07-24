--数据库初始化脚本

--创建数据库
CREATE DATABASE yufeng;

--使用数据库

use yufeng;

--创建注册账户表
CREATE TABLE `user_financial_account_info_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `internal_code` varchar(50) DEFAULT NULL COMMENT '内码',
  `signId` varchar(100) DEFAULT NULL COMMENT '信息标识ID',
  `financialConsumeAccountId` varchar(100) DEFAULT NULL COMMENT '金融消费账户ID',
  `financialConsumeCompany` varchar(100) DEFAULT NULL COMMENT '金融消费公司',
  `financialConsumeAccountState` varchar(2) DEFAULT NULL COMMENT '金融消费账户状态',
  `creditScoring` int(11) DEFAULT NULL COMMENT '信用评分',
  `authorize` varchar(2) DEFAULT NULL COMMENT '是否授权',
  `foundTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `info_status` tinyint(2) DEFAULT '1' COMMENT '是否有效',
  `delete_operator` varchar(50) DEFAULT NULL COMMENT '删除操作者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;