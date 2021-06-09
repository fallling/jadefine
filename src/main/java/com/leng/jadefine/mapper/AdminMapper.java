package com.leng.jadefine.mapper;

import com.leng.jadefine.model.Admin;
import com.leng.jadefine.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * FileName:AdminMapper
 * Author:fall
 * Date:2021/6/5 17:40
 * Description:Admin Mapper
 */
@Mapper
public interface AdminMapper {
    @Select("select * from admin_info")
    List<Admin> queryAll();

    @Select("select * from admin_info where id=#{id}")
    Admin queryById(@Param("id") int id);

/*    @Select("select * from admin_info where name=#{name}")
    List<Admin> queryByName(@Param("name") String name);*/

    @Select("select * from admin_info where userName=#{userName}")
    Admin queryByUserName(@Param("userName") String userName);

    @Select("select * from admin_info where role=#{role}")
    List<Admin> queryByRole(@Param("role") String role);

    @Insert("insert into admin_info(userName,password,role) values(#{userName},#{password},#{role})")
    void addAdmin(Admin admin);

    @Delete("delete from admin_info where id=#{id}")
    void deleteAdmin(@Param("id") int id );

    @Update("update admin_info set userName=#{userName},password=#{password},role=#{role} where id=#{id}")
    void updateAdmin(Admin admin);
}