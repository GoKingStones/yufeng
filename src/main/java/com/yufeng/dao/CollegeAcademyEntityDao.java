package com.yufeng.dao;

import com.yufeng.entity.CollegeAcademyEntity;

/**
 * Created by kingstones on 16/8/1.
 */
public interface CollegeAcademyEntityDao {

    CollegeAcademyEntity getCollegeAcademyEntity(String collegeCode,String academyName,String departmentName);
    int insertCollegeAcademyEntity(CollegeAcademyEntity collegeAcademyEntity);

}
