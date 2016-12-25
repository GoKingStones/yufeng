package com.yufeng.dao;

import com.yufeng.entity.BOCLoanAccountEntity;

/**
 * Created by kingstones on 16/12/23.
 * 中银消费金融账户DAO
 */
public interface BOCLoanAccountDao {

    //添加金融账户
    public int insertBOCLoanAccount(BOCLoanAccountEntity bocLoanAccountEntity);

    //更新金融账户
    public int updateBOCLoanAccount(BOCLoanAccountEntity bocLoanAccountEntity);

}
