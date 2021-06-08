package com.leng.jadefine.model;

import lombok.Data;

/**
 * FileName:Product
 * Author:fall
 * Date:2021/6/5 22:54
 * Description:product empty
 */

@Data
public class Product {
    private int id;
    private String code;
    private String name;
    private String type;
    private String brand;
    private String pic;
    private int num;
    private double price;
    private String intro;
    private String status;
    private String bigPic;
}
