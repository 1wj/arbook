package com.iweb.zq.Collectlnfo.dao;


import com.iweb.wj.util.JdbcUtil;
import com.iweb.zq.Collectlnfo.model.Collect_t;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Collect_tDaolmpl implements Collect_tDao {
    @Override
    public int saveOne(Collect_t collect_t) {
        String bid = collect_t.getBid();
        String userid = collect_t.getUserid();
        String ctime = collect_t.getCtime();
        String  sql = "insert into collect_t values(?,?,?)";
        return JdbcUtil.updateBySql(sql,bid,userid,ctime);

    }

    @Override
    public int updateOne(Collect_t collect_t,String xbid,String xuid,String ctime1) {
        String bid = collect_t.getBid();
        String userid = collect_t.getUserid();
        String ctime = collect_t.getCtime();
        String sql = "update collect_t set bid = ?,userid = ?,ctime = ? where bid =? and userid = ? and ctime = ? ";
        return JdbcUtil.updateBySql(sql,xbid,xuid,ctime1,bid,userid,ctime);
    }

    @Override
    public int deleteOne(String bid,String userid,String ctime) {
        String sql = "delete from collect_t where bid = ? and userid = ? and ctime = ?";
        return JdbcUtil.updateBySql(sql,bid,userid,ctime);
    }

    @Override
    public Collect_t queryById(String bid,String userid,String ctime) {
        String sql = "select * from collect_t where bid = ? and userid = ? and ctime = ?";
        return new Collect_t(bid,userid,ctime);
    }

    @Override
    public List<Collect_t> queryAll() {
        List<Collect_t> collect_ts = new ArrayList<>();
        String sql = "select * from collect_t ";
        List<Map<String,Object>> list = JdbcUtil.queryBySql(sql);
        for(Map<String,Object> map: list){
            String bid  = (String)map.get("bid");
            String userid  = (String)map.get("userid");
            String ctime = (String)map.get("ctime");

            collect_ts.add(new Collect_t(bid,userid,ctime));
        }
        return collect_ts;
    }
}
