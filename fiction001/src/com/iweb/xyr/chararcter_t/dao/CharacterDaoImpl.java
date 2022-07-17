package com.iweb.fiction.chararcter_t.dao;


import com.iweb.fiction.chararcter_t.model.Character_t;
import com.iweb.wj.util.JdbcUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CharacterDaoImpl implements CharacterDao {
    @Override
    public int saveOne(Character_t c) {
        String bid = c.getBid();
        String characterid = c.getCharacterid();
        String charactername = c.getChararctername();
        String characterpath = c.getCharacterpath();

        String sql="insert into character_t values(?,?,?,?)";
        return JdbcUtil.updateBySql(sql,bid,characterid,charactername,characterpath);

    }

    @Override
    public int updateOne(Character_t c) {
        String bid = c.getBid();
        String characterid = c.getCharacterid();
        String charactername = c.getChararctername();
        String characterpath = c.getCharacterpath();

        String sql="update character_t set charactername=?,characterpath=?"
                +"where bid=? and characterid=?";
        return JdbcUtil.updateBySql(sql,charactername,characterpath,bid,characterid);
    }

    @Override
    public int deleteById(String bid, String characterid) {
        String sql="delete from character_t where bid=? and characterid=?";
        return JdbcUtil.updateBySql(sql,bid,characterid);
    }

    @Override
    public Character_t queryById(String bid, String characterid) {
        String sql = "select * from character_t where bid=? and characterid=?";
        List<Map<String,Object>> list  = JdbcUtil.queryBySql(sql,bid,characterid);
        String charactername = (String)list.get(0).get("charactername");
        String characterpath = (String)list.get(0).get("characterpath");

        return new Character_t(bid,characterid,charactername,characterpath);
    }

    @Override
    public List<Character_t> queryAll() {
        List<Character_t> character_t = new ArrayList<>();
        String sql = "select * from character_t";
        List<Map<String,Object>> list = JdbcUtil.queryBySql(sql);
        for(Map<String,Object> map:list){
            String bid = (String) map.get("bid");
            String characterid = (String) map.get("characterid");
            String charactername = (String) map.get("charactername");
            String characterpath = (String) map.get("characterpath");
            character_t.add(new Character_t(bid,characterid,charactername,characterpath));
        }

        return character_t;
    }
}
