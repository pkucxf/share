package com.pku.controller;


import com.pku.domain.*;
import com.pku.service.AdminService;
import com.pku.service.CarService;
import com.pku.service.OrderService;
import com.pku.service.StoreService;
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

    @RequestMapping(value="/userLogin",method = RequestMethod.POST)
    @ResponseBody
    public RespEntity userLogin(@RequestBody AdminUserInfo adminUserInfo){
        List<AdminUserInfo>  aUser = adminService.queryAdminUser(adminUserInfo);
            if(aUser.size()>0){
           String storeId =  adminService.queryStoreInfo(aUser.get(0).userName);
            Map map = new HashMap();
            map.put("id",aUser.get(0).id);
            map.put("type",aUser.get(0).userType);
            map.put("storeId",storeId);
            return new RespEntity(RespCode.SUCCESS, map);
        }else{
            return new RespEntity(RespCode.WARN, "");
        }
    }


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
        // 创建店铺管理客户端登陆名和密码，初始密码000000
        List<AdminUserInfo> ad =  adminService.selectUser(storeInfo.getStorePhone());
        if(ad.size() == 0){
            adminService.insertToAdmin(storeInfo.getStorePhone(),"000000");
        }
        if(result){
            return new RespEntity(RespCode.SUCCESS, 0);
        }else{
            return new RespEntity(RespCode.WARN, -1);
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


    /**查询订单列表**/
    @RequestMapping(value="/getOrderList",method = RequestMethod.GET)
    @ResponseBody
    public RespEntity getOrderList(@Param("userId") int userId ,@Param("userType") int userType , @Param("payStatu") int payStatu , @Param("storeId") String storeId){
        // userType : 1  管理员   0  商户
        payStatu = payStatu -1 ;
        List<OrderInfo>  allOrder;
        if(payStatu < 0 ){
            if(userType == 1){
                allOrder = adminService.queryAllOrderList();
            }else{
                allOrder = adminService.queryAllOrderByStoreId(storeId);
            }
        }else{
            if(userType ==1 ){
                allOrder = adminService.queryAllOrderByPaystatu(payStatu);
            }else{
                 allOrder = adminService.queryAllOrderByPaystatu2(payStatu,storeId);
            }
        }
        for(int i=0 ; i< allOrder.size();i++){
            List<StoreInfo> storeInfos  = adminService.queryStoreInfoById(allOrder.get(i).storeId);
            List<CarType> car = adminService.queryCarListById(allOrder.get(i).carId );
            allOrder.get(i).setStoreInfos(storeInfos);
            allOrder.get(i).setCarTypes(car);
        }
        return new RespEntity(RespCode.SUCCESS, allOrder);

       /* if(userType == 1){

        }else{
            List ln = new ArrayList();
            return new RespEntity(RespCode.SUCCESS, ln);
        }*/
    }

    /**确认订单**/
    @RequestMapping(value="/sureOrder",method = RequestMethod.GET)
    @ResponseBody
    public RespEntity sureOrder(@Param("userId") int id){
        int payStatu =1  ;
        Boolean bool =adminService.sureOrder(payStatu,id);
        if(bool){
            return new RespEntity(RespCode.SUCCESS, "");
        }else {
            return new RespEntity(RespCode.WARN, "");
        }
    }









}
