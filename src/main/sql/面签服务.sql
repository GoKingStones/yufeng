DROP  TABLE if EXISTS interview_service_table;
CREATE TABLE interview_service_table(

  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT 'ID',
  worker_id INT NOT NULL comment '客户经理ID',
  internal_code VARCHAR(100) NOT NULL COMMENT '客户内码',
  interview_time TIMESTAMP DEFAULT current_timestamp COMMENT '面签时间',
  interview_place VARCHAR(100) NOT NULL COMMENT '面签地点',
  interview_result VARCHAR(10) NOT NULL COMMENT '面签结果',
  phone_url VARCHAR(100) NOT NULL COMMENT '合影照片地址	',
  detail VARCHAR(200) COMMENT '详细情况',
  create_time timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  mod_time timestamp default current_timestamp on update current_timestamp COMMENT '更新时间'

)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='面签服务表';