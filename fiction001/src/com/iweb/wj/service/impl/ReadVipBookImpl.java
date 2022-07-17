package com.iweb.wj.service.impl;



import com.iweb.xyr.book_t.dao.BookDao;
import com.iweb.xyr.book_t.dao.BookDaoImpl;
import com.iweb.xyr.book_t.model.Book_t;
import com.iweb.xyr.book_t.service.BookService;
import com.iweb.xyr.book_t.service.BookServiceImpl;
import com.iweb.zq.userlnfo.model.User_t;
import com.iweb.zq.userlnfo.service.User_tService;
import com.iweb.zq.userlnfo.service.User_tServicelmpl;

import java.awt.print.Book;

public class ReadVipBookImpl implements com.iweb.wj.service.ReadVipBook {




    @Override
    public Boolean readVipBook(String bookId, String useId) {
        BookService bookService=new BookServiceImpl();
        User_tService user_tService=new User_tServicelmpl();

        Book_t book_t = bookService.queryById(bookId);
        String isvip = book_t.getIsvip();
        //先判断是否是会员书籍
        if("是".equals(isvip)){
            //如果是再判断是否是会员
            User_t user_t = user_tService.queryById(useId);
            String remaindays = user_t.getRemaindays();
            Double i=Double.valueOf(remaindays);
            if(i!=0){
                return true;
            }else
                return false;
        }
        //如果不是则返回false
        return true;
    }
}
