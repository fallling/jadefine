package com.leng.jadefine.mapper;

import com.leng.jadefine.model.OrderDetail;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * FileName:OrderDetailMapper
 * Author:fall
 * Date:2021/6/6 12:47
 * Description:订单详情 Mapper
 */

@Mapper
public interface OrderDetailMapper {

    @Select("select * from order_detail")
    List<OrderDetail> queryAll();

    @Select("select * from order_detail where id = #{id}")
    OrderDetail queryById(@Param("id") int id);

    @Select("select * from order_detail where oid = #{oid}")
    List<OrderDetail> queryByOrderId(@Param("oid") int oid);

    @Select("select * from order_detail where pid = #{pid}")
    List<OrderDetail> queryByProductId(@Param("pid") int pid);

    @Insert("insert into order_detail(oid,pid,num)values(#{oid},#{pid},#{num})")
    void addOrderDetail(OrderDetail orderDetail);

    @Delete("delete from order_detail where id=#{id}")
    void deleteOrderDetail(@Param("id") int id);

    @Delete("delete from order_detail where oid=#{oid}")
    void deleteOrderDetailByOrderId(@Param("oid") int oid);

    @Delete("delete from order_detail where pid=#{pid}")
    void deleteOrderDetailByProductId(@Param("pid") int pid);

    @Update("update order_detail set oid=#{oid},pid=#{pid},num=#{num} where id=#{id}")
    void updateOrderDetail(OrderDetail orderDetail);
}
