package com.leng.jadefine.model;

import lombok.Data;

/**
 * FileName:Admin
 * Author:fall
 * Date:2021/6/5 17:39
 * Description:Admin model
 */
@Data
public class Admin {
    private int id;
    private String name;
    private String pwd;
    private String role;
}
