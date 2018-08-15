package com.pku.service;

import com.pku.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Mapper
@Service

public interface LoginService {

    @Select("select * from userInfo where name =#{name} ")
    @Results({
            @Result(property = "name" , column = "name" )
    })
    List<UserInfo> loginAction( String name , String password);

}


