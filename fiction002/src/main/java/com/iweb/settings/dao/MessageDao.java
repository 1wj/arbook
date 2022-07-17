package com.iweb.settings.dao;

import com.iweb.settings.domain.Messaget;

import java.util.List;
import java.util.Map;

public interface MessageDao {
    List<Messaget> selectList(Map<String, Object> map);

    int queryCount(Map<String, Object> map);

    int deleteById(String mid);

    Messaget selectById(String mid);

    int sendById(Messaget messaget);


    //int selectByIds(List<Messaget> list);

   
}
