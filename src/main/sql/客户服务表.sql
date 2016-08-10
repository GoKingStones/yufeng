DROP  TABLE if EXISTS custom_service_table;
CREATE TABLE custom_service_table(

  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT 'ID',
  worker_id INT NOT NULL comment '客户经理ID',
  internal_code VARCHAR(100) NOT NULL COMMENT '客户内码',
  service_time TIMESTAMP DEFAULT current_timestamp COMMENT '服务时间',
  service_mode VARCHAR(100) NOT NULL COMMENT '服务方式',
  service_type VARCHAR(100) NOT NULL COMMENT '服务类型',
  service_level VARCHAR(10) COMMENT '满意度',
  detail VARCHAR(200) COMMENT '详细信息',
  create_time timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  mod_time timestamp default current_timestamp on update current_timestamp COMMENT '更新时间'

)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户服务表';