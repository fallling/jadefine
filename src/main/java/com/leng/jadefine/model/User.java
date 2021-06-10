package com.leng.jadefine.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
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

    @Size(max = 6,min = 6)
    private String password;
    private String realName;
    private String sex;
    private String address;

    @Email
    private String email;
    private int score;
    private Date regDate;
    private boolean status;
}
