package com.pku.controller;

import com.pku.domain.CarType;
import com.pku.domain.RespCode;
import com.pku.domain.RespEntity;
import com.pku.domain.UserInfo;
import com.pku.service.CarService;
import com.pku.service.LoginService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin
@RestController

@RequestMapping({"/car"})
public class CarController {
    @Autowired
    CarService carService ;

    @RequestMapping(value="/getCarList",method = RequestMethod.GET)
    @ResponseBody
    public RespEntity getCarList(){
        List<CarType> list ;
        list =  carService.queryCarList();
        return  new RespEntity(RespCode.SUCCESS, list);
    }


    @RequestMapping(value="/getCarListById",method = RequestMethod.GET)
    @ResponseBody
    public RespEntity getCarListById(@Param("id") int id ){
        List<CarType> list ;
        list =  carService.queryCarListById(id);
        return  new RespEntity(RespCode.SUCCESS, list);
    }
}
