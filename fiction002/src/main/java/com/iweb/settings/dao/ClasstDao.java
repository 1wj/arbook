package com.iweb.settings.dao;

import com.iweb.settings.domain.Classt;

import java.util.List;
import java.util.Map;

public interface ClasstDao {
    int queryCount(Map map);


    List<Classt> selectList(Map map);

    int save(Classt classt);

    Classt selectById(String lbid);

    int update(Classt classt);

    int deleteById(String cid);
}
