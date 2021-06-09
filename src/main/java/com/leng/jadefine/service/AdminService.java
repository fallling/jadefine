package com.leng.jadefine.service;

import com.leng.jadefine.model.Admin;
import com.leng.jadefine.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * FileName:AdminService
 * Author:fall
 * Date:2021/6/5 17:42
 * Description:Admin Service
 */
public interface AdminService {
    List<Admin>  queryAll();

    Admin queryById(int id);

    Admin queryByUserName(String name);

    List<Admin> queryByRole(String role);

    void addAdmin(Admin admin);

    void deleteAdmin(int id);

    void updateAdmin(Admin admin);

    void saveAdmin(Admin admin);
}
