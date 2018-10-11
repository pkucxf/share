package com.pku.service;

import com.pku.domain.CarAndStore;
import com.pku.domain.CarType;
import com.pku.domain.StoreInfo;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service
public interface DrivingService {

    @Select("select * from carandstoreinfo")
    List<CarAndStore> queryCarAndStore();

    @Select("select * from cartypeinfo where id =#{id}")
    List<CarType>  queryCarType(@Param("id") String id );


    @Select("select * from storeinfo where storeId = #{storeId}")
    List<StoreInfo> queryStore(@Param("storeId") String storeId);


    @Select("select def0 from carandstoreinfo where id = #{id}")
    String queryPrice(@Param("id") int id );
}
