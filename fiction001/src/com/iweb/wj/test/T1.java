package com.iweb.wj.test;

import com.iweb.wj.dao.impl.AdminDaoImpl;
import com.iweb.wj.model.Admin;
import com.iweb.wj.service.AdminService;
import com.iweb.wj.service.impl.AdminServiceImpl;
import com.iweb.wj.util.JdbcUtil;

import java.util.List;

public class T1 {
    public static void main(String[] args) {
        AdminService as=new AdminServiceImpl();
        // List<Admin> admins = as.queryALL();
        int i=as.saveOne(new Admin("004","小黑","125","小黑1","2021-07-26"));
        //int i=as.updateOne(new Admin("004","小黑hei","125","小黑hei1","2021-07-26"));
      //  Admin admin=as.queryByID("004");
        //boolean b=as.login("小王","12346")
        //int i=as.deleteOne("004");
        System.out.println(i);
       // AdminDaoImpl adminDao = new AdminDaoImpl();
       // JdbcUtil.updateBySql(adminDao.saveOne(new Admin("009","小黑","125","小黑1","2021-07-26")));
    }
}
