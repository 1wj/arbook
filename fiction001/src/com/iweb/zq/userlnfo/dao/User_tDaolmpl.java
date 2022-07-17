package com.iweb.zq.userlnfo.dao;

import com.iweb.wj.util.JdbcUtil;
import com.iweb.zq.userlnfo.model.User_t;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class User_tDaolmpl implements User_tDao{

    @Override
    public int saveOne(User_t user_t) {
        String userid = user_t.getUserid();
        String uname = user_t.getUname();
        String upwd = user_t.getUpwd();
        String unickname = user_t.getUnickname();
        String aid = user_t.getAid();
        String remaindays = user_t.getRemaindays();
        int tel = user_t.getTel();
        String sql = "insert into user_t values(?,?,?,?,?,?,?)";
        return JdbcUtil.updateBySql(sql,userid,uname,upwd,unickname,aid,remaindays,tel);
    }

    @Override
    public int updateOne(User_t user_t) {
        String userid = user_t.getUserid();
        String uname = user_t.getUname();
        String upwd = user_t.getUpwd();
        String unickname = user_t.getUnickname();
        String aid = user_t.getAid();
        String remaindays = user_t.getRemaindays();
        int tel = user_t.getTel();
        String sql = "update user_t set uname = ?,upwd = ?,unickname = ?,aid = ?,remaindays = ?,tel = ? where userid = ?";
        return JdbcUtil.updateBySql(sql,uname,upwd,unickname,aid,remaindays,tel,userid);

    }

    @Override
    public int deleteOne(String userid) {
       String sql = "delete from user_t where userid = ?";
       return JdbcUtil.updateBySql(sql, userid);

    }


    @Override
    public User_t queryById(String userid) {
        String sql = "select * from user_t where userid = ?";
        List<Map<String,Object>> list = JdbcUtil.queryBySql(sql,userid);
        String uname = (String)(list.get(0).get("uname"));
        String upwd = (String)(list.get(0).get("upwd"));
        String unickname = (String)(list.get(0).get("unickname"));
        String aid = (String)(list.get(0).get("aid"));
        String remaindays = (String)(list.get(0).get("remaindays"));
        int tel =(int)(list.get(0).get("tel"));
        return new User_t(userid,uname,upwd,unickname,aid,remaindays,tel);
        }
    @Override
    public List<User_t> queryAll() {
        List<User_t> user_ts = new ArrayList<>();
        String sql = "select * from user_t";
        List<Map<String,Object>> list = JdbcUtil.queryBySql(sql);
        for(Map<String,Object> map: list){
            String userid = (String)map.get("userid");
            String uname  = (String)map.get("uname");
            String upwd = (String)map.get("upwd");
            String unickname  = (String)map.get("unickname");
            String aid  = (String)map.get("aid");
            String remaindays = (String)map.get("remaindays");
            int tel  = (int)map.get("tel");
            user_ts.add(new User_t(userid,uname,upwd,unickname,aid,remaindays,tel));
        }
        return user_ts;
}

    @Override
    public  int queryUsernamePsw(String uname, String psw) {
        String sql = "select * from user_t where uname =? and upwd =?";
        List<Map<String,Object>> list = JdbcUtil.queryBySql(sql,uname,psw);
        return list.size();
    }
}
