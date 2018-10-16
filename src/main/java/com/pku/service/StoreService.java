package com.pku.service;

import com.pku.domain.CarType;
import com.pku.domain.StoreInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service
public interface StoreService {

    @Select("select * from storeinfo")
    List<StoreInfo> queryStoreInfo();

    @Select("select * from storeinfo where storeId = #{storeId}")
    List<StoreInfo> queryStoreInfoById(@Param("storeId") String storeId);

}
