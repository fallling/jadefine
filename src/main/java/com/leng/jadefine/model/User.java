package com.leng.jadefine.model;

import lombok.Data;

import java.sql.Date;

/**
 * FileName:User
 * Author:fall
 * Date:2021/5/28 22:57
 * Description:User model
 */

@Data
public class User {
    private int id;
    private String userName;
    private String password;
    private String realName;
    private String sex;
    private String address;
    private String email;
    private int score;
    private Date regDate;
    private boolean status;
}
