package com.iweb.xyr.receive_t.service;

import com.iweb.xyr.receive_t.model.Receive_t;

import java.util.List;

public interface ReceiveService  {
    //新增一条记录
    public int saveOne(Receive_t r);

    //修改一条记录
    public int updateOne1(Receive_t r,String xuid,String xmid);


    //删除一条记录
    public int deleteById(String userid,String mid);

    //根据id查询一条记录
    public Receive_t queryById(String userid,String mid);

    //查询全部
    public List<Receive_t> queryAll();
}
