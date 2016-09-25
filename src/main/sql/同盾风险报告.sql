CREATE TABLE `tongdun_risk_report_table` (
  `unique_id` varchar(50) NOT NULL COMMENT 'id',
  `internal_code` varchar(100) DEFAULT NULL COMMENT '用户内码',
  `success` tinyint(1) DEFAULT NULL COMMENT '接口调用是否成功',
  `risk_items` longtext COMMENT '扫描出来的风险项',
  `report_id` varchar(50) DEFAULT NULL COMMENT '报告编号',
  `apply_time` datetime DEFAULT NULL COMMENT '扫描时间',
  `final_decision` varchar(50) DEFAULT NULL COMMENT '风险结果',
  `application_id` varchar(50) DEFAULT NULL COMMENT '申请编号',
  `final_score` int(11) DEFAULT NULL COMMENT '风险分数',
  `report_time` datetime DEFAULT NULL COMMENT '报告时间',
  `address_detect` varchar(255) DEFAULT NULL COMMENT '归属地解析',
  `result_path` varchar(100) DEFAULT NULL COMMENT '详细结果路径',
  PRIMARY KEY (`unique_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;