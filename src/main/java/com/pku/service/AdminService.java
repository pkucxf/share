package com.pku.service;

import com.pku.domain.*;
import org.apache.catalina.Store;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Mapper
@Service
public interface AdminService {

    @Select("select * from adminUserInfo where userName = #{userName} and password = #{password}")
    List<AdminUserInfo> queryAdminUser(AdminUserInfo adminUserInfo);

    @Select("select storeId from storeInfo where storePhone = #{userName}")
    String queryStoreInfo(@Param("userName") String userName );


    @Select("select * from cartypeinfo LIMIT #{pageNo},#{pageSize}")
    List<CarType> queryCarType(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize);

    @Select("select id , carName from cartypeinfo ")
    @Results({
            @Result(property ="id" ,column ="id"),
            @Result(property ="carName" ,column ="carName")
    })
    List<CarType> queryCarList();

    @Select("select storeId,storeName from storeinfo")
    @Results({
            @Result(property ="storeId" ,column ="storeId"),
            @Result(property ="storeName" ,column ="storeName")
    })
    List<StoreInfo> queryStoreList();

    @Insert("insert cartypeinfo (carName , carProduce , carDrive ,carTypes,carSeat ,def0 ,img) values (#{carName} , #{carProduce} , #{carDrive} ,#{carTypes},#{carSeat},#{def0},#{img}) ")
    Boolean addCarType(CarType carType);

    @Delete("delete  from cartypeinfo where id = #{id}")
    Boolean delCarType(int id);

    @Update("update cartypeinfo set carName =#{carName} , carProduce =#{carProduce},carDrive=#{carDrive}, carTypes =#{carTypes} ,carSeat=#{carSeat} ,def0 = #{def0} , img =#{img } where id=#{id}")
    Boolean updateCarType(CarType carType);

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

    @Select("select * from carandstoreinfo")
    List<CarAndStore> queryCarAndStore(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize);

    /*@Insert("insert into carandstoreinfo (id,storeId,storeName,carId,carName,carNum,carImg)" +
            "values(#{id},#{storeId},#{storeName},#{carId},#{carName},#{carNum},#{carImg} )")*/
    @Insert("insert into carandstoreinfo (storeName,storeId,carName,carId,carNum,def0)" +
            "values(#{storeName},#{storeId},#{carName},#{carId},#{carNum},#{carPrice} )")
    Boolean addCarAndStore(@Param("storeName") String storeName,@Param("storeId") String storeId,
                           @Param("carName") String carName ,@Param("carId") String carId,@Param("carNum") int carNum, @Param("carPrice") String carPrice);

    @Delete("delete from carandstoreinfo where id = #{id}")
    Boolean delCarAndStore(String id );


    @Insert("insert into adminUserInfo (userName,password,userType) values (#{userName},#{password},1) ")
    Boolean insertToAdmin(@Param("userName") String userName , @Param("password") String password);

    @Select ("select * from adminUserInfo where userName = #{userName}")
    List<AdminUserInfo> selectUser(@Param("userName") String userName );

    @Select("select * from orderInfo order by orderTime desc")
    List<OrderInfo> queryAllOrderList();

    @Select("select * from orderInfo where payStatu=#{payStatu} order by orderTime desc")
    List<OrderInfo> queryAllOrderByPaystatu(@Param("payStatu") int payStatu );

    @Select("select * from orderInfo where payStatu=#{payStatu} and storeId =#{storeId} order by orderTime desc")
    List<OrderInfo> queryAllOrderByPaystatu2(@Param("payStatu") int payStatu , @Param("storeId")  String storeId);

    @Select("select * from orderInfo where  storeId = #{storeId} order by orderTime desc")
    List<OrderInfo> queryAllOrderByStoreId( @Param("storeId") String storeId);


    @Select("select * from storeinfo where storeId = #{storeId}")
    List<StoreInfo> queryStoreInfoById(@Param("storeId") String storeId);


    @Select("select *  from cartypeinfo where id = #{id}")
    List<CarType> queryCarListById(@Param("id") int id );

    @Update("update orderInfo set payStatu = #{payStatu} where id = #{id}")
    Boolean sureOrder(@Param("payStatu") int payStatu , @Param("id") int id ) ;
}
