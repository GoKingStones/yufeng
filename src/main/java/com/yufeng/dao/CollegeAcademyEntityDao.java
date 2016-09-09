package com.yufeng.dao;

import com.yufeng.entity.CollegeAcademyEntity;

/**
 * Created by kingstones on 16/8/1.
 * 学校院系信息DAO
 */
public interface CollegeAcademyEntityDao {

    //通过学校编号，学院名称，系名称来获取院系详细信息
    CollegeAcademyEntity getCollegeAcademyEntity(String collegeCode,String academyName,String departmentName);

    //插入院系信息
    int insertCollegeAcademyEntity(CollegeAcademyEntity collegeAcademyEntity);

}
