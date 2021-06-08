package com.leng.jadefine.mapper;

import com.leng.jadefine.model.Order;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * FileName:OderMapper
 * Author:fall
 * Date:2021/6/6 0:11
 * Description:订单 Mapper
 */

@Mapper
public interface OrderMapper {

    @Select("select * from order_info")
    List<Order> queryAll();

    @Select("select * from order_info where id=#{id}")
    Order queryById(@Param("id") int id);

    @Select("select * from order_info where uid=#{uid}")
    List<Order> queryByUserId(@Param("uid") int uid);

    @Insert("insert into order_info(uid,status,orderPrice)values(#{uid},#{status},#{orderPrice})")
    void addOrder(Order order);

    @Delete("delete from order_info where id=#{id}")
    void deleteOrder(@Param("id") int id);

    @Delete("delete from order_info where uid=#{uid}")
    void deleteOrderByUserId(@Param("uid") int uid);

    @Update("update order_info set uid=#{uid},status=#{status},orderTime=#{orderTime},orderPrice=#{orderPrice} where id=#{id}")
    void updateOrder(Order order);
}
