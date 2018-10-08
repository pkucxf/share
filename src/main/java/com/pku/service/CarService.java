package com.pku.service;

import com.pku.domain.CarType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service
public interface CarService {

    @Select("select *  from cartypeinfo ")
    List<CarType> queryCarList();

}
