package com.iweb.xyr.message.dao;


import com.iweb.xyr.message.model.Message_t;

import java.util.List;

public interface MessageDao {
    //新增一条记录
    public int saveOne(Message_t message);

    //修改一条记录
    public int updateOne(Message_t message);

    //删除一条记录
    public int deleteById(String mid);

    //根据id查询一条记录
    public Message_t queryById(String mid);

    //查询全部
    public List<Message_t> queryAll();


}
