package com.iweb.zq.Collectlnfo.dao;

import com.iweb.zq.Collectlnfo.model.Collect_t;

import java.util.List;

public interface Collect_tDao {
    //    新增一条数据
    public int saveOne(Collect_t collect_t);
    //    修改一条数据
    public int updateOne(Collect_t collect_t,String xbid,String xuid,String ctime1);
    //    删除一条记录
    public int deleteOne(String bid,String userid,String ctime);
    //    根据用户id查询
    public Collect_t queryById(String bid,String userid,String ctime);
    //查询全部
    public List<Collect_t> queryAll();
}
