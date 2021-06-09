package com.leng.jadefine.service.impl;

import com.leng.jadefine.model.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * FileName:UserServiceImplTest
 * Author:fall
 * Date:2021/6/4 23:45
 * Description:
 */
class UserServiceImplTest {
    UserServiceImpl userService = new UserServiceImpl();

    @Test
    void addUser() {
        User user = new User();
        user.setUserName("桀骜炎枪");
        user.setPassword("122314");
        user.setRealName("哪吒");
        userService.addUser(user);
    }

    @Test
    void queryAll() {
        userService.queryAll();
    }

    @Test
    void queryById() {
        userService.queryById(1);
    }

    @Test
    void queryByUserName() {
        userService.queryByUserName("山林之子");
    }

    @Test
    void deleteUser() {
        userService.deleteUser(1);
    }

    @Test
    void updateUser() {
        User user = new User();
        user.setId(13);
        user.setUserName("玫瑰剑士");
        user.setPassword("000000");
        user.setRealName("李咯特");
        userService.updateUser(user);
    }

    @Test
    void saveUser() {
        User user = new User();
        user.setUserName("玫瑰剑士");
        user.setPassword("000000");
        user.setRealName("夏洛特");
        userService.saveUser(user);
    }
}