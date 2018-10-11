package com.pku.controller;

import com.pku.domain.*;
import com.pku.service.DrivingService;
import com.pku.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController

@RequestMapping({"/driving"})
public class DrivingController {
    @Autowired
    DrivingService drivingService ;

    @RequestMapping(value="/getList",method = RequestMethod.GET)
    @ResponseBody
    public RespEntity getStoreList(){
        List<CarAndStore> list = drivingService.queryCarAndStore();
        for(int i = 0 ; i<list.size();i++){
            String carId = list.get(i).carId ;
            List<CarType> carTypes =  drivingService.queryCarType(carId);
            String carImg = carTypes.get(0).img;
            list.get(i).setCarImg(carImg);
        }

        return  new RespEntity(RespCode.SUCCESS, list);
    }



    @RequestMapping(value="/getCarInfo",method = RequestMethod.GET)
    @ResponseBody
    public RespEntity getCarInfo(String carId ,int id ){
        List<CarType> carTypes  =  drivingService.queryCarType(carId);
        String price = drivingService.queryPrice(id);
        carTypes.get(0).setDef1(price);
        return  new RespEntity(RespCode.SUCCESS, carTypes.get(0));
    }

        @RequestMapping(value="/getStoreInfo",method = RequestMethod.GET)
    @ResponseBody
    public RespEntity getStoreInfo(String storeId){
        List<StoreInfo> storeInfos = drivingService.queryStore(storeId);
        return  new RespEntity(RespCode.SUCCESS, storeInfos.get(0));
    }

}
