package com.pku.controller;


import com.pku.domain.CarType;
import com.pku.domain.RespCode;
import com.pku.domain.RespEntity;
import com.pku.domain.UserInfo;
import com.pku.service.AdminService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController

@RequestMapping({"/admin"})
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping(value="/getUserInfo",method = RequestMethod.GET)
    @ResponseBody
    public RespEntity getUserInfo(){
        List<UserInfo> list ;
        list =  adminService.queryUserInfo();
        return  new RespEntity(RespCode.SUCCESS, list);
    }

    @RequestMapping(value="/delUser",method = RequestMethod.GET)
    @ResponseBody
    public RespEntity delUser(@Param("id") int id ){
        Boolean b  = adminService.delUserInfo(id);
        if(b){
            return   new RespEntity(RespCode.SUCCESS, "");
        }else{
            return   new RespEntity(RespCode.WARN, "");
        }
    }
    @RequestMapping(value="/updateUser",method = RequestMethod.POST)
    @ResponseBody
    public RespEntity updateUser(@RequestBody UserInfo userInfo){
        Boolean result ;
        result = adminService.updateUserInfo(userInfo);
        if(result){
            return new RespEntity(RespCode.SUCCESS, "");
        }else{
            return new RespEntity(RespCode.WARN, "");
        }
    }



    @RequestMapping(value="/getCarType",method = RequestMethod.GET)
    @ResponseBody
    public RespEntity getCarType(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize){
        List<CarType> list ;
        list =  adminService.queryCarType(pageNo,pageSize);
        return   new RespEntity(RespCode.SUCCESS, list);
    }

    @RequestMapping(value="/addCarType",method = RequestMethod.POST)
    @ResponseBody
    public RespEntity addCarType(@RequestBody CarType carType){
        Boolean result ;
        result = adminService.addCarType(carType);
        if(result){
            return new RespEntity(RespCode.SUCCESS, "");
        }else{
            return new RespEntity(RespCode.WARN, "");
        }
    }

    @RequestMapping(value="/delCarType",method = RequestMethod.GET)
    @ResponseBody
    public RespEntity delCarType(@Param("id") int id ){
        Boolean b ;
        b = adminService.delCarType(id);
        if(b){
            return   new RespEntity(RespCode.SUCCESS, "");
        }else{
            return   new RespEntity(RespCode.WARN, "");
        }

    }


}
