package com.iweb.zq.classlnfo.dao;


import com.iweb.wj.util.JdbcUtil;
import com.iweb.zq.classlnfo.model.Class_t;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Class_tlmpl implements Class_tDao {


    @Override
    public int saveOne(Class_t class_t) {
        String cid = class_t.getCid() ;
        String cname = class_t.getCname();
        String describe_1 = class_t.getDescribe_1();
        String ccreatetime = class_t.getCcreatetime();
        String sql = "insert into class_t values(?,?,?,?)";
        return JdbcUtil.updateBySql(sql,cid,cname,describe_1,ccreatetime);

    }

    @Override
    public int updateOne(Class_t class_t) {
        String cid = class_t.getCid();
        String cname = class_t.getCname();
        String describe_1 = class_t.getDescribe_1();
        String ccreatetime = class_t.getCcreatetime();
        String sql = "update class_t set cname=?,describe_1=?,ccreatetime=? where cid =?";
        return JdbcUtil.updateBySql(sql,cname,describe_1,ccreatetime,cid);
    }

    @Override
    public int deleteOne(String cid) {
        String sql = "delete from class_t where cid = ?";
        return JdbcUtil.updateBySql(sql, cid);
    }

    @Override
    public Class_t queryById(String cid) {
        String sql = "select * from class_t where cid = ?";
        List<Map<String,Object>> list = JdbcUtil.queryBySql(sql,cid);
        String cname = (String)(list.get(0).get("cname"));
        String describe_1 = (String)(list.get(0).get("describe_1"));
        String ccreatetime = (String)(list.get(0).get("ccreatetime"));
        return new Class_t(cid,cname,describe_1,ccreatetime);
    }

    @Override
    public List<Class_t> queryAll() {
        List<Class_t> class_ts = new ArrayList<>();
        String sql = "select * from class_t";
        List<Map<String,Object>> list = JdbcUtil.queryBySql(sql);
        for(Map<String,Object> map: list){
            String cid = (String)map.get("cid");
            String cname  = (String)map.get("cname");
            String describe_1 = (String)map.get("describe_1");
            String ccreatetime  = (String)map.get("ccreatetime");
            class_ts.add(new Class_t(cid,cname,describe_1,ccreatetime));
        }
        return class_ts;
    }
}
