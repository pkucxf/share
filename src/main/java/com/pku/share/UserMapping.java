package com.pku.share;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapping {

    @Select("select * from user where name = #{name}")
    List<User> findUserByName(String name);
}
