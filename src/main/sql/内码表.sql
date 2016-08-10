DROP TABLE IF EXISTS internal_code_table;
CREATE TABLE internal_code_table(

    internal_code VARCHAR(100) NOT NULL COMMENT '内码ID',
    create_time TIMESTAMP DEFAULT current_timestamp COMMENT '创建时间',
    PRIMARY KEY (internal_code)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='内码表';
