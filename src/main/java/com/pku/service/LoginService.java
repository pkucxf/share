package com.pku.service;

import com.pku.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Mapper
@Service

public interface LoginService {

    @Select("select * from userInfo where name =#{name} and password =#{password} ")
    boolean loginAction(UserInfo userInfo );


    @Insert("insert into userInfo(userId,name,password,phone,sendAddress0) values (#{userId},#{name},#{password},#{phone},#{sendAddress0})")
    boolean addUserAction(UserInfo userInfo);


    @Select("select *  from userInfo where name = #{name}")
    List<UserInfo> hasUser(@Param("name") String name);

}


