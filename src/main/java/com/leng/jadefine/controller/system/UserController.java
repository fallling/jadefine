package com.leng.jadefine.controller.system;

import com.leng.jadefine.conmmon.JsonResult;
import com.leng.jadefine.model.Order;
import com.leng.jadefine.model.Product;
import com.leng.jadefine.model.User;
import com.leng.jadefine.service.impl.AdminServiceImpl;
import com.leng.jadefine.service.impl.OrderServiceImpl;
import com.leng.jadefine.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * FileName:UserController
 * Author:fall
 * Date:2021/5/29 22:54
 * Description:userController
 */
@Controller
@RequestMapping("/system/user")
public class UserController {
    @Autowired
    @Qualifier("userService")
    private UserServiceImpl userService;

    @Autowired
    @Qualifier("orderService")
    private OrderServiceImpl orderService;

    @RequestMapping
    public void index(){
    }

    @RequestMapping({"form","load"})
    public String form(Integer id, Model model){
        if(id!=null){
            /*编辑*/
            User user = userService.queryById(id);
            model.addAttribute("user",user);
        }
        return "/system/user/form";
    }

    @PostMapping("list")
    @ResponseBody
    public List<User> list(Integer id){
        if(id!=null){
            User user = userService.queryById(id);
            List<User> userList = new ArrayList<User>();
            userList.add(user);
            return userList;
        }
        return userService.queryAll();
    }

    @PostMapping({"save","update"})
    @ResponseBody
    public JsonResult from(@Valid User user){
        User user1=userService.queryByUserName(user.getUserName());
        System.out.println(user1);
        if(user1!=null){
            System.out.println("用户名重复");
            return JsonResult.error("用户名重复");
        }
        System.out.println(user);
        userService.saveUser(user);
        return JsonResult.success();
    }

    @GetMapping("delete")
    @ResponseBody
    public JsonResult delete(int id){
        User user = userService.queryById(id);
        if(user!=null){
            userService.deleteUser(id);
            return JsonResult.success();
        }else {
            return JsonResult.error();
        }
    }
}
