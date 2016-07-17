package com.yufeng.controller;

import com.yufeng.entity.FavUser;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;


@RestController
public class FavRestfulController {


    private static Logger logger =Logger.getLogger("FavRestfulController");

    @RequestMapping(value="/getUserName",method= RequestMethod.POST)
    public String getUserName(@RequestParam(value="name") String name,ModelMap modelMap){

        return name;
    }

    @RequestMapping("getFavUser")
    public FavUser getFavUser(@RequestParam("userName") String userName,String userId,int userAge){
        FavUser favUser = new FavUser();
        favUser.setUserId(userId);
        favUser.setUserName(userName);
        favUser.setUserAge(userAge);
        return favUser;
    }

    @RequestMapping("getFavUserBody")
    public FavUser getFavUserBody(@RequestBody String body){
        ObjectMapper mapper = new ObjectMapper();
        FavUser favUser = null;
        try {
            favUser = mapper.readValue(body,  FavUser.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return favUser;
    }

    @RequestMapping("getFavUserList")
    @ResponseBody
    public FavUser getFavUserList(@RequestBody List<FavUser> body){


        logger.info("test");


        return body.get(0);
    }

    @RequestMapping("getFavUserFirst")
    @ResponseBody
    public FavUser getFavUserFirst(@RequestBody List<FavUser> body){


        return body.get(0);
    }

}
