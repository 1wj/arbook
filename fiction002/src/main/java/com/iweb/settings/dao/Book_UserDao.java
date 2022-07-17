package com.iweb.settings.dao;

import com.iweb.settings.domain.Book_User;

import java.util.List;
import java.util.Map;

public interface Book_UserDao {
    List<Book_User> historySelectList(Map<String, Object> map);

    int historyqueryCount(Map<String, Object> map);
}
