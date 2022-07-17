package com.iweb.wj.test;

import com.iweb.wj.model.History;
import com.iweb.wj.service.ClassifyService;
import com.iweb.wj.service.HistoryService;
import com.iweb.wj.service.impl.ClassifyServiceImpl;
import com.iweb.wj.service.impl.HistoryServiceImpl;

import java.util.List;

public class T2 {
    public static void main(String[] args) {
        HistoryService as=new HistoryServiceImpl();

        /* List<History> admins = as.queryALL();
        System.out.println(admins);*/

       /* int i=as.saveOne(new History("10","22","2021-07-26"));
        System.out.println(i);*/

      /*  int i=as.updateOne(new History("10","33","2021-07-26"),"22","2021-08-28","10");
        System.out.println(i);*/

       /*  List<History> admin=as.queryByID("10");
        System.out.println(admin);
*/

        /*int i=as.deleteOne("10","33");
        System.out.println(i);*/
    }
}
