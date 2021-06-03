package com.leng.jadefine.controller;

import com.leng.jadefine.model.User;
import com.leng.jadefine.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * FileName:IndexController
 * Author:fall
 * Date:2021/6/1 22:05
 * Description:默认界面控制器
 */

@Controller
public class IndexController {

    @Autowired
    @Qualifier("userService")
    UserServiceImpl userService;

    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "/login";
    }

    @PostMapping("/login")
    public String main(User user){
        User user1 = userService.queryByUserName(user.getUserName());
        if(user1 != null){
            if(user1.getPassword().equals(user.getPassword())){
                return "index";
            }else return "error";
        }else{
            return "error";
        }
    }

    @GetMapping("index")
    public String mainPage(){
        return "index";
    }
}