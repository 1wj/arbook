package com.iweb.xyr.book_t.dao;



import com.iweb.wj.util.JdbcUtil;
import com.iweb.xyr.book_t.model.Book_t;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookDaoImpl implements BookDao {
    @Override
    public int saveOne(Book_t b) {
        String bid = b.getBid();
        String bname = b.getBname();
        String bproperty = b.getBproperty();
        String author = b.getAuthor();
        String isvip = b.getIsvip();
        int page = b.getPage();
        String bcreatetime = b.getBcreatetime();
        String status = b.getStatus();
        String publishtime = b.getPublishtime();
        String sql="insert into book_t values(?,?,?,?,?,?,?,?,?)";
        return JdbcUtil.updateBySql(sql,bid,bname,bproperty,
                author,isvip,page,bcreatetime,status,publishtime);
    }

    @Override
    public int updateOne(Book_t b) {
        String bid = b.getBid();
        String bname = b.getBname();
        String bproperty = b.getBproperty();
        String author = b.getAuthor();
        String isvip = b.getIsvip();
        int page = b.getPage();
        String bcreatetime = b.getBcreatetime();
        String status = b.getStatus();
        String publishtime = b.getPublishtime();
        String sql="update book_t set bname=?,bproperty=?,author=?,isvip=?,page=?,bcreatetime=?,status=?,publishtime=?"
                +"where bid=?";

        return JdbcUtil.updateBySql(sql,bname,bproperty,
                author,isvip,page,bcreatetime,status,publishtime,bid);
    }

    @Override
    public int deleteById(String bid) {
        String sql="delete from book_t where bid=?";
        return JdbcUtil.updateBySql(sql,bid);
    }

    @Override
    public Book_t queryById(String bid) {
        String sql = "select * from book_t where bid=?";
        List<Map<String,Object>> list  = JdbcUtil.queryBySql(sql,bid);
        String bname = (String)list.get(0).get("bname");
        String bproperty = (String)list.get(0).get("bproperty");
        String author = (String)list.get(0).get("author");
        String isvip = (String)list.get(0).get("isvip");
        int page = (int)list.get(0).get("page");
        String bcreatetime = (String)list.get(0).get("bcreatetime");
        String status = (String)list.get(0).get("status");
        String publishtime = (String)list.get(0).get("publishtime");
        return new Book_t(bid,bname,bproperty,
                author,isvip,page,bcreatetime,status,publishtime);
    }

    @Override
    public List<Book_t> queryAll() {
        List<Book_t> book_t = new ArrayList<>();
        String sql = "select * from book_t";
        List<Map<String,Object>> list = JdbcUtil.queryBySql(sql);
        for(Map<String,Object> map:list){
            String bid = (String) map.get("bid");
            String bname = (String) map.get("bname");
            String bproperty = (String) map.get("bproperty");
            String author = (String) map.get("author");
            String isvip = (String) map.get("isvip");
            int page = (int) map.get("page");
            String bcreatetime = (String) map.get("bcreatetime");
            String status = (String) map.get("status");
            String publishtime = (String) map.get("publishtime");
            book_t.add(new Book_t(bid,bname,bproperty,
                    author,isvip,page,bcreatetime,status,publishtime));
        }
        return book_t;
    }
}
