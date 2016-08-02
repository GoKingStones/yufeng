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
    mod_time timestamp default current_timestamp on update current_timestamp COMMENT '更新时间',


)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学校表';