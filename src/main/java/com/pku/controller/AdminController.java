package com.pku.controller;


import com.pku.domain.*;
import com.pku.service.AdminService;
import org.apache.catalina.Store;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.*;

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

    @RequestMapping(value="/updateCarType",method = RequestMethod.POST)
    @ResponseBody
    public RespEntity updateCarType(@RequestBody CarType carType){
        Boolean result ;
        result = adminService.updateCarType(carType);
        if(result){
            return new RespEntity(RespCode.SUCCESS, "");
        }else{
            return new RespEntity(RespCode.WARN, "");
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

    @RequestMapping(value="/addCarAndStore",method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public RespEntity addCarAndStore(@RequestBody CarAndStore carAndStore){
        Boolean result = false ;
        String storeName = carAndStore.getStoreName();
        String storeId = carAndStore.getStoreId();
        List<Map<String,String>> carLists = carAndStore.getCarList();
        for(int i=0 ; i<carLists.size();i++){
            String carName = carLists.get(i).get("carName");
            String carId = String.valueOf(carLists.get(i).get("carId"));
            String carPrice   = carLists.get(i).get("carPrice");
            int carNum = Integer.parseInt(carLists.get(i).get("carNum"));
            result = adminService.addCarAndStore(storeName,storeId,carName,carId,carNum,carPrice);
        }
        if(result){
            return new RespEntity(RespCode.SUCCESS, "");
        }else{
            return new RespEntity(RespCode.WARN, "");
        }
    }
    //删除店铺关系车辆
    @RequestMapping(value="/delCarAndStore",method = RequestMethod.GET)
    @ResponseBody
    public RespEntity delCarAndStore(@Param("id") String id ){
        Boolean b ;
        b = adminService.delCarAndStore(id);
        if(b){
            return   new RespEntity(RespCode.SUCCESS, "");
        }else{
            return   new RespEntity(RespCode.WARN, "");
        }
    }

    /**获取车辆列表**/
    @RequestMapping(value="/getCarList",method = RequestMethod.GET)
    @ResponseBody
    public RespEntity getCarList(){
        List<CarType> list= adminService.queryCarList();
        List<Map<String ,Object>> list2 = new ArrayList<Map<String ,Object>>()  ;
        for(int i=0 ; i<list.size(); i++){
            Map<String ,Object> map = new HashMap<String ,Object>();
            map.put("label",list.get(i).carName);
            map.put("value",list.get(i).id);

            list2.add(map);
        }
        return  new RespEntity(RespCode.SUCCESS,list2);
    }


    /**获取店铺列表**/
    @RequestMapping(value="/getStoreList",method = RequestMethod.GET)
    @ResponseBody
    public RespEntity getStoreList(){
        List<StoreInfo> list3= adminService.queryStoreList();
        List<Map<String ,Object>> list4 = new ArrayList<Map<String ,Object>>()  ;
        for(int i=0 ; i<list3.size(); i++){
            Map<String ,Object> map = new HashMap<String ,Object>();
            map.put("label",list3.get(i).storeName);
            map.put("value",list3.get(i).storeId);
            list4.add(map);
        }
        return  new RespEntity(RespCode.SUCCESS,list4);
    }

}
