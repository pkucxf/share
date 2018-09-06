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

    @RequestMapping(value="/login",method = RequestMethod.POST)
    @ResponseBody
    public RespEntity login(@RequestBody CarType carType){
        return   new RespEntity(RespCode.SUCCESS, "");
    }


    @RequestMapping(value="/getCarType",method = RequestMethod.GET)
    @ResponseBody
    public RespEntity getCarType(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize){
        List<CarType> list ;
        list =  adminService.queryCarType(pageNo,pageSize);
        return   new RespEntity(RespCode.SUCCESS, list);
    }

}
