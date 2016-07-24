package com.yufeng.dao;

import com.yufeng.entity.InternalCode;

/**
 * Created by kingstones on 16/7/24.
 */
public interface InternalCodeDao {

    int isExistedInternalCode(String internalCode);
    int insertInternalCode(InternalCode internalCode);
    int deleteInternalCode(InternalCode internalCode);
}
