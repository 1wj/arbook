package com.iweb.wj.test;

import com.iweb.wj.model.Classify;
import com.iweb.wj.service.ClassifyService;
import com.iweb.wj.service.ReadVipBook;
import com.iweb.wj.service.VipService;
import com.iweb.wj.service.impl.ClassifyServiceImpl;
import com.iweb.wj.service.impl.ReadVipBookImpl;
import com.iweb.wj.service.impl.VipServiceImpl;

import java.util.List;

public class T4 {
    public static void main(String[] args) {
        ClassifyService as=new ClassifyServiceImpl();
        ReadVipBook readVipBook=new ReadVipBookImpl();
       /*  List<Classify> admins = as.queryALL();
        System.out.println(admins);*/

       /* int i=as.saveOne(new Classify("22","102"));
        System.out.println(i);*/

      /*  int i=as.updateOne(new Classify("22","102"),"44","102");
        System.out.println(i);
*/
         /*List<Classify> admin=as.queryByID("44");
        System.out.println(admin);*/


       /* int i=as.deleteOne("44","102");
        System.out.println(i);*/
        Boolean aBoolean = readVipBook.readVipBook("22", "10");
        System.out.println(aBoolean);

    }
}
