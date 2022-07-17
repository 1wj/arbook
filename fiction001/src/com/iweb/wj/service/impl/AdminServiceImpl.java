package com.iweb.wj.service.impl;



import com.iweb.wj.dao.AdminDao;
import com.iweb.wj.dao.impl.AdminDaoImpl;
import com.iweb.wj.model.Admin;
import com.iweb.wj.service.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao = new AdminDaoImpl();

    @Override
    public int saveOne(Admin admin) {
        return adminDao.saveOne(admin);
    }

    @Override
    public int updateOne(Admin admin) {
        return adminDao.updateOne(admin);
    }

    @Override
    public int deleteOne(String adminId) {
        return adminDao.deleteOne(adminId);
    }

    @Override
    public Admin queryByID(String adminId) {
        return adminDao.queryByID(adminId);
    }

    @Override
    public List<Admin> queryALL() {
        return adminDao.queryALL();
    }

    //管理员登录
    public boolean login(String manageruserName, String managerPassword) {
        int result = adminDao.queryByUserNamePasswd(manageruserName, managerPassword);
        if (result == 1) return true;
        else return false;

    }
}
