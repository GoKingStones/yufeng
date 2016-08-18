DROP TABLE IF EXISTS reward_punishment_info;
CREATE TABLE reward_punishment_info

(
	unique_id int unsigned NOT NULL auto_increment COMMENT '信息标识ID',
    internal_code VARCHAR(100) NOT NULL COMMENT '内码',
    certificate_no VARCHAR(100) COMMENT '奖惩证书编号',
    info_type VARCHAR(2) NOT NULL COMMENT '奖惩类型',
    describe_info Text NOT NULL COMMENT '描述',
    occurrence_date timestamp NOT NULL COMMENT '发生时间',
    occurrence_location VARCHAR(100) COMMENT '获得地点',
    data_source VARCHAR(20) NOT NULL COMMENT '数据来源',
	certificate_img_url VARCHAR(1024) COMMENT '证明照片地址',
    verify VARCHAR(2) NOT NULL COMMENT '是否验证',
    info_status VARCHAR(2) NOT NULL COMMENT '信息状态',
    create_time timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    mod_time timestamp default current_timestamp on update current_timestamp COMMENT '更新时间',
    who_did VARCHAR(100) NOT NULL COMMENT '操作者',
    
    PRIMARY KEY (unique_id),
    foreign key(internal_code) references interal_code_table(interal_code)
    
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='奖惩信息表';

