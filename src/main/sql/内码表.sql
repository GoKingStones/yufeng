DROP TABLE IF EXISTS interal_code_table;
CREATE TABLE interal_code_table(

    interal_code VARCHAR(100) NOT NULL COMMENT '内码ID',
    create_time TIMESTAMP DEFAULT current_timestamp COMMENT '创建时间',
    mod_time TIMESTAMP DEFAULT current_timestamp ON UPDATE  CURRENT_TIMESTAMP COMMENT '更新时间',

    PRIMARY KEY (interal_code)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='内码表';