DROP TABLE if EXISTS account_relate_table;

CREATE TABLE account_relate_table
(

    internal_code VARCHAR(100) COMMENT '内码ID',
    boc_loan_acct VARCHAR(13) NOT NULL COMMENT '中银消费金融账户',
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    mod_time TIMESTAMP DEFAULT current_timestamp ON UPDATE  CURRENT_TIMESTAMP COMMENT '更新时间'

)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账户对应关系表';



