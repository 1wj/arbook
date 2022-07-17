package com.iweb.wj.dao.impl;



import com.iweb.wj.dao.AdminDao;
import com.iweb.wj.model.Admin;
import com.iweb.wj.util.JdbcUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AdminDaoImpl implements AdminDao {
    @Override
    public int saveOne(Admin admin) {
        String adminId = admin.getAid();
        String adminName = admin.getAname();
        String adminPasswd = admin.getApasswd();
        String adminfullnaem = admin.getAnickname();
        String createTime = admin.getAcreatetime();
        String sql = "insert into admin_t values(?,?,?,?,?)";
        return JdbcUtil.updateBySql(sql, adminId, adminName, adminPasswd, adminfullnaem, createTime);
    }

    @Override
    public int updateOne(Admin admin) {
        String adminId = admin.getAid();
        String adminName = admin.getAname();
        String adminPasswd = admin.getApasswd();
        String adminfullnaem = admin.getAnickname();
        String createTime = admin.getAcreatetime();
        String sql = "update admin_t set aname=?,apasswd=?,anickname=? where " +
                "aid=?";
        return JdbcUtil.updateBySql(sql,adminName,adminPasswd,adminfullnaem,adminId);
    }

    @Override
    public int deleteOne(String adminId) {
        String sql="delete from admin_t where aid=?";
        return JdbcUtil.updateBySql(sql,adminId);
    }

    @Override
    public Admin queryByID(String adminId) {
        String sql="select * from admin_t where aid=?";
        List<Map<String, Object>> list = JdbcUtil.queryBySql(sql,adminId);
        String adminName=(String)(list.get(0).get("aname"));
        String adminIdPasswd=(String)(list.get(0).get("apasswd"));
        String adminfullnaem=(String)(list.get(0).get("anickname"));
        String createTime=(String)(list.get(0).get("acreatetime"));
        return new Admin(adminId, adminName, adminIdPasswd, adminfullnaem, createTime);
    }

    @Override
    public List<Admin> queryALL() {
        List<Admin> adminlist=new ArrayList<>();
        String sql = "select * from admin_t";
        List<Map<String, Object>> list = JdbcUtil.queryBySql(sql);
        for (Map<String, Object> map : list) {
            String aid =(String)map.get("aid");
            String aname =(String)map.get("aname");
            String apasswd =(String)map.get("apasswd");
            String anickname =(String)map.get("anickname");
            String acreatetime =(String)map.get("acreatetime");
            adminlist.add(new Admin(aid, aname, apasswd, anickname, acreatetime));
        }
        return adminlist;
    }

    @Override
    public int queryByUserNamePasswd(String adminName, String adminPasswd) {
        String sql="select * from admin_t where aname=? and apasswd=?";
        List<Map<String, Object>> list = JdbcUtil.queryBySql(sql,adminName,adminPasswd);
        return list.size();
    }


}
