package com.iweb.settings.service;

import com.iweb.settings.domain.Messaget;
import com.iweb.settings.vo.PageVO;

import java.util.List;
import java.util.Map;

public interface MessageService {
    PageVO<Messaget> selectList(Map<String, Object> map);

    int deleteById(String mid);

    Messaget selectById(String mid);


    Boolean sendById(Messaget messaget);
}
