package com.example.fitction3.service;



import com.example.fitction3.domain.Admin;
import com.example.fitction3.vo.PageVO;

import java.util.Map;

public interface AdminService {



    PageVO<Admin> selectList(Map<String, Object> map);

    Admin selectById(String aid);

    Integer save(Admin admin);

    Admin editById(String aid);

    int updateById(Admin admin);

    int deleteById(String aid);

    Boolean chongzhi(Map<String, Object> map);
}
