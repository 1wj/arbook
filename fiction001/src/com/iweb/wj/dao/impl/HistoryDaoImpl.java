package com.iweb.wj.dao.impl;

import com.iweb.wj.dao.HistoryDao;
import com.iweb.wj.model.Admin;
import com.iweb.wj.model.History;
import com.iweb.wj.util.JdbcUtil;

import javax.swing.text.AsyncBoxView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HistoryDaoImpl implements HistoryDao {

    @Override
    public int saveOne(History history) {
        String bid = history.getBid();
        String readtime = history.getReadtime();
        String userid = history.getUserid();
        String sql="insert into history_t values(?,?,?)";
        int i = JdbcUtil.updateBySql(sql, userid, bid, readtime);
        return i;
    }

    //看看联合主键是如何修改的
    @Override
    public int updateOne(History history, String xbid,String readtime,String xuid) {
        String bid = history.getBid();
        String userid = history.getUserid();
        String readtime1 = history.getReadtime();
        String sql="update history_t set bid=? ,readtime=?, userid=? where bid=? and userid=? and readtime=?";
        int i = JdbcUtil.updateBySql(sql, xbid,readtime,xuid , bid ,userid,readtime1);
        return i;
    }

    @Override
    public int deleteOne(String userId,String bid) {
        String sql="delete from history_t where userid=? and bid=?";
        return JdbcUtil.updateBySql(sql,userId, bid);
    }

    @Override
    public List<History> queryByID(String userId) {
        String sql="select * from history_t where userid=?";
        List<Map<String, Object>> list = JdbcUtil.queryBySql(sql,userId);
        List<History> histories=new ArrayList<>();
        for (Map<String, Object> map : list) {
            String bid = (String) map.get("bid");
            String readtime = (String) map.get("readtime");
            History history=new History(userId,bid,readtime);
            histories.add(history);
        }
        return histories;
    }

    @Override
    public List<History> queryALL() {
        List<History> histories=new ArrayList<>();
        String sql = "select * from history_t";
        List<Map<String, Object>> list = JdbcUtil.queryBySql(sql);
        for (Map<String, Object> map : list) {
            String userId = (String) map.get("userid");
            String bid = (String) map.get("bid");
            String readtime = (String) map.get("readtime");
            History history=new History(userId,bid,readtime);
            histories.add(history);
        }
        return histories;
    }
}
