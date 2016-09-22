DROP  TABLE  IF EXISTS individual_business_basic_info_table ;

CREATE TABLE individual_business_basic_info_table(
    internal_code VARCHAR(100) NOT NULL COMMENT '内码ID',
    shop_name VARCHAR(100) NOT NULL COMMENT '店铺名称',
    shopkeeper_name VARCHAR(100) NOT NULL COMMENT '店主名称',
    shop_addr VARCHAR(100) NOT NULL COMMENT '店铺地址',
    shop_tel VARCHAR(100) NOT NULL COMMENT '联系电话',
    shopkeeper_certificate_type VARCHAR(100) NOT NULL COMMENT '店主证件类型',
    shopkeeper_certificate_number VARCHAR(100) NOT NULL COMMENT '店主证件号码',
    local_area VARCHAR(100) NOT NULL COMMENT '所在地区',
    open_time DATETIME  COMMENT '开通时间',
    close_time DATETIME COMMENT '关闭时间',
    close_reason VARCHAR(100)  COMMENT '关闭原因',
    shop_status VARCHAR(100) NOT NULL COMMENT '店铺状态',
    shop_rank VARCHAR(100) NOT NULL COMMENT '店铺等级',
    shop_scope DOUBLE NOT NULL COMMENT '店铺积分值',
    shop_credit_value DOUBLE NOT NULL COMMENT '店铺信用值',
    create_time timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    mod_time TIMESTAMP DEFAULT current_timestamp ON UPDATE  CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (internal_code)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='个体商户基本信息表';