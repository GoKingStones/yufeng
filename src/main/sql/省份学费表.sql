DROP TABLE IF EXISTS college_tuition_table;
CREATE TABLE college_tuition_table

(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    college_province VARCHAR(100),
    college_tuition VARCHAR(100),
    create_time timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    mod_time timestamp default current_timestamp on update current_timestamp COMMENT '更新时间'


)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学费表';

insert into college_tuition_table(college_province,college_tuition)  values('北京','4200－5500元／学年');
insert into college_tuition_table(college_province,college_tuition)  values('山东','3600－5000元／学年');
insert into college_tuition_table(college_province,college_tuition)  values('上海','5000元／学年');
insert into college_tuition_table(college_province,college_tuition)  values('湖南','4000－5000元／学年');
insert into college_tuition_table(college_province,college_tuition)  values('天津','4200－5000元／学年');
insert into college_tuition_table(college_province,college_tuition)  values('山西','2800－3800元／学年');
insert into college_tuition_table(college_province,college_tuition)  values('河南','2700－3100元／学年');
insert into college_tuition_table(college_province,college_tuition)  values('内蒙古','3000－3500元／学年');
insert into college_tuition_table(college_province,college_tuition)  values('湖北','3600－5000元／学年');
insert into college_tuition_table(college_province,college_tuition)  values('广东','4560－5200元／学年');
insert into college_tuition_table(college_province,college_tuition)  values('吉林','3500－4500元／学年');
insert into college_tuition_table(college_province,college_tuition)  values('广西','3200－4500元／学年');
insert into college_tuition_table(college_province,college_tuition)  values('江苏','4000－4600元／学年');
insert into college_tuition_table(college_province,college_tuition)  values('海南','3800－4200元／学年');
insert into college_tuition_table(college_province,college_tuition)  values('海南','2800－4200元／学年');
insert into college_tuition_table(college_province,college_tuition)  values('重庆','3200－4500元／学年');
insert into college_tuition_table(college_province,college_tuition)  values('广东','4560－5200元／学年');
insert into college_tuition_table(college_province,college_tuition)  values('四川','4000－4600元／学年');
insert into college_tuition_table(college_province,college_tuition)  values('河北','3500－5000元／学年');
insert into college_tuition_table(college_province,college_tuition)  values('贵州','2500－4000元／学年');
insert into college_tuition_table(college_province,college_tuition)  values('浙江','4000－4800元／学年');
insert into college_tuition_table(college_province,college_tuition)  values('云南','2800－3400元／学年');
insert into college_tuition_table(college_province,college_tuition)  values('辽宁','4200－5000元／学年');
insert into college_tuition_table(college_province,college_tuition)  values('陕西','3500－4500元／学年');
insert into college_tuition_table(college_province,college_tuition)  values('安徽','3500－5000元／学年');
insert into college_tuition_table(college_province,college_tuition)  values('甘肃','4200－5000元／学年');
insert into college_tuition_table(college_province,college_tuition)  values('黑龙江','500－4800元／学年');
insert into college_tuition_table(college_province,college_tuition)  values('青海','2800－3300元／学年');
insert into college_tuition_table(college_province,college_tuition)  values('福建','3900－5200元／学年');
insert into college_tuition_table(college_province,college_tuition)  values('宁夏','3000元／学年');
insert into college_tuition_table(college_province,college_tuition)  values('新疆','3500元／学年');