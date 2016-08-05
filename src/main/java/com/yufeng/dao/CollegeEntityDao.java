package com.yufeng.dao;

import com.yufeng.entity.CollegeEntity;

/**
 * Created by kingstones on 16/7/27.
 */
public interface CollegeEntityDao {

    CollegeEntity getCollegeEntity(String collegeName);
    int insertCollegeEntity(CollegeEntity collegeEntity);
    CollegeEntity getCollegeAcademyEntityByCollegeCode(String collegeCode);
}
