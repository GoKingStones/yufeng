package com.yufeng.entity;

/**
 * Created by kingstones on 16/8/8.
 * token类
 */
public class TokenModel {

    //注册账号id
    private long registerAccountId;

    //随机生成的uuid
    private String token;

    public TokenModel(long registerAccountId, String token) {
        this.registerAccountId = registerAccountId;
        this.token = token;
    }

    public long getRegisterAccountId() {
        return registerAccountId;
    }

    public void setRegisterAccountId(long registerAccountId) {
        this.registerAccountId = registerAccountId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
