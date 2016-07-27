DROP TABLE IF EXISTS school_table;
CREATE TABLE college_table

(
    college_code VARCHAR(10) not null COMMENT '学校编号',
	  college_name VARCHAR(100) not null COMMENT '学校名称',
    city_code VARCHAR(10) not null COMMENT '所在城市编号',
	  college_classification VARCHAR(100) COMMENT '学校分类',
    create_time timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    mod_time timestamp default current_timestamp on update current_timestamp COMMENT '更新时间',
    
    PRIMARY KEY (college_code)
    
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学校表';