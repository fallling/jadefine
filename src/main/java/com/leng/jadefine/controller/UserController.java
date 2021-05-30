package com.leng.jadefine.controller;

import com.leng.jadefine.mapper.UserMapper;
import com.leng.jadefine.model.User;
import com.leng.jadefine.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * FileName:UserController
 * Author:fall
 * Date:2021/5/29 22:54
 * Description:userController
 */
@RestController
@RequestMapping("user")
public class UserController {

    @RequestMapping("/")
    List<User> getUser(){
        SqlSession  sqlSession= MybatisUtil.getSqlSession();
        return sqlSession.getMapper(UserMapper.class).queryAll();
    }
}
