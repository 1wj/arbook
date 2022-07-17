package com.iweb.zq.userlnfo.Test;

import com.iweb.zq.userlnfo.model.User_t;
import com.iweb.zq.userlnfo.service.User_tService;
import com.iweb.zq.userlnfo.service.User_tServicelmpl;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        User_tService u = new User_tServicelmpl() ;

        List<User_t> list = u.queryAll();
        System.out.println(list);

//        User_t user = u.queryById("10");
//        System.out.println(user);

//       int i = u.saveOne(new User_t("31","exciting","123456","兴奋","001","100",20 ));
//      int i = u.updateOne(new User_t("31","exciting1","1234567","兴奋1","002","1001",201 ));
       int i=u.deleteOne("30");
       System.out.println(i);

       //      用户登录
        boolean b=u.login("sad","123456");
        System.out.println(b);






    }
}
