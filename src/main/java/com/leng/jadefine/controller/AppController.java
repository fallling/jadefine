package com.leng.jadefine.controller;

import com.leng.jadefine.model.Admin;
import com.leng.jadefine.model.User;
import com.leng.jadefine.service.impl.AdminServiceImpl;
import com.leng.jadefine.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import javax.servlet.http.HttpSession;

/**
 * FileName:AppController
 * Author:fall
 * Date:2021/6/9 15:06
 * Description:
 */

@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    private AdminServiceImpl adminService;
    @RequestMapping()
    public String index(@SessionAttribute(value = "admin",required = false) Admin admin){
        if(admin==null){
            return "login";
        }
        return "index";
    }

    @PostMapping("/login")
    public String login(@RequestParam String account, @RequestParam String password, HttpSession session){
        //User user = userService.queryByUserName(account);
        Admin admin = adminService.queryByUserName(account);
        if(admin != null){
            /*用户存在*/
            if(admin.getPassword().equals(password)){
                session.removeAttribute("error");
                session.setAttribute("admin",admin);
                return "redirect:/";
            }else
            {
                session.setAttribute("error","账号不存在");
                return "login";
            }
        }else{
            /*用户不存在*/
            session.setAttribute("error","账号不存在");
            return "login";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
