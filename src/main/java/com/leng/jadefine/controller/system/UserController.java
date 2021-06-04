package com.leng.jadefine.controller.system;

import com.leng.jadefine.model.User;
import com.leng.jadefine.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * FileName:UserController
 * Author:fall
 * Date:2021/5/29 22:54
 * Description:userController
 */
@Controller
@RequestMapping("/system/user")
public class UserController {

    @RequestMapping
    public void index(){};

    @Autowired
    @Qualifier("userService")
    UserServiceImpl userService;

    /*添加用户*/
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String addUser(User user,String name){
        System.out.println(user);
        userService.addUser(user);
        name = "success";
        return "/system/user/form";
    }

    /*根据用户名查询用户*/
    @RequestMapping("queryUserByUserName")
    public User queryUserByName(String username){
        return userService.queryByUserName(username);
    }

    /*读取user数据表*/
    @RequestMapping(value = "users",method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUsers(){
        return userService.queryAll();
    }
}
