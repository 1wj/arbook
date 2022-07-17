package com.iweb.zq.userlnfo.dao;

import com.iweb.zq.userlnfo.model.User_t;

import java.util.List;

public interface User_tDao {
//    新增一条数据
    public int saveOne(User_t user_t);
//    修改一条数据
    public int updateOne(User_t user_t);
//    删除一条记录
    public int deleteOne(String userid);
//    根据用户id查询
    public User_t queryById(String userid);
//查询全部
    public List<User_t> queryAll();

    public int queryUsernamePsw(String uname, String psw);


}
