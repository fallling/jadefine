/*
package com.leng.jadefine.controller;

import com.leng.jadefine.model.User;
import com.leng.jadefine.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;

*/
/**
 * FileName:IndexController
 * Author:fall
 * Date:2021/6/1 22:05
 * Description:默认界面控制器
 *//*


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
                return "redirect:/index";
            }else return "error";
        }else{
            return "error";
        }
    }

    @GetMapping("/index")
    public String mainPage(HttpServletRequest request){
        return "/index";
    }
}*/
