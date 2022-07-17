package com.iweb.settings.dao;

import com.iweb.settings.domain.Admint;
import com.iweb.settings.domain.Book;
import com.iweb.settings.domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    Admint login(Admint admint);

    List<User> selectList(Map<String, Object> map);

    int queryCount(Map<String, Object> map);

    User editById(String userid);

    int update(User user);

    int deleteById(String userid);

    List<Book> collectSelectList(Map<String, Object> map);

    int collectqueryCount(Map<String, Object> map);

    int collectdeleteById(Map<String, Object> map);
}
