package com.yufeng.service;

import com.yufeng.entity.TokenModel;

/**
 * Created by kingstones on 16/8/8.
 */
public interface TokenModelService {


    /**
     * 创建一个token关联上指定用户
     * @param registerAccountId 指定用户的id
     * @return 生成的token
     */
    public TokenModel createToken(long registerAccountId);


    public TokenModel getToken(String authentication);
    /**
     * 检查token是否有效
     * @param authentication
     * @return 是否有效
     */
    public boolean checkToken(String authentication);


    /**
     * 清除token
     * @param registerAccountId 登录用户的id
     */
    public boolean deleteToken(long registerAccountId);

}
