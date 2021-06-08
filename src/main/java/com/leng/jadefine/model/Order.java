package com.leng.jadefine.model;

import lombok.Data;

import java.util.Date;

/**
 * FileName:Oder
 * Author:fall
 * Date:2021/6/5 23:40
 * Description:订单
 */
@Data
public class Order {

    /*订单id*/
    private int id;

    /*用户id*/
    private int uid;

    /*订单状态*/
    private String status;

    /*订单时间*/
    private Date orderTime;

    /*订单价格*/
    private Double orderPrice;
}
