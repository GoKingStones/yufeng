package com.yufeng.dao;

import com.yufeng.entity.CollegeEntity;

/**
 * Created by kingstones on 16/7/27.
 * 学校DAO
 */
public interface CollegeEntityDao {

    //通过学校名称获取学校信息
    CollegeEntity getCollegeEntity(String collegeName);
    //插入学校信息
    int insertCollegeEntity(CollegeEntity collegeEntity);


    CollegeEntity getCollegeAcademyEntityByCollegeCode(String collegeCode);
}
