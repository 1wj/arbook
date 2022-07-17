package com.iweb.zq.classlnfo.service;

;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        Class_tService c = new Class_tServicelmpl();
       /* List<Class_t> list = c.queryAll();
        System.out.println(list);*/
      /*  Class_t cc= c.queryById("101");
        System.out.println(cc);*/
//       int i = c.saveOne(new Class_t("104","言情","热门小说","2020-04-20"));

//       int i = c.updateOne(new Class_t("104","言情1","热门小说1","2020-04-20"));
        int i=c.deleteOne("104");
         System.out.println(i);





    }
}
