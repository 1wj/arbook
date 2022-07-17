package com.iweb.xyr.receive_t.dao;

import com.iweb.wj.util.JdbcUtil;
import com.iweb.xyr.receive_t.model.Receive_t;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReceiveDaoImpl implements ReceiveDao {
    @Override
    public int saveOne(Receive_t r) {
        String userid = r.getUserid();
        String mid = r.getMid();
        String sql="insert into receive_t values(?,?)";
        return JdbcUtil.updateBySql(sql,userid,mid);
    }

    @Override
    public int updateOne1(Receive_t r,String xuid,String xmid) {
        String userid = r.getUserid();
        String mid = r.getMid();
        String sql="update receive_t set mid=?,userid=? "
                +"where userid=? and mid=?";
        return JdbcUtil.updateBySql(sql,xmid,xuid ,userid,mid);
    }


    @Override
    public int deleteById(String userid, String mid) {
        String sql="delete from receive_t where userid=? and mid=?";
        return JdbcUtil.updateBySql(sql,userid,mid);
    }

    @Override
    public Receive_t queryById(String userid, String mid) {
        String sql = "select * from receive_t where userid=? and mid=?";
        List<Map<String,Object>> list  = JdbcUtil.queryBySql(sql,userid,mid);

        return new Receive_t(sql,userid,mid);
    }

    @Override
    public List<Receive_t> queryAll() {
        List<Receive_t> receive_t = new ArrayList<>();
        String sql = "select * from receive_t";
        List<Map<String,Object>> list = JdbcUtil.queryBySql(sql);
        for(Map<String,Object> map:list){
            String userid = (String) map.get("userid");
            String mid = (String) map.get("mid");
            receive_t.add(new Receive_t(userid,mid));
        }
        return receive_t;
    }
}
