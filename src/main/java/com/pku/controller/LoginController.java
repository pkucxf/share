package com.pku.controller;


import com.pku.domain.RespCode;
import com.pku.domain.RespEntity;
import com.pku.domain.UserInfo;
import com.pku.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

@RequestMapping({"/login"})
public class LoginController {

    @Autowired
    LoginService loginService ;

    @RequestMapping(value="/login",method = RequestMethod.POST)
    @ResponseBody
    public RespEntity login(String name, String password){
        UserInfo userInfo = loginService.loginAction(name);
        return new RespEntity(RespCode.SUCCESS, userInfo);
    }

    @RequestMapping(value="/login2",method = RequestMethod.POST)
    @ResponseBody
    public RespEntity login2(UserInfo userInfo){
        UserInfo userInfo1 = loginService.loginAction2(userInfo.getName());
        Map map = new HashMap();
        if(userInfo1.getPhone() != ""){
            map.put("name",userInfo1.getName());
        }else{
            map.put("name",null);
        }
        return new RespEntity(RespCode.SUCCESS, map);
    }


    @RequestMapping(value ="/addUser" , method = RequestMethod.POST)
    @ResponseBody
    public RespEntity addUser(UserInfo userInfo){
        boolean bool = loginService.addUserAction(userInfo);
        if(bool){
            return new RespEntity(RespCode.SUCCESS,"");
        }else {
            return new RespEntity(RespCode.WARN,"");
        }

    }



}
