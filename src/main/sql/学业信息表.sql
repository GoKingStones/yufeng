DROP TABLE IF EXISTS school_experience_info;
CREATE TABLE school_experience_info

(
	unique_id int unsigned NOT NULL auto_increment COMMENT '信息标识ID',
    internal_code VARCHAR(20) NOT NULL COMMENT '内码',
    student_code VARCHAR(100) COMMENT '学籍编号',
    school_code VARCHAR(100) COMMENT '学校编号',
    academy_code VARCHAR(100) COMMENT '学院编号',
    major_code VARCHAR(100) COMMENT '专业编号',
    other_school_name VARCHAR(100) COMMENT '其他学校名称',
    other_academy_name VARCHAR(100) COMMENT '其他学院名称',
	other_major_name VARCHAR(100) COMMENT '其他专业名称',
    admission_date date NOT NULL COMMENT '入学时间',
	finish_school_date date COMMENT '毕业时间',	
    class_no VARCHAR(20) COMMENT '班级',
    school_student_id VARCHAR(100) COMMENT '学号',
    education_type VARCHAR(100) NOT NULL COMMENT '就读学历',
    education VARCHAR(2) COMMENT '取得学历',
    info_status VARCHAR(2) NOT NULL COMMENT '信息状态',
    create_time timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    mod_time timestamp default current_timestamp on update current_timestamp COMMENT '更新时间',
    who_did VARCHAR(100) NOT NULL COMMENT '操作者',
    
    PRIMARY KEY (unique_id),
    foreign key(internal_code) references interal_code_table(interal_code)
    
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学业信息表';