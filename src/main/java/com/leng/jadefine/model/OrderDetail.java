package com.leng.jadefine.model;

import lombok.Data;

/**
 * FileName:OderDetail
 * Author:fall
 * Date:2021/6/5 23:43
 * Description:订单详情
 */

@Data
public class OrderDetail {
    /*订单详情id*/
    private int id;

    /*订单id*/
    private int oid;

    /*商品id*/
    private int pid;

    /*购买数量*/
    private int num;
}
