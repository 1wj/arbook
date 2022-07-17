package com.iweb.settings.service;

import com.iweb.settings.domain.*;
import com.iweb.settings.vo.PageVO;

import java.util.Map;

public interface UserService {
    Admint login(Admint admint);

    PageVO<User> selectList(Map<String, Object> map);

    User editById(String userid);

    Boolean update(User user);

    int deleteById(String userid);

    PageVO<Book> collectSelectList(Map<String, Object> map);

    int collectdeleteById(Map<String, Object> map);

    PageVO<Book_User> historySelectList(Map<String, Object> map);

    PageVO<Vipt> vipSelectList(Map<String, Object> map);
}
