package com.iweb.wj.dao;

import com.iweb.wj.model.Classify;
import com.iweb.wj.model.Vip;

import java.util.List;

public interface ClassifyDao {
    //新增一条记录
    public int saveOne(Classify classify);

    //修改一条记录  注意：：
    public int updateOne(Classify classify,String xbid,String xcid);

    //删除一条记录
    public int deleteOne(String bid,String cid);

    //根据id查询一条记录  再看可能重载
    public List<Classify> queryByID(String bid);

    //查询全部
    public List<Classify> queryALL();
}
