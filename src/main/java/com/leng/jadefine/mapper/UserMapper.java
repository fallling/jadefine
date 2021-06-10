package com.leng.jadefine.mapper;

import com.leng.jadefine.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * FileName:UserMapper
 * Author:fall
 * Date:2021/5/28 23:01
 * Description:User Mapper
 */
@Mapper
public interface UserMapper {
    @Select("select * from user_info where id = #{id}")
    User queryById(@Param("id") int id);

    @Select("select * from user_info where userName = #{userName}")
    User queryByUserName(@Param("userName") String userName);

    @Select("select * from user_info")
    List<User> queryAll();

/*    @Insert("insert into user_info(userName, password, realName, sex, address, question, answer, email, favorite, score, regDate) \n" +
            "VALUES\n" +
            "(#{userName},#{password},#{realName},#{sex},#{address},#{question},#{answer},#{email},#{favorite},#{score},getDate())")
    void addUser(@Param("userName") String userName,@Param("password") String password,@Param("realName") String realName,
                @Param("sex") String sex, @Param("address") String address,@Param("question") String question,
                @Param("answer") String answer,@Param("email") String email,@Param("favorite") String favorite,
                @Param("score") int score);*/

    @Insert("insert into user_info(userName, password, realName, sex, address, email, score, status)VALUES (#{userName},#{password},#{realName},#{sex},#{address},#{email},#{score},#{status})")
    void addUser(User user);

    @Delete("delete from user_info where id=#{id}")
    void deleteUser(@Param("id") int id);

    @Update("update user_info set userName=#{userName},password=#{password},realName=#{realName},sex=#{sex},address=#{address},email=#{email},score=#{score},regDate=#{regDate},status=#{status} where id=#{id}")
    void updateUser(User user);
}
