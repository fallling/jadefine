package com.leng.jadefine.service.impl;

import com.leng.jadefine.mapper.OrderMapper;
import com.leng.jadefine.mapper.OrderDetailMapper;
import com.leng.jadefine.model.Order;
import com.leng.jadefine.service.OrderService;
import com.leng.jadefine.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * FileName:OrderServiceImpl
 * Author:fall
 * Date:2021/6/6 1:18
 * Description:OrderService 实现类
 */

@Service
@Component("orderService")
public class OrderServiceImpl implements OrderService {

    @Override
    public List<Order> queryAll() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> orderList = orderMapper.queryAll();
        sqlSession.close();
        return orderList;
    }

    @Override
    public Order queryById(int id) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Order order = orderMapper.queryById(id);
        sqlSession.close();
        return order;
    }

    @Override
    public List<Order> queryByUserId(int userId){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> orderList = orderMapper.queryByUserId(userId);
        sqlSession.commit();
        sqlSession.close();
        return orderList;
    }
    @Override
    public void addOrder(Order order) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        orderMapper.addOrder(order);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteOrder(int id) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

        Order order = orderMapper.queryById(id);
        if(order!=null){
            /*删除子表*/
            SqlSession sqlSession1 = MybatisUtil.getSqlSession();
            OrderDetailMapper orderDetailMapper = sqlSession1.getMapper(OrderDetailMapper.class);
            orderDetailMapper.deleteOrderDetailByOrderId(order.getId());
            sqlSession1.commit();
            sqlSession1.close();

            /*删除数据*/
            orderMapper.deleteOrder(id);
            sqlSession.commit();
        }
        sqlSession.close();
    }

    @Override
    public void updateOrder(Order order) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        orderMapper.updateOrder(order);

        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void saveOrder(Order order) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        OrderMapper OrderMapper = sqlSession.getMapper(OrderMapper.class);
        Order order1 = OrderMapper.queryById(order.getId());
        if(order1 != null){
            OrderMapper.updateOrder(order);
        }else{
            OrderMapper.addOrder(order);
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
