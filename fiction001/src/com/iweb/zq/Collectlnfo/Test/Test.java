package com.iweb.zq.Collectlnfo.Test;

import com.iweb.zq.Collectlnfo.Service.Collect_tService;
import com.iweb.zq.Collectlnfo.Service.Collect_tServicelmpl;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        Collect_tService co = new Collect_tServicelmpl();
   /*     List<Collect_t> list = co.queryAll();
        System.out.println(list);*/
//        Collect_t c = co.queryById("22","10","2020-02-02");
//        int i = co.saveOne(new Collect_t("22","11","2010-2-10"));
//        int i = co.updateOne(new Collect_t("22","11","2010-2-10"),"22","11","2011-3-10");
          int i = co.deleteOne("22","11","2011-3-10");
        System.out.println(i);


    }
}
