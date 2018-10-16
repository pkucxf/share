package com.pku.controller;

import com.pku.domain.*;
import com.pku.service.CarService;
import com.pku.service.OrderService;
import com.pku.service.StoreService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController

@RequestMapping({"/order"})
public class OrderController {
    @Autowired
    OrderService orderService ;
    @Autowired
    StoreService storeService ;
    @Autowired
    CarService carService ;

    @RequestMapping(value="/addOrder",method = RequestMethod.POST)
    @ResponseBody
    public RespEntity addOrder(@RequestBody OrderInfo orderInfo){
        Boolean  result  = orderService.addOrder(orderInfo);
        if(result){
            return new RespEntity(RespCode.SUCCESS, "");
        }else{
            return new RespEntity(RespCode.WARN, "");
        }

    }

    @RequestMapping(value="queryOrderByUserId",method = RequestMethod.GET)
    @ResponseBody
    public RespEntity queryOrderByUserId(@Param("userId") int userId){
        List<OrderInfo> orderList  = orderService.queryOrderByUserId(userId);
        for(int i=0;i<orderList.size();i++){
            List<StoreInfo> storeInfos  = storeService.queryStoreInfoById(orderList.get(i).storeId);
            List<CarType> carTypes = carService.queryCarListById(orderList.get(i).carId );
            orderList.get(i).setStoreInfos(storeInfos);
            orderList.get(i).setCarTypes(carTypes);
        }
        return new RespEntity(RespCode.SUCCESS, orderList);
    }



}
