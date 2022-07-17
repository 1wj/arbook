package com.iweb.wj.test;

import com.iweb.wj.model.Admin;
import com.iweb.wj.model.Vip;
import com.iweb.wj.service.AdminService;
import com.iweb.wj.service.VipService;
import com.iweb.wj.service.impl.AdminServiceImpl;
import com.iweb.wj.service.impl.VipServiceImpl;

import java.util.List;

public class T3 {
    public static void main(String[] args) {
        VipService as=new VipServiceImpl();
        /* List<Vip> admins = as.queryALL();
        System.out.println(admins);*/

      /*  int i=as.saveOne(new Vip("v4","2021-01-02",125,300,"12"));
        System.out.println(i);*/

      /*  int i=as.updateOne(new Vip("v4","2020-01-02",200,500,"12"));
        System.out.println(i);*/

        /* List<Vip> admin=as.queryByID("v4");
        System.out.println(admin);*/


        /*int i=as.deleteOne("v4");
        System.out.println(i);*/

    }
}
