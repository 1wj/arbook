package com.iweb.settings.dao;

import com.iweb.settings.domain.Charactert;

import java.util.List;
import java.util.Map;

public interface CharacterDao {
    List<Charactert> selectList(Map<String, Object> map);

    int queryCount(Map<String, Object> map);

    int addByMc(Charactert charactert);


    int deletechById(Map<String, Object> map);
}
