package com.leng.jadefine.controller.system;

import com.leng.jadefine.conmmon.JsonResult;
import com.leng.jadefine.model.Order;
import com.leng.jadefine.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * FileName:orderController
 * Author:fall
 * Date:2021/6/8 20:31
 * Description:订单 controller
 */

@Controller
@RequestMapping("/system/order")
public class OrderController {
    
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
            Order order = orderService.queryById(id);
            model.addAttribute("Order",order);
        }
        return "/system/order/form";
    }

    @PostMapping("list")
    @ResponseBody
    public List<Order> list(){
        return orderService.queryAll();
    }

    @PostMapping({"save","update"})
    @ResponseBody
    public JsonResult from(@Valid Order order, BindingResult bindingResult){
        System.out.println(order);
        orderService.saveOrder(order);
        return JsonResult.success();
    }

    @GetMapping("delete")
    @ResponseBody
    public JsonResult delete(int id){
        System.out.println(id);
        Order Order = orderService.queryById(id);
        if(Order!=null){
            orderService.deleteOrder(id);
            return JsonResult.success();
        }else {
            return JsonResult.error();
        }
    }
}
