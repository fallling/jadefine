package com.leng.jadefine.service.impl;

import com.leng.jadefine.model.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * FileName:OrderServiceImplTest
 * Author:fall
 * Date:2021/6/6 1:25
 * Description:
 */
class OrderServiceImplTest {
    OrderServiceImpl orderService = new OrderServiceImpl();
    @Test
    void queryAll() {
        System.out.println( orderService.queryAll());

    }

    @Test
    void queryById() {
        orderService.queryById(1);
    }

    @Test
    void addOrder() {
        Order order = new Order();
        order.setUid(1);
        order.setStatus("待发货");
        order.setOrderPrice(1280.0);
        orderService.addOrder(order);
    }

    @Test
    void deleteOrder() {
        orderService.deleteOrder(2);
    }

    @Test
    void updateOrder() {
        Order order = new Order();
        order.setId(1);
        order.setUid(3);
        order.setStatus("待发货");
        order.setOrderPrice(1280.0);
        orderService.updateOrder(order);
    }
}