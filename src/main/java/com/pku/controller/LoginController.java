package com.pku.controller;


import com.pku.domain.RespCode;
import com.pku.domain.RespEntity;
import com.pku.domain.UserInfo;
import com.pku.service.LoginService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin
@RestController

@RequestMapping({"/user"})
public class LoginController {

    @Autowired
    LoginService loginService ;


    @RequestMapping(value="/login",method = RequestMethod.POST)
    @ResponseBody
    public RespEntity login(@RequestBody UserInfo  user){
        Boolean result = loginService.loginAction(user);
        if(result){
            return new RespEntity(RespCode.SUCCESS, user.getUserId());
        }else{
            return new RespEntity(RespCode.WARN, "");
        }
    }



    @RequestMapping(value ="/register" , method = RequestMethod.POST)
    @ResponseBody
    public RespEntity register(@RequestBody UserInfo userInfo){
        userInfo.setUserId(new Random().nextInt(1000000));
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        boolean bool = loginService.addUserAction(userInfo);
        if(bool){
            userInfo.setLocked(0);
            userInfo.setRegisterTime(sf.format(new Date()));
            return new RespEntity(RespCode.SUCCESS,userInfo.getUserId());
        }else {
            return new RespEntity(RespCode.WARN,"");
        }
    }

    @RequestMapping(value="/hasUser" , method = RequestMethod.GET)
    @ResponseBody
    public RespEntity hasUser(@Param("name") String name){
        List<UserInfo> u = loginService.hasUser(name);
        if(u.size() >0 ){
            return new RespEntity(RespCode.SUCCESS,-1);
        }else {
            return new RespEntity(RespCode.SUCCESS,0);
        }
    }


    public static String getUUID(){
        UUID uuid=UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr=str.replace("-", "");
        return uuidStr;
    }

}
