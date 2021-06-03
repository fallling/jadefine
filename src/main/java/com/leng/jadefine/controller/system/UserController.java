package com.leng.jadefine.controller.system;

import com.leng.jadefine.model.User;
import com.leng.jadefine.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

/*    @RequestMapping(value = "userlist",method = RequestMethod.GET)
    public ModelAndView userlist(){
        return new ModelAndView("userlist");
    }*/

    //读取user数据表
    @RequestMapping(value = "/users",method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUsers(){
        return userService.queryAll();
    }
}
