package com.pku.share;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping({"/user"})
public class UserController {
    @Autowired
    UserMapping userMapping ;

    @RequestMapping(value="/user")
    @ResponseBody
    public String getUserInfoByName(String name){
        User user = userMapping.findUserByName(name).get(0);
        return user.getAddress();
    }

    @RequestMapping(value="/getUser")
    @ResponseBody
    public String getUser(){
        return "1234";
    }
}
