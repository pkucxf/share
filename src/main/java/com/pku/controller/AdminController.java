package com.pku.controller;


import com.pku.domain.*;
import com.pku.service.AdminService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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


    @RequestMapping(value="/getStore",method = RequestMethod.GET)
    @ResponseBody
    public RespEntity getStore(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize){
        List<StoreInfo> list2 ;
        list2 = adminService.queryStore(pageNo,pageSize);
        return   new RespEntity(RespCode.SUCCESS, list2);
    }

    @RequestMapping(value="/addStore",method = RequestMethod.POST)
    @ResponseBody
    public RespEntity addStore(@RequestBody StoreInfo storeInfo){
        Boolean result ;
        result = adminService.addStore(storeInfo);
        if(result){
            return new RespEntity(RespCode.SUCCESS, "");
        }else{
            return new RespEntity(RespCode.WARN, "");
        }
    }

    @RequestMapping(value="/delStore",method = RequestMethod.GET)
    @ResponseBody
    public RespEntity delStore(@Param("id") String id ){
        Boolean b ;
        b = adminService.delStore(id);
        if(b){
            return   new RespEntity(RespCode.SUCCESS, "");
        }else{
            return   new RespEntity(RespCode.WARN, "");
        }
    }

    /*店铺车辆关系*/
    @RequestMapping(value="/getCarAndStore",method = RequestMethod.GET)
    @ResponseBody
    public RespEntity getCarAndStore(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize){
        List<CarAndStore> list2 ;
        list2 = adminService.queryCarAndStore(pageNo,pageSize);
        return   new RespEntity(RespCode.SUCCESS, list2);
    }

    @RequestMapping(value="/addCarAndStore",method = RequestMethod.POST)
    @ResponseBody
    public RespEntity addCarAndStore(@RequestBody CarAndStore carAndStore){
        Boolean result ;
        result = adminService.addCarAndStore(carAndStore);
        if(result){
            return new RespEntity(RespCode.SUCCESS, "");
        }else{
            return new RespEntity(RespCode.WARN, "");
        }
    }


    /**获取车辆列表**/
    @RequestMapping(value="/getCarList",method = RequestMethod.GET)
    @ResponseBody
    public RespEntity getCarList(){
        List<CarType> list= adminService.queryCarList();
        List list2 = new ArrayList();
        for(int i= 0 ; i<list.size();i++){
            list2.add(list.get(i).carName);
        }
        return   new RespEntity(RespCode.SUCCESS,list2);
    }


}
