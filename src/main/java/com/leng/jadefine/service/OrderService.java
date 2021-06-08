package com.leng.jadefine.service;

import com.leng.jadefine.model.Order;

import java.util.List;

/**
 * FileName:OrderService
 * Author:fall
 * Date:2021/6/6 0:44
 * Description:OrderService
 */


public interface OrderService {

    List<Order> queryAll();

    Order queryById(int id);

    void addOrder(Order order);

    /*删除订单 @Param id*/
    void deleteOrder(int id);

    /*更新订单 @Param order*/
    void updateOrder(Order order);

    void saveOrder(Order order);
}
