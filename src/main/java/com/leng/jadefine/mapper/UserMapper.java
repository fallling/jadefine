package com.leng.jadefine.mapper;

import com.leng.jadefine.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * FileName:UserMapper
 * Author:fall
 * Date:2021/5/28 23:01
 * Description:User Mapper
 */
@Mapper
public interface UserMapper {
    @Select("select * from user where id = #{id}")
    User queryById(@Param("id") int id);

    @Select("select * from user")
    List<User> queryAll();
}
