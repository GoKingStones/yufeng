DROP TABLE IF EXISTS city_code_table;
CREATE TABLE city_code_table

(
    city_code VARCHAR(10) not null COMMENT '城市编号',
	province_name VARCHAR(100) not null COMMENT '省直辖市名称',
    city_name VARCHAR(100) not null COMMENT '市名称',
	district_name VARCHAR(100) COMMENT '区县名称',
    full_name VARCHAR(100) COMMENT '全称',
    create_time timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    mod_time timestamp default current_timestamp on update current_timestamp COMMENT '更新时间',
    
    PRIMARY KEY (city_code)
    
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='城市表';



