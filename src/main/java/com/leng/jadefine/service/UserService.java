package com.leng.jadefine.service;

import com.leng.jadefine.mapper.UserMapper;
import com.leng.jadefine.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * FileName:UserService
 * Author:fall
 * Date:2021/6/1 10:42
 * Description:The Service for User
 */

public interface UserService {
    List<User> queryAll();
    User queryById(int id);
    User queryByUserName(String userName);
}
