package com.iweb.wj.dao.impl;

import com.iweb.wj.dao.ClassifyDao;
import com.iweb.wj.model.Classify;
import com.iweb.wj.model.Vip;
import com.iweb.wj.util.JdbcUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClassifyDaoImpl implements ClassifyDao {
    @Override
    public int saveOne(Classify classify) {
        String sql="insert into classify_t values(?,?)";
        String bid = classify.getBid();
        String cid = classify.getCid();
       return JdbcUtil.updateBySql(sql,bid,cid);

    }

    @Override
    public int updateOne(Classify classify , String xbid, String xcid) {
        String sql="update classify_t set bid=?,cid=? where bid=? and cid=?";
        String bid = classify.getBid();
        String cid = classify.getCid();
        return JdbcUtil.updateBySql(sql,xbid,xcid,bid,cid);
    }

    @Override
    public int deleteOne(String bid, String cid) {
        String sql="delete from  classify_t where bid=? and cid=?";
        return JdbcUtil.updateBySql(sql,bid,cid);
    }

    @Override
    public List<Classify> queryByID(String bid) {
        String sql="select * from classify_t where bid=? ";
        List<Classify> histories=new ArrayList<>();
        List<Map<String, Object>> list = JdbcUtil.queryBySql(sql, bid);
        for (Map<String, Object> map : list) {
            String cid = (String) map.get("cid");

            Classify classify=new Classify(bid,cid);
            histories.add(classify);
        }
        return histories;
    }

    @Override
    public List<Classify> queryALL() {
        String sql="select * from classify_t";
        List<Classify> histories=new ArrayList<>();
        List<Map<String, Object>> list = JdbcUtil.queryBySql(sql);
        for (Map<String, Object> map : list) {
            String cid = (String) map.get("cid");
            String bid = (String) map.get("bid");
            Classify classify=new Classify(bid,cid);
            histories.add(classify);
        }
        return histories;
    }
}
