package com.iweb.settings.dao;

import com.iweb.settings.domain.Vipt;

import java.util.List;
import java.util.Map;

public interface VipDao {
    List<Vipt> vipSelectList(Map<String, Object> map);

    int vipqueryCount(Map<String, Object> map);
}
