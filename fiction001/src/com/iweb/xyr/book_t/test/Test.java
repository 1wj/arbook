package com.iweb.xyr.book_t.test;


import com.iweb.xyr.book_t.model.Book_t;
import com.iweb.xyr.book_t.service.BookService;
import com.iweb.xyr.book_t.service.BookServiceImpl;

import java.util.List;

public class Test {
    public static void main(String[] args) {

        BookService bs = new BookServiceImpl();
        List<Book_t> bt = bs.queryAll();
        System.out.print(bt);//查询全部

        /*BookService bs = new BookServiceImpl();
        int i=bs.saveOne(new Book_t("11","边界","名著","lisi","是",2000,"2000-1-30","上架","2021-03-21"));
        System.out.println(i);//新增*/

        /*BookService bs = new BookServiceImpl();
        int i=bs.updateOne(new Book_t("11","边城","不是名著","lisa","否",2500,"2000-1-21","没上架","2021-3-23"));
        System.out.println(i);//修改 */

        /*BookService bs = new BookServiceImpl();
        Book_t bt = bs.queryById("11");
        System.out.println(bt);// 查询*/

        /*BookService bs = new BookServiceImpl();
        int i = bs.deleteById("11");
        System.out.println(i);//删除*/

    }
}
