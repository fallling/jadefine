package com.leng.jadefine.controller.system;

import com.leng.jadefine.conmmon.JsonResult;
import com.leng.jadefine.model.Admin;
import com.leng.jadefine.service.impl.AdminServiceImpl;
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
import java.util.ArrayList;
import java.util.List;

/**
 * FileName:AdminController
 * Author:fall
 * Date:2021/6/7 1:16
 * Description:管理员 controller
 */
@Controller
@RequestMapping("/system/admin")
public class AdminController {

    @Autowired
    @Qualifier("adminService")
    private AdminServiceImpl adminService;


    @RequestMapping
    public void index(){
    }

    @RequestMapping({"form","load"})
    public String form(Integer id, Model model){
        if(id!=null){
            /*编辑*/
            Admin admin = adminService.queryById(id);
            model.addAttribute("admin",admin);
        }
        return "/system/admin/form";
    }

    @PostMapping("list")
    @ResponseBody
    public List<Admin> list(Integer id){
        if(id!=null){
            Admin admin = adminService.queryById(id);
            List<Admin> adminList = new ArrayList<>();
            adminList.add(admin);
            return adminList;
        }
        return adminService.queryAll();
    }

    @PostMapping({"save","update"})
    @ResponseBody
    public JsonResult from(@Valid Admin admin, BindingResult bindingResult){
        System.out.println(admin);
        adminService.saveAdmin(admin);
        return JsonResult.success();
    }

    @GetMapping("delete")
    @ResponseBody
    public JsonResult delete(int id){
        System.out.println(id);
        Admin admin = adminService.queryById(id);
        if(admin!=null){
            adminService.deleteAdmin(id);
            return JsonResult.success();
        }else {
            return JsonResult.error();
        }
    }
}
