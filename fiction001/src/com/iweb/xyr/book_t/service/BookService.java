package com.iweb.xyr.book_t.service;




import com.iweb.xyr.book_t.model.Book_t;

import java.util.List;

public interface BookService {
    //新增一条记录
    public int saveOne(Book_t b);

    //修改一条记录
    public int updateOne(Book_t b);

    //删除一条记录
    public int deleteById(String bid);

    //根据id查询一条记录
    public Book_t queryById(String bid);

    //查询全部
    public List<Book_t> queryAll();

}
