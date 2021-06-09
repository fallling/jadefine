package com.leng.jadefine.service.impl;

import com.leng.jadefine.mapper.AdminMapper;
import com.leng.jadefine.model.Admin;
import com.leng.jadefine.model.User;
import com.leng.jadefine.service.AdminService;
import com.leng.jadefine.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * FileName:AdminServiceImpl
 * Author:fall
 * Date:2021/6/5 17:44
 * Description:AdminService 实现类
 */

@Service
@Component("adminService")
public class AdminServiceImpl implements AdminService {

    @Override
    public List<Admin> queryAll() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
        List<Admin> adminList = adminMapper.queryAll();
        sqlSession.close();
        return adminList;
    }

    @Override
    public Admin queryById(int id) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
        Admin admin = adminMapper.queryById(id);
        sqlSession.close();;
        return admin;
    }

    @Override
    public Admin queryByUserName(String name) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
        Admin admin = adminMapper.queryByUserName(name);
        sqlSession.close();
        return admin;
    }

    @Override
    public List<Admin> queryByRole(String role) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
        List<Admin> adminList = adminMapper.queryByRole(role);
        sqlSession.close();
        return adminList;
    }

    @Override
    public void addAdmin(Admin admin) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
        adminMapper.addAdmin(admin);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteAdmin(int id) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
        adminMapper.deleteAdmin(id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void updateAdmin(Admin admin) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
        adminMapper.updateAdmin(admin);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void saveAdmin(Admin admin) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
        Admin admin1 = adminMapper.queryById(admin.getId());
        if(admin1 != null){
            adminMapper.updateAdmin(admin);
        }else{
            adminMapper.addAdmin(admin);
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
