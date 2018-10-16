package com.pku.service;

import com.pku.domain.CarType;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service
public interface CarService {

    @Select("select *  from cartypeinfo ")
    List<CarType> queryCarList();

    @Select("select *  from cartypeinfo where id = #{id}")
    List<CarType> queryCarListById(@Param("id") int id );

}
