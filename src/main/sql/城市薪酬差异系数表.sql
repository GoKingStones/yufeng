DROP TABLE IF EXISTS city_salary_Coefficient;
CREATE TABLE city_salary_Coefficient

(
    unique_id int unsigned NOT NULL auto_increment COMMENT '信息标识ID',
	city_code VARCHAR(100) not null COMMENT '城市编号',
    salary_Coefficient VARCHAR(100) not null COMMENT '薪酬差异系数',
	data_period VARCHAR(20) not null COMMENT '数据时间',
    create_time timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    mod_time timestamp default current_timestamp on update current_timestamp COMMENT '更新时间',
    
    PRIMARY KEY (unique_id),
    foreign key(city_code) references city_code_table(city_code)
    
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='城市薪酬差异系数表';