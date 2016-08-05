DROP TABLE IF EXISTS user_basic_info;
CREATE TABLE user_basic_info

(
    internal_code VARCHAR(20) NOT NULL COMMENT '内码',
    name VARCHAR(50) NOT NULL COMMENT '姓名',
    id_type VARCHAR(2) NOT NULL COMMENT '证件类型',
    id_no VARCHAR(50) NOT NULL COMMENT '证件号码',
    cell_no VARCHAR(11) NOT NULL COMMENT '手机号码',
    email VARCHAR(100) COMMENT '电子邮箱',
    family_address VARCHAR(200) COMMENT '家庭住址',
	marital_status VARCHAR(2) COMMENT '婚姻状态',
    postal_address VARCHAR(200) COMMENT '通讯地址',
    idcard_front_img_url VARCHAR(1024) NOT NULL COMMENT '身份证正面照片地址',
    idcard_back_img_url VARCHAR(1024) NOT NULL COMMENT '身份证背面照片地址',
	weixin_no VARCHAR(100) COMMENT '微信号',
    qq_no VARCHAR(100)  COMMENT 'QQ号',
    weibo_bo VARCHAR(100)  COMMENT '微博号',
    address VARCHAR(200)  COMMENT '现居住地址',
    create_time timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    mod_time timestamp default current_timestamp on update current_timestamp COMMENT '更新时间',
    
    PRIMARY KEY (id_type,id_no),
    foreign key(internal_code) references interal_code_table(interal_code)
    
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户基本表';







