package com.iweb.settings.service;

import com.iweb.settings.domain.Admint;
import com.iweb.settings.vo.PageVO;

import java.util.Map;

public interface AdminService {
    PageVO<Admint> selectList(Map<String, Object> map);

    Boolean selectById(String aid);

    Boolean save(Admint admint);

    Admint editById(String aid);

    Boolean updateById(Admint admint);

    Boolean deleteById(String aid);

    Boolean chongzhi(Map<String, Object> map);
}
