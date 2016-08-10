DROP TABLE IF EXISTS worker_info_table;
CREATE TABLE worker_info_table(

  worker_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT '客户经理ID',
  password VARCHAR(100) NOT NULL DEFAULT '123456' COMMENT '登录密码' ,
  worker_name VARCHAR(100) NOT NULL COMMENT '姓名',
  id_type VARCHAR(2) NOT NULL COMMENT '证件类型',
  id_number VARCHAR(50) NOT NULL COMMENT '证件号码',
  org_id VARCHAR(100) NOT NULL COMMENT '所属机构',
  phone_number VARCHAR(11) NOT NULL COMMENT '电话号码',
  work_phone VARCHAR(11) NOT NULL COMMENT '工位电话',
  email VARCHAR(100) NOT NULL COMMENT '电子邮箱',
  weixin_no VARCHAR(100) NOT NULL COMMENT '微信号',
  category VARCHAR(100) NOT NULL COMMENT '类别',
  worker_position VARCHAR(100) NOT NULL COMMENT '职位',
  position_level VARCHAR(100) NOT NULL COMMENT '职位等级',
  creator VARCHAR(100) NOT NULL COMMENT '创建者',
  worker_status VARCHAR(10) NOT NULL COMMENT '员工状态',
  create_time timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  mod_time timestamp default current_timestamp on update current_timestamp COMMENT '更新时间'



)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客服员工信息表';