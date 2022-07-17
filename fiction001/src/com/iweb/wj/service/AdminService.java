package com.iweb.wj.service;



import com.iweb.wj.model.Admin;

import java.util.List;

public interface AdminService {
    //新增一条记录
    public int saveOne(Admin admin);

    //修改一条记录
    public int updateOne(Admin admin);

    //删除一条记录
    public int deleteOne(String adminId);

    //根据id查询一条记录
    public Admin queryByID(String adminId);

    //查询全部
    public List<Admin> queryALL();

    //管理员登录
    public boolean login(String adminName,String adminPasswd);
}
