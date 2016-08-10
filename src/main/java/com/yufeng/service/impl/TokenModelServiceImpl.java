package com.yufeng.service.impl;

import com.yufeng.algorithm.UUIDGenerator;
import com.yufeng.dao.TokenModelDao;
import com.yufeng.entity.TokenModel;
import com.yufeng.service.TokenModelService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kingstones on 16/8/8.
 */
public class TokenModelServiceImpl implements TokenModelService {

    @Autowired
    private TokenModelDao tokenModelDao;


    public TokenModel createToken(long registerAccountId) {

        //使用uuid作为源token
        String token = UUIDGenerator.getUUID();
        TokenModel model = new TokenModel(registerAccountId, token);
        int result =tokenModelDao.createToken(model);

        if(result==1) {
            return model;
        }else {
            return null;
        }

    }

    public TokenModel getToken(String authentication) {
        if (authentication == null || authentication.length() == 0) {
            return null;
        }
        String[] param = authentication.split("_");
        if (param.length != 2) {
            return null;
        }
        //使用userId和源token简单拼接成的token，可以增加加密措施
        long userId = Long.parseLong(param[0]);
        String token = param[1];
        return new TokenModel(userId, token);
    }


    public boolean checkToken(String authentication) {

        if (authentication == null || authentication.length() == 0) {
            return false;
        }
        String[] param = authentication.split("_");
        if (param.length != 2) {
            return false;
        }
        //使用userregisterAccountIdId和源token简单拼接成的token，可以增加加密措施
        long registerAccountId = Long.parseLong(param[0]);
        String token = param[1];
        TokenModel tokenModel = new TokenModel(registerAccountId, token);
        int result = tokenModelDao.checkToken(tokenModel);

        return result==1?true:false;
    }

    public boolean deleteToken(long registerAccountId) {

        return tokenModelDao.deleteToken(registerAccountId)==1?true:false;
    }
}
