package com.pku.controller;

import com.pku.domain.OrderInfo;
import com.pku.domain.RespCode;
import com.pku.domain.RespEntity;
import com.pku.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController

@RequestMapping({"/order"})
public class OrderController {
    @Autowired
    OrderService orderService ;

    @RequestMapping(value="/addOrder",method = RequestMethod.POST)
    @ResponseBody
    public RespEntity addOrder(@RequestBody OrderInfo orderInfo){
        Boolean result ;
        result  = orderService.addOrder(orderInfo);
        if(result){
            return new RespEntity(RespCode.SUCCESS, "");
        }else{
            return new RespEntity(RespCode.WARN, "");
        }

    }

    @RequestMapping(value="queryOrderByUserId",method = RequestMethod.GET)
    @ResponseBody
    public RespEntity queryOrderByUserId(){
        return new RespEntity(RespCode.SUCCESS, "");
    }

}
