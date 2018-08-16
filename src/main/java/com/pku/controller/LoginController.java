package com.pku.controller;


import com.pku.domain.RespCode;
import com.pku.domain.RespEntity;
import com.pku.domain.UserInfo;
import com.pku.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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



}
