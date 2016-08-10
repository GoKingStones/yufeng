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