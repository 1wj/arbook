package com.iweb.xyr.book_t.service;





import com.iweb.xyr.book_t.dao.BookDao;
import com.iweb.xyr.book_t.dao.BookDaoImpl;
import com.iweb.xyr.book_t.model.Book_t;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookDao bookdao = new BookDaoImpl();

    @Override
    public int saveOne(Book_t b) {
        return bookdao.saveOne(b);
    }

    @Override
    public int updateOne(Book_t b) {
        return bookdao.updateOne(b);
    }

    @Override
    public int deleteById(String bid) {
        return bookdao.deleteById(bid);
    }

    @Override
    public Book_t queryById(String bid) {
        return bookdao.queryById(bid);
    }

    @Override
    public List<Book_t> queryAll() {
        return bookdao.queryAll();
    }
}
