package com.iweb.settings.dao;

import com.iweb.settings.domain.Admint;

import java.util.List;
import java.util.Map;

public interface AdminDao {
    List<Admint> selectList(Map<String, Object> map);

    int queryCount(Map<String, Object> map);

    Admint selectById(String aid);

    int save(Admint admint);

    int updateById(Admint admint);

    int deleteById(String aid);

    int selectByIdPad(Map<String, Object> map);

    int updateByIdPad(Map<String, Object> map);
}
