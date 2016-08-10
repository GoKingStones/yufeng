DROP TABLE if EXISTS register_account_table;

CREATE TABLE register_account_table
(
    register_account_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    internal_code VARCHAR(20) COMMENT '内码ID',
    account_name VARCHAR(100) NOT NULL COMMENT '用户名',
    password VARCHAR(20) NOT NULL COMMENT '登录密码',
    phone_number VARCHAR(11) NOT NULL COMMENT '用户手机号',
    source VARCHAR(2) NOT NULL COMMENT '注册来源',
    account_flag VARCHAR(2) NOT NULL COMMENT '账户状态',
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    mod_time TIMESTAMP DEFAULT current_timestamp ON UPDATE  CURRENT_TIMESTAMP COMMENT '更新时间',

    KEY idx_name(account_name),
    KEY idx_phone_number(phone_number),
    KEY idx_account_flag(account_flag)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='注册账户表';




INSERT INTO register_account_table(account_name,password,phone_number,
source,account_flag,create_time) VALUES
    ('ROOT','ROOT','1822323232','A','A','2016-07-17 00:00:00');

