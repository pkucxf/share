package com.pku.controller;

import com.pku.domain.CarType;
import com.pku.domain.RespCode;
import com.pku.domain.RespEntity;
import com.pku.domain.StoreInfo;
import com.pku.service.CarService;
import com.pku.service.StoreService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController

@RequestMapping({"/store"})
public class StoreController {
    @Autowired
    StoreService storeService ;

    @RequestMapping(value="/getStoreList",method = RequestMethod.GET)
    @ResponseBody
    public RespEntity getStoreList(){
        List<StoreInfo> list ;
        list =  storeService.queryStoreInfo();
        return  new RespEntity(RespCode.SUCCESS, list);
    }

    @RequestMapping(value="/getStoreListById",method = RequestMethod.GET)
    @ResponseBody
    public RespEntity getStoreListById(@Param("storeId") String storeId){
        List<StoreInfo> list ;
        list =  storeService.queryStoreInfoById(storeId);
        return  new RespEntity(RespCode.SUCCESS, list);
    }

}
