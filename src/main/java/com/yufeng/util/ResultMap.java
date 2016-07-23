package com.yufeng.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kingstones on 16/7/20.
 */
public class ResultMap {

    private Map<String,String> map;

    public ResultMap() {
        map=new HashMap<String, String>();
    }

    public Map<String,String> getSuccessMap() {
        map.put("flag","success");
        return map;
    }

    public Map<String,String> getErrorMap() {
        map.put("flag","error");
        return map;
    }

    public Map<String,String> putMsg(String key,String value) {
        map.put(key,value);
        return map;
    }


}
