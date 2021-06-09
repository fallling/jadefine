package com.leng.jadefine.service.impl;

import com.leng.jadefine.mapper.OrderMapper;
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
        List<User> userList = userMapper.queryAll();
        sqlSession.close();
        return userList;
    }

    @Override
    public User queryById(int id) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.queryById(id);
        sqlSession.close();
        return user;
    }

    @Override
    public User queryByUserName(String userName) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.queryByUserName(userName);
        sqlSession.close();
        return user;
    }

    @Override
    public void addUser(User user) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.addUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteUser(int id){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.queryById(id);
        if(user!=null){
            /*删除子表数据*/
            SqlSession sqlSession1 = MybatisUtil.getSqlSession();
            OrderMapper orderMapper = sqlSession1.getMapper(OrderMapper.class);
            orderMapper.deleteOrderByUserId(id);
            sqlSession1.commit();
            sqlSession1.close();

            /*删除数据*/
            userMapper.deleteUser(id);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void updateUser(User user) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.updateUser(user);

        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void saveUser(User user){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user1 = userMapper.queryById(user.getId());
        if(user1!=null){
            userMapper.updateUser(user);
        }else
            userMapper.addUser(user);

        sqlSession.commit();
        sqlSession.close();
    }


}
