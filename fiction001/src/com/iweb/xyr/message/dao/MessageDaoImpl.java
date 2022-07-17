package com.iweb.xyr.message.dao;


import com.iweb.wj.util.JdbcUtil;
import com.iweb.xyr.message.model.Message_t;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MessageDaoImpl implements MessageDao {
    @Override
    public int saveOne(Message_t m) {
        String mid = m.getMid();
        String sendtime = m.getSendtime();
        String message_t = m.getMessage();
        String senderid = m.getSenderid();
        String aid = m.getAid();
        String sql="insert into message_t values(?,?,?,?,?)";
        return JdbcUtil.updateBySql(sql,mid,sendtime,message_t,senderid,aid);

    }

    @Override
    public int updateOne(Message_t m) {
        String mid = m.getMid();
        String sendtime = m.getSendtime();
        String message_t = m.getMessage();
        String senderid = m.getSenderid();
        String aid = m.getAid();
        String sql="update message_t set sendtime=?,message_t=?,senderid=?,aid=?"+"where mid=?";

        return JdbcUtil.updateBySql(sql,sendtime,message_t,senderid,aid,mid);
    }

    @Override
    public int deleteById(String mid) {
        String sql="delete from message_t where mid=?";
        return JdbcUtil.updateBySql(sql,mid);
    }

    @Override
    public Message_t queryById(String mid) {
        String sql = "select * from message_t where mid=?";
        List<Map<String,Object>> list  = JdbcUtil.queryBySql(sql,mid);
        String sendtime = (String)list.get(0).get("sendtime");
        String message_t = (String)list.get(0).get("message_t");
        String senderid = (String)list.get(0).get("senderid");
        String aid = (String)list.get(0).get("aid");
        return new Message_t(mid,sendtime,message_t,senderid,aid);
    }

    @Override
    public List<Message_t> queryAll() {
        List<Message_t> mt = new ArrayList<>();
        String sql = "select * from message_t";
        List<Map<String,Object>> list = JdbcUtil.queryBySql(sql);
        for(Map<String,Object> map:list){
            String mid = (String) map.get("mid");
            String sendtime = (String) map.get("sendtime");
            String message_t = (String) map.get("message_t");
            String senderid = (String) map.get("senderid");
            String aid = (String) map.get("aid");
            mt.add(new Message_t(mid,sendtime,message_t,senderid,aid));
        }
        return mt;
    }
}
