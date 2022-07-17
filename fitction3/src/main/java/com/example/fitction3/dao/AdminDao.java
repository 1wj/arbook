package com.example.fitction3.dao;



import com.example.fitction3.domain.Admin;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;
import java.util.Map;
@Mapper
public interface AdminDao {
    List<Admin> selectList(Map<String, Object> map);

    int queryCount(Map<String, Object> map);

    Admin selectById(String aid);

    int save(Admin admin);

    int updateById(Admin admin);

    int deleteById(String aid);

    int selectByIdPad(Map<String, Object> map);

    int updateByIdPad(Map<String, Object> map);
}
