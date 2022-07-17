package com.iweb.settings.dao;

import com.iweb.settings.domain.Book;

import java.util.List;
import java.util.Map;

public interface BookDao {
     List<Book> selectList(Map<String, Object> map);

     int queryCount(Map<String, Object> map);

    int save(Book book);

    Book selectById(String xsid);

    int update(Book book);

    int deleteById(String bid);
}
