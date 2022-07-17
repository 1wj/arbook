package com.iweb.settings.service;

import com.iweb.settings.domain.Book;
import com.iweb.settings.domain.Charactert;
import com.iweb.settings.vo.PageVO;

import java.util.Map;

public interface BookService {
    PageVO<Book> selectList(Map<String, Object> map);

    Boolean save(Book book);

    Boolean selectById(String xsid);

    Book editById(String bid);

    Boolean update(Book book);

    int deleteById(String bid);

    //以下是对章节表进行操作
    PageVO<Charactert> characterSelectList(Map<String, Object> map);

    Boolean addByMc(Charactert charactert);


    Boolean deletechById(Map<String, Object> map);
}
