package com.leng.jadefine.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * FileName:MybatisUtil
 * Author:fall
 * Date:2021/5/29 20:44
 * Description:mybatis 工具类
 */
public class MybatisUtil {
   private static SqlSessionFactory sqlSessionFactory;

   static {

       try {
           String resource = "mybatis-config.xml";
           InputStream inputStream = Resources.getResourceAsStream(resource);
           sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

   /*获取SqlSession*/
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
}
