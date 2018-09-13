package com.pku.service;

import com.pku.domain.CarType;
import com.pku.domain.StoreInfo;
import com.pku.domain.UserInfo;
import org.apache.catalina.Store;
import org.apache.ibatis.annotations.*;
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

    @Delete("delete  from cartypeinfo where id = #{id}")
    Boolean delCarType(int id);

    @Select("select * from userInfo")
    List<UserInfo> queryUserInfo();

    @Delete("delete  from userInfo where userId = #{id}")
    Boolean delUserInfo(int id);

    @Update("update userInfo set name=#{name},email=#{email},locked=#{locked},phone=#{phone} where userId=#{userId}")
    Boolean updateUserInfo(UserInfo userInfo);

    @Select("select * from storeinfo")
    List<StoreInfo> queryStore(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize);

    @Insert("insert into storeinfo (storeId,storeName,storeAddress,storeStar,storePhone,storeAddressProvince,storeAddressCity,storeAddressArea)" +
            " values(#{storeId},#{storeName},#{storeAddress},#{storeStar},#{storePhone},#{storeAddressProvince},#{storeAddressCity},#{storeAddressArea})")
    Boolean addStore(StoreInfo storeInfo);

    @Delete("delete  from storeinfo where storeId = #{id}")
    Boolean delStore(String id);
}
