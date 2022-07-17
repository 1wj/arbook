package com.iweb.wj.dao;



import com.iweb.wj.model.Admin;

import java.util.List;

public interface AdminDao {
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

    //用户登录
    public int queryByUserNamePasswd(String manageruserName,String managerPassword);
}
