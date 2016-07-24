--数据库初始化脚本

--创建数据库
CREATE DATABASE yufeng;

--使用数据库

use yufeng;

--创建注册账户表

CREATE TABLE `bank_card_info_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `internal_code` varchar(50) DEFAULT NULL COMMENT '内码',
  `bankCardNumber` varchar(20) DEFAULT NULL COMMENT '银行卡号',
  `bankCardType` varchar(2) DEFAULT NULL COMMENT '银行卡类型',
  `expireTime` timestamp NULL DEFAULT NULL COMMENT '到期时间',
  `transferAccount` tinyint(2) DEFAULT NULL COMMENT '是否为转入账户',
  `bankCardState` varchar(2) DEFAULT NULL COMMENT '银行卡状态',
  `foundTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  `info_status` tinyint(2) DEFAULT '1' COMMENT '是否有效',
  `delete_operator` varchar(50) DEFAULT NULL COMMENT '操作者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;    
