package com.leng.jadefine.service.impl;

import com.leng.jadefine.model.Admin;
import com.leng.jadefine.model.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * FileName:AdminServiceImplTest
 * Author:fall
 * Date:2021/6/5 17:48
 * Description:
 */
class AdminServiceImplTest {

    AdminServiceImpl adminService = new AdminServiceImpl();
    @Test
    void queryAll() {
        List<Admin> adminList = adminService.queryAll();
        System.out.println(adminList);
    }

    @Test
    void queryById() {
        Admin admin = adminService.queryById(1);
        System.out.println(admin);
    }

    @Test
    void queryByName() {
        List<Admin> adminList = adminService.queryByName("马超");
        System.out.println(adminList);
    }

    @Test
    void queryByRole() {
        List<Admin> adminList = adminService.queryByRole("管理员");
        System.out.println(adminList);
    }

    @Test
    void addAdmin() {
        Admin admin = new Admin();
        admin.setName("曜");
        admin.setPwd("123456");
        admin.setRole("管理员");
        adminService.addAdmin(admin);
    }

    @Test
    void deleteAdmin() {
        Admin admin = new Admin();
        admin.setId(1);
        admin.setName("马超");
        admin.setPwd("123456");
        admin.setRole("管理员");
        adminService.deleteAdmin(1);
    }

    @Test
    void updateAdmin() {
        //System.out.println(adminService.queryById(1));
        Admin admin = new Admin();
        admin.setId(1);
        admin.setName("李四");
        admin.setPwd("112345");
        admin.setRole("管理员");
        //System.out.println(admin);
        adminService.updateAdmin(admin);
    }
}