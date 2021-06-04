package com.leng.jadefine.service.impl;

import com.leng.jadefine.mapper.UserMapper;
import com.leng.jadefine.model.User;
import com.leng.jadefine.service.UserService;
import com.leng.jadefine.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * FileName:UserServiceImpl
 * Author:fall
 * Date:2021/6/1 10:50
 * Description:UserService 的实现类
 */
@Service
@Component("userService")
public class UserServiceImpl implements UserService {
    @Override
    public List<User> queryAll() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        return userMapper.queryAll();
    }

    @Override
    public User queryById(int id) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        return userMapper.queryById(id);
    }

    @Override
    public User queryByUserName(String userName) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        return userMapper.queryByUserName(userName);
    }

    @Override
    public void addUser(User user) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.addUser(user);
    }
}
