DROP TABLE IF EXISTS enterprise_business_basic_info_table;
CREATE TABLE enterprise_business_basic_info_table(
    internal_code VARCHAR(20) NOT NULL COMMENT '内码ID',
    business_name VARCHAR(100) NOT NULL COMMENT '商户名称',
    enterprise_name VARCHAR(100) NOT NULL COMMENT '公司名称',
    enterprise_addr VARCHAR(500) NOT NULL COMMENT '公司地址',
    email VARCHAR(100) NOT NULL COMMENT '电子邮件',
    website VARCHAR(100) NOT NULL COMMENT '网址',
    fax VARCHAR(100) NOT NULL COMMENT '传真',
    manage_contact_name VARCHAR(100) NOT NULL COMMENT '管理层联系人名称',
    manage_contact_tel VARCHAR(100) NOT NULL COMMENT '管理层联系人电话',
    operate_contact_name VARCHAR(100) NOT NULL COMMENT '运营联系人名称',
    operate_contact_tel VARCHAR(100) NOT NULL COMMENT '运营联系人电话',
    business_license_number VARCHAR(100) NOT NULL COMMENT '工商营业执照号',
    legal_person_certificate_type VARCHAR(100) NOT NULL COMMENT '法人证件类型',
    legal_person_certificate_number VARCHAR(100) NOT NULL COMMENT '法人证件号码',
    legal_person_name VARCHAR(100) NOT NULL COMMENT '法人姓名',
    business_licence_management_scope VARCHAR(100) NOT NULL COMMENT '经营执照营业范围',
    business_brand VARCHAR(100) NOT NULL COMMENT '经营品牌',
    registered_capital DECIMAL NOT NULL COMMENT '注册资金',
    open_time TIMESTAMP NOT NULL COMMENT '开通时间',
    business_rank VARCHAR(100) NOT NULL COMMENT '商户等级',
    business_score DOUBLE NOT NULL COMMENT '商户积分',
    business_credit_value DOUBLE NOT NULL COMMENT '商户信用值',
    mod_time TIMESTAMP DEFAULT current_timestamp ON UPDATE  CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (internal_code)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业商户基本信息表';


