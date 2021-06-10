package com.leng.jadefine.controller.system;

import com.leng.jadefine.conmmon.JsonResult;
import com.leng.jadefine.model.Order;
import com.leng.jadefine.model.Product;
import com.leng.jadefine.model.User;
import com.leng.jadefine.service.impl.OrderServiceImpl;
import com.leng.jadefine.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.ArrayList;
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
        System.out.println(user);
        userService.saveUser(user);
        return JsonResult.success();
    }

    @GetMapping("delete")
    @ResponseBody
    public JsonResult delete(int id){
        System.out.println(id);
        User user = userService.queryById(id);
        if(user!=null){
            List<Order> orderList = orderService.queryByUserId(user.getId());
            if(orderList!=null){
                return JsonResult.error("该用户存在未完成订单，不可删除");
            }
            userService.deleteUser(id);
            return JsonResult.success();
        }else {
            return JsonResult.error();
        }
    }
}
