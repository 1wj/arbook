package com.iweb.xyr.receive_t.test;

import com.iweb.xyr.receive_t.model.Receive_t;
import com.iweb.xyr.receive_t.service.ReceiveService;
import com.iweb.xyr.receive_t.service.ReceiveServiceImpl;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        /*ReceiveService bs = new ReceiveServiceImpl();
        List<Receive_t> bt = bs.queryAll();
        System.out.print(bt);//查询全部*/

        /*ReceiveService bs = new ReceiveServiceImpl();
        int i=bs.saveOne(new Receive_t("10","1003"));
        System.out.println(i);//新增*/

        ReceiveService bs = new ReceiveServiceImpl();
        int i=bs.updateOne1(new Receive_t("10","1003"),"10","1002");
        System.out.println(i);//修改

        /*ReceiveService bs = new ReceiveServiceImpl();
        Receive_t mt = bs.queryById("11","1002");
        System.out.println(mt);// 查询*/

        /*ReceiveService bs = new ReceiveServiceImpl();
        int i = bs.deleteById("10","1003");
        System.out.println(i);//删除*/
    }
}
