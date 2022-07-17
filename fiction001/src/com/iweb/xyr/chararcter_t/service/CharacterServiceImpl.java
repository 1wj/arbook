package com.iweb.fiction.chararcter_t.service;

import com.iweb.fiction.chararcter_t.dao.CharacterDao;
import com.iweb.fiction.chararcter_t.dao.CharacterDaoImpl;
import com.iweb.fiction.chararcter_t.model.Character_t;

import java.util.List;

public class CharacterServiceImpl implements  CharacterService {

    private CharacterDao characterdao = new CharacterDaoImpl();

    @Override
    public int saveOne(Character_t c) {
        return characterdao.saveOne(c);
    }

    @Override
    public int updateOne(Character_t c) {
        return characterdao.updateOne(c);
    }

    @Override
    public int deleteById(String bid, String characterid) {
        return characterdao.deleteById(bid,characterid);
    }

    @Override
    public Character_t queryById(String bid, String characterid) {
        return characterdao.queryById(bid,characterid);
    }

    @Override
    public List<Character_t> queryAll() {
        return characterdao.queryAll();
    }
}
