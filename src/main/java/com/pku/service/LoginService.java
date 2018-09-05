package com.pku.service;

import com.pku.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Mapper
@Service

public interface LoginService {

    @Select("select * from userInfo where name =#{name}")
    UserInfo loginAction( String name , String password  );


    @Select("select * from userInfo where name =#{name} ")
   /* @Results({
            @Result(property = "name" , column = "name" )
    })*/
    UserInfo loginAction2( String name );


    @Insert("insert into userInfo(userId,name,password,phone,sendAddress0) values (#{userId},#{name},#{password},#{phone},#{sendAddress0})")
    boolean addUserAction(UserInfo userInfo);

}


