--数据库初始化脚本

CREATE DATABASE yufeng DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


use yufeng;

DROP TABLE IF EXISTS internal_code_table;
CREATE TABLE internal_code_table(

    internal_code VARCHAR(100) NOT NULL COMMENT '内码ID',
    create_time TIMESTAMP DEFAULT current_timestamp COMMENT '创建时间',
    PRIMARY KEY (internal_code)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='内码表';





DROP TABLE if EXISTS register_account_table;

CREATE TABLE register_account_table
(
    register_account_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    internal_code VARCHAR(100) COMMENT '内码ID',
    account_name VARCHAR(100) NOT NULL COMMENT '用户名',
    password VARCHAR(50) NOT NULL COMMENT '登录密码',
    phone_number VARCHAR(11) NOT NULL COMMENT '用户手机号',
    source VARCHAR(10) NOT NULL COMMENT '注册来源',
    account_flag VARCHAR(2) NOT NULL COMMENT '账户状态',
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    mod_time TIMESTAMP DEFAULT current_timestamp ON UPDATE  CURRENT_TIMESTAMP COMMENT '更新时间',

    KEY idx_name(account_name),
    KEY idx_phone_number(phone_number),
    KEY idx_account_flag(account_flag)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='注册账户表';




DROP TABLE IF EXISTS user_basic_info;
CREATE TABLE user_basic_info

(
    internal_code VARCHAR(100) NOT NULL COMMENT '内码',
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
    foreign key(internal_code) references internal_code_table(internal_code)
    
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户基本表';



DROP TABLE IF EXISTS credit_account_info;
CREATE TABLE credit_account_info

(
    internal_code VARCHAR(100) NOT NULL COMMENT '内码',
    open_date Date NOT NULL COMMENT '开户日期',
    account_type VARCHAR(10) NOT NULL COMMENT '账户类型',
    initial_cash_quota Decimal NOT NULL COMMENT '初始现金额度',
    initial_guarantee_quota Decimal NOT NULL COMMENT '初始担保额度',
    current_cash_quota Decimal NOT NULL COMMENT '当前现金额度',
    current_guarantee_quota Decimal NOT NULL COMMENT '当前担保额度',
	available_cash_quota Decimal NOT NULL COMMENT '当前可用现金额度',
    available_guarantee_quota Decimal NOT NULL COMMENT '当前可用担保额度',
    account_status VARCHAR(10) NOT NULL COMMENT '账户状态',
    create_time timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    mod_time timestamp default current_timestamp on update current_timestamp COMMENT '更新时间',
    
    PRIMARY KEY (internal_code),
    foreign key(internal_code) references internal_code_table(internal_code)
    
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账户基本表';



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




DROP TABLE IF EXISTS city_house_price_table;
CREATE TABLE city_house_price_table

(
    unique_id int unsigned NOT NULL auto_increment COMMENT '信息标识ID',
	city_code VARCHAR(100) not null COMMENT '城市编号',
    house_price VARCHAR(100) not null COMMENT '房价均价',
	data_period VARCHAR(20) not null COMMENT '数据时间',
    create_time timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    mod_time timestamp default current_timestamp on update current_timestamp COMMENT '更新时间',
    
    PRIMARY KEY (unique_id),
    foreign key(city_code) references city_code_table(city_code)
    
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='城市房价系数表';


DROP TABLE IF EXISTS city_consumption_level;
CREATE TABLE city_consumption_level

(
    unique_id int unsigned NOT NULL auto_increment COMMENT '信息标识ID',
	city_code VARCHAR(100) not null COMMENT '城市编号',
    consumption_level VARCHAR(100) not null COMMENT '年消费水平',
	data_period VARCHAR(20) not null COMMENT '数据时间',
    create_time timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    mod_time timestamp default current_timestamp on update current_timestamp COMMENT '更新时间',
    
    PRIMARY KEY (unique_id),
    foreign key(city_code) references city_code_table(city_code)
    
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='城市消费水平表';


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



DROP TABLE IF EXISTS college_tuition_table;
CREATE TABLE college_tuition_table

(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    college_province VARCHAR(100),
    college_tuition VARCHAR(100),
    create_time timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    mod_time timestamp default current_timestamp on update current_timestamp COMMENT '更新时间'


)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学费表';

DROP TABLE IF EXISTS college_table;
CREATE TABLE college_table

(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    college_code VARCHAR(10) not null COMMENT '学校编号',
	  college_name VARCHAR(100) not null COMMENT '学校名称',
    city_code VARCHAR(10) not null COMMENT '所在城市编号',
	  college_classification VARCHAR(100) COMMENT '学校分类',
    create_time timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    mod_time timestamp default current_timestamp on update current_timestamp COMMENT '更新时间'


)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学校表';



DROP TABLE IF EXISTS college_academy_table;
CREATE TABLE college_academy_table

(

    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    internal_code VARCHAR(100) NOT NULL DEFAULT "" COMMENT '信息标识ID',
    college_code VARCHAR(10) not null COMMENT '学校编号',
    academy_name VARCHAR(100) not NULL DEFAULT "" COMMENT '学院名称',
    academy_code VARCHAR(100) NOT NULL DEFAULT "" COMMENT '院编号',
    department_code VARCHAR(100) NOT NULL DEFAULT "" COMMENT '系编号',
    department_name VARCHAR(100) NOT NULL DEFAULT "" COMMENT '系名称',
    tuitionPerYear DOUBLE NOT NULL DEFAULT 0 COMMENT '年学费',
    courses_taken VARCHAR(100) NOT NULL DEFAULT "" COMMENT '所修学历',
    courses_rank VARCHAR(100) NOT NULL DEFAULT "" COMMENT '所修专业等级',
    employment_rate DOUBLE NOT NULL DEFAULT 0 COMMENT '就业率',
    current_flag VARCHAR(2) NOT NULL DEFAULT "" COMMENT '当前状态',
    create_time timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    mod_time timestamp default current_timestamp on update current_timestamp COMMENT '更新时间'


)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学校学院信息表';



DROP TABLE IF EXISTS school_experience_info;
CREATE TABLE school_experience_info

(
	unique_id int unsigned NOT NULL auto_increment COMMENT '信息标识ID',
    internal_code VARCHAR(100) NOT NULL COMMENT '内码',
    student_code VARCHAR(100) COMMENT '学籍编号',
    school_code VARCHAR(100) COMMENT '学校编号',
    academy_code VARCHAR(100) COMMENT '学院编号',
    major_code VARCHAR(100) COMMENT '专业编号',
    other_school_name VARCHAR(100) COMMENT '其他学校名称',
    other_academy_name VARCHAR(100) COMMENT '其他学院名称',
	other_major_name VARCHAR(100) COMMENT '其他专业名称',
    admission_date date NOT NULL COMMENT '入学时间',
	finish_school_date date COMMENT '毕业时间',	
	completing VARCHAR(2) NOT NULL COMMENT '是否在读',
    class_no VARCHAR(20) COMMENT '班级',
    school_student_id VARCHAR(100) COMMENT '学号',
    education_type VARCHAR(100) NOT NULL COMMENT '就读学历',
    education VARCHAR(2) COMMENT '取得学历',
    info_status VARCHAR(2) NOT NULL COMMENT '信息状态',
    create_time timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    mod_time timestamp default current_timestamp on update current_timestamp COMMENT '更新时间',
    who_did VARCHAR(100) NOT NULL COMMENT '操作者',
    
    PRIMARY KEY (unique_id),
    foreign key(internal_code) references internal_code_table(internal_code)
    
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学业信息表';




DROP TABLE IF EXISTS user_family_info_history_table;
CREATE TABLE `user_family_info_history_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `internal_code` varchar(100) DEFAULT NULL,
  `credentialsType` varchar(2) DEFAULT NULL COMMENT '证件类型',
  `credentialsNumber` varchar(50) DEFAULT NULL COMMENT '证件号码',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `gender` varchar(2) DEFAULT NULL COMMENT '性别',
  `mailingAddress` varchar(200) DEFAULT NULL COMMENT '通讯地址',
  `organization` varchar(100) DEFAULT NULL COMMENT '工作单位',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `mailbox` varchar(100) DEFAULT NULL COMMENT '电子邮箱',
  `relation` varchar(2) DEFAULT NULL COMMENT '与主体关系',
  `highestEducationSchool` varchar(100) DEFAULT NULL COMMENT '最高学历院校',
  `highestEducation` varchar(100) DEFAULT NULL COMMENT '最高学历',
  `foundTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '新建时间',
  `updateTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `delete_operator` varchar(50) DEFAULT NULL COMMENT '删除操作者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS user_family_info_table;
CREATE TABLE `user_family_info_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `internal_code` varchar(100) DEFAULT NULL,
  `credentialsType` varchar(2) DEFAULT NULL COMMENT '证件类型',
  `credentialsNumber` varchar(50) DEFAULT NULL COMMENT '证件号码',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `gender` varchar(2) DEFAULT NULL COMMENT '性别',
  `mailingAddress` varchar(200) DEFAULT NULL COMMENT '通讯地址',
  `organization` varchar(100) DEFAULT NULL COMMENT '工作单位',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `mailbox` varchar(100) DEFAULT NULL COMMENT '电子邮箱',
  `relation` varchar(2) DEFAULT NULL COMMENT '与主体关系',
  `highestEducationSchool` varchar(100) DEFAULT NULL COMMENT '最高学历院校',
  `highestEducation` varchar(100) DEFAULT NULL COMMENT '最高学历',
  `foundTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updateTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




DROP TABLE IF EXISTS user_financial_account_info_table;
CREATE TABLE `user_financial_account_info_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `internal_code` varchar(100) DEFAULT NULL COMMENT '内码',
  `signId` varchar(100) DEFAULT NULL COMMENT '信息标识ID',
  `financialConsumeAccountId` varchar(100) DEFAULT NULL COMMENT '金融消费账户ID',
  `financialConsumeCompany` varchar(100) DEFAULT NULL COMMENT '金融消费公司',
  `financialConsumeAccountState` varchar(2) DEFAULT NULL COMMENT '金融消费账户状态',
  `creditScoring` int(11) DEFAULT NULL COMMENT '信用评分',
  `authorize` varchar(2) DEFAULT NULL COMMENT '是否授权',
  `foundTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `info_status` tinyint(2) DEFAULT '1' COMMENT '是否有效',
  `delete_operator` varchar(50) DEFAULT NULL COMMENT '删除操作者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




DROP TABLE IF EXISTS bank_card_info_table;
CREATE TABLE `bank_card_info_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `internal_code` varchar(100) DEFAULT NULL COMMENT '内码',
  `bankCardNumber` varchar(20) DEFAULT NULL COMMENT '银行卡号',
  `bankCardType` varchar(2) DEFAULT NULL COMMENT '银行卡类型',
  `expireTime` timestamp NULL DEFAULT NULL COMMENT '到期时间',
  `transferAccount` tinyint(2) DEFAULT NULL COMMENT '是否为转入账户',
  `bankCardState` varchar(2) DEFAULT NULL COMMENT '银行卡状态',
  `foundTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  `info_status` tinyint(2) DEFAULT '1' COMMENT '是否有效',
  `delete_operator` varchar(50) DEFAULT NULL COMMENT '操作者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;   


DROP TABLE IF EXISTS `guarantee_relationship_info_table`;
CREATE TABLE `guarantee_relationship_info_table` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `internal_code` varchar(100) NOT NULL COMMENT '用户内码(被担保人)',
  `relate_user_internal_code` varchar(100) NOT NULL COMMENT '形成关系用户内码(担保人)',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '关系状态',
  `assure_money` decimal(10,2) DEFAULT NULL COMMENT '担保金额',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `mod_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `guarantee_relationship_info_his_table`;
CREATE TABLE `guarantee_relationship_info_his_table` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `internal_code` varchar(100) DEFAULT NULL COMMENT '用户内码(被担保人)',
  `relate_user_internal_code` varchar(100) DEFAULT NULL COMMENT '形成关系用户内码(担保人)',
  `status` tinyint(1) DEFAULT NULL COMMENT '关系状态',
  `assure_money` decimal(10,2) DEFAULT NULL COMMENT '担保金额',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--创建客户基本信息，以及信用账户相关的数据库表
--包括：内码表、注册账户表、客户基本表、信用账户表、面签服务、学业信息表、用户家庭联系人信息表、用户家庭联系人历史表、用户金融账户信息表、用户银行卡信息表、担保关系表、担保关系历史表；
--城市表、城市房价系数表、城市年消费水平表、城市薪酬差异系数表、省份学费表、学校表、学校学院信息表、
