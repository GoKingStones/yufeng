package com.yufeng.dao;

import com.yufeng.entity.TokenModel;

/**
 * Created by kingstones on 16/8/8.
 */
public interface TokenModelDao {

    /**
     * 创建一个token关联上指定用户
     * @param
     * @return 生成的token
     */
    public int createToken(TokenModel tokenModel);

    /**
     * 检查token是否有效
     * @param model token
     * @return 是否有效
     */
    public int checkToken(TokenModel model);

//    /**
//     * 从字符串中解析token
//     * @param authentication 加密后的字符串
//     * @return
//     */
//    public TokenModel getToken(String authentication);

    /**
     * 清除token
     * @param registerAccountId 登录用户的id
     */
    public int deleteToken(long registerAccountId);

}
