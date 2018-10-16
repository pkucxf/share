package com.pku.service;

import com.pku.domain.CarType;
import com.pku.domain.OrderInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service
public interface OrderService {


    @Insert("insert into orderInfo (carId,userId,storeId,startTime,endTime,orderMoney,orderTime,day) values " +
            " (#{carId},#{userId},#{storeId},#{startTime},#{endTime},#{orderMoney},#{orderTime},#{day})")
    Boolean addOrder(OrderInfo orderInfo);


    @Select("select * from orderInfo where userId =#{userId}")
    List<OrderInfo> queryOrderByUserId(@Param("userId") int userId);

}
