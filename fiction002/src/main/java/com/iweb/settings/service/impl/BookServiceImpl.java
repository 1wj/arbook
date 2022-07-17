package com.iweb.settings.service.impl;

import com.iweb.settings.dao.BookDao;
import com.iweb.settings.dao.CharacterDao;
import com.iweb.settings.domain.Book;
import com.iweb.settings.domain.Charactert;
import com.iweb.settings.domain.Classt;
import com.iweb.settings.service.BookService;
import com.iweb.settings.vo.PageVO;
import com.iweb.utils.SqlSessionUtil;

import java.util.List;
import java.util.Map;

public class BookServiceImpl implements BookService {
    BookDao bookDao= SqlSessionUtil.getSqlSession().getMapper(BookDao.class);
    CharacterDao characterDao=SqlSessionUtil.getSqlSession().getMapper(CharacterDao.class);
    @Override
    public PageVO<Book> selectList(Map<String, Object> map) {

        //查类别对象
        List<Book> list=bookDao.selectList( map);
        //查数量
        int count=bookDao.queryCount(map);

        PageVO<Book> pageVO=new PageVO();

        pageVO.setuList(list);

        //设置总条数
        pageVO.setRecodeCount(count);
        //设置总页数
        pageVO.setTotal();

        return pageVO;
    }

    @Override
    public Boolean save(Book book) {
        int i=bookDao.save(book);
        Boolean flag=false;
        if(i==1){
            flag=true;
        }
        return flag;
    }

    @Override
    public Boolean selectById(String xsid) {
        Book book=bookDao.selectById(xsid);
        Boolean flag=false;
        if(book!=null){
            flag=true;
        }
        return flag;
    }

    @Override
    public Book editById(String bid) {
        Book book=bookDao.selectById(bid);
        return book;
    }

    @Override
    public Boolean update(Book book) {
        int i=bookDao.update(book);
        Boolean flag=false;
        if(i==1){
            flag=true;
        }
        return flag;
    }

    @Override
    public int deleteById(String bid) {
        int i=bookDao.deleteById(bid);
        return i;
    }

    @Override
    public PageVO<Charactert> characterSelectList(Map<String, Object> map) {
        //查类别对象
        List<Charactert> list=characterDao.selectList( map);
        //查数量
        int count=characterDao.queryCount(map);

        PageVO<Charactert> pageVO=new PageVO();

        pageVO.setuList(list);

        //设置总条数
        pageVO.setRecodeCount(count);
        //设置总页数
        pageVO.setTotal();

        return pageVO;
    }

    @Override
    public Boolean addByMc(Charactert charactert) {
        int i=characterDao.addByMc(charactert);
        Boolean flag=false;
        if(i==1){
            flag=true;
        }
        return flag;
    }

    @Override
    public Boolean deletechById(Map<String, Object> map) {
        int i=characterDao.deletechById(map);
        Boolean flag=false;
        if(i==1){
            flag=true;
        }
        return flag;
    }
}
