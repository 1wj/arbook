package com.iweb.settings.service;

import com.iweb.settings.domain.Classt;
import com.iweb.settings.vo.PageVO;

import java.util.List;
import java.util.Map;

public interface ClasstService {
    PageVO<Classt> selectList(Map map);


    Boolean save(Classt classt);

    Boolean selectById(String lbid);

    Classt editById(String cid);

    Boolean update(Classt classt);

    int deleteById(String cid);
}
