package com.pku.controller;


import com.pku.domain.RespCode;
import com.pku.domain.RespEntity;
import com.pku.domain.UserInfo;
import com.pku.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin
@RestController

@RequestMapping({"/web"})
public class LoginController {

    @Autowired
    LoginService loginService ;


    @RequestMapping(value="/login",method = RequestMethod.POST)
    @ResponseBody
    public RespEntity login(@RequestBody UserInfo  userInfo1){
        UserInfo userInfo = loginService.loginAction(userInfo1.getName(),userInfo1.getPassword());
        Integer i = userInfo.getUserId();
        Map result = new HashMap();
        if(i == null ){
            return new RespEntity(RespCode.WARN, result);
        }else{
            result.put("name",userInfo.getName());
            result.put("locked",userInfo.getLocked());
            return new RespEntity(RespCode.SUCCESS, result);
        }
    }


   /*
    @CrossOrigin
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
*/

    @RequestMapping(value ="/register" , method = RequestMethod.POST)
    @ResponseBody
    public RespEntity register(@RequestBody UserInfo userInfo){
        userInfo.setUserId(new Random().nextInt(1000000));
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        boolean bool = loginService.addUserAction(userInfo);
        if(bool){
            userInfo.setLocked(0);
            userInfo.setRegisterTime(sf.format(new Date()));
            return new RespEntity(RespCode.SUCCESS,"");
        }else {
            return new RespEntity(RespCode.WARN,"");
        }
    }

    public static String getUUID(){
        UUID uuid=UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr=str.replace("-", "");
        return uuidStr;
    }

}
