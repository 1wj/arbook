package com.iweb.zq.classlnfo.dao;

import com.iweb.zq.classlnfo.model.Class_t;

import java.util.List;

public interface Class_tDao {
    //    新增一条数据
    public int saveOne(Class_t class_t);
    //    修改一条数据
    public int updateOne(Class_t class_t);
    //    删除一条记录
    public int deleteOne(String cid);
    //    根据用户id查询
    public Class_t queryById(String cid);
    //查询全部
    public List<Class_t> queryAll();
}
