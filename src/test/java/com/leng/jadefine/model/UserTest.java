package com.leng.jadefine.model;

import com.leng.jadefine.mapper.UserMapper;
import com.leng.jadefine.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * FileName:UserTest
 * Author:fall
 * Date:2021/5/29 20:56
 * Description:
 */
class UserTest {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.queryAll();

        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }
}