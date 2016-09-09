DROP  TABLE if EXISTS urge_repayment_service_table;
CREATE TABLE urge_repayment_service_table(

  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT 'ID',
  worker_id INT NOT NULL comment '客户经理ID',
  internal_code VARCHAR(100) NOT NULL COMMENT '客户内码',
  urge_time TIMESTAMP DEFAULT current_timestamp COMMENT '催收时间',
  urge_mode VARCHAR(100) NOT NULL COMMENT '催收方式',
  urge_type VARCHAR(10) NOT NULL COMMENT '催收类型',
  repayment DOUBLE NOT NULL COMMENT '应还金额',
  urge_status VARCHAR(100) NOT NULL COMMENT '催收状态',
  detail VARCHAR(200)  COMMENT '详细情况',

  create_time timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  mod_time timestamp default current_timestamp on update current_timestamp COMMENT '更新时间'

)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='催收服务表';