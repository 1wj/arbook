package com.iweb.fiction.chararcter_t.dao;


import com.iweb.fiction.chararcter_t.model.Character_t;

import java.util.List;

public interface CharacterDao {
    //新增一条记录
    public int saveOne(Character_t c);

    //修改一条记录
    public int updateOne(Character_t c);

    //删除一条记录
    public int deleteById(String bid,String characterid);

    //根据id查询一条记录
    public Character_t queryById(String bid,String characterid);

    //查询全部
    public List<Character_t> queryAll();
}
