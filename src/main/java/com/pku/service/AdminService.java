package com.pku.service;

import com.pku.domain.CarType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Mapper
@Service
public interface AdminService {

    @Select("select * from cartypeinfo LIMIT #{pageNo},#{pageSize}")
    List<CarType> queryCarType(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize);

    @Insert("insert cartypeinfo (carName , carProduce , carDrive ,carTypes,carSeat) values (#{carName} , #{carProduce} , #{carDrive} ,#{carTypes},#{carSeat}) ")
    Boolean addCarType(CarType carType);
}
