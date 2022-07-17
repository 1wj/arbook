package com.iweb.wj.dao.impl;

import com.iweb.wj.dao.VipDao;
import com.iweb.wj.model.History;
import com.iweb.wj.model.Vip;
import com.iweb.wj.util.JdbcUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VipDaoImpl implements VipDao {
    @Override
    public int saveOne(Vip vip) {
        int addday = vip.getAddday();
        int money = vip.getMoney();
        String vipid = vip.getVipid();
        String rechargetime = vip.getRechargetime();
        String userid = vip.getUserid();
        String sql = "insert into vip_t values(?,?,?,?,?)";
        return JdbcUtil.updateBySql(sql, vipid, rechargetime, money, addday, userid);
    }

    @Override
    public int updateOne(Vip vip) {
        int addday = vip.getAddday();
        int money = vip.getMoney();
        String vipid = vip.getVipid();
        String rechargetime = vip.getRechargetime();
        String userid = vip.getUserid();
        String sql = "update vip_t set rechargetime=?,money=?,addday=? ,userid=? where " +
                "vipid = ?";
        return JdbcUtil.updateBySql(sql,rechargetime,money,addday,userid,vipid);
    }

    @Override
    public int deleteOne(String vipId) {
        String sql="delete from vip_t where vipid=?";
        return JdbcUtil.updateBySql(sql,vipId);

    }

    @Override
    public List<Vip> queryByID(String vipId) {
      String sql="select * from vip_t where vipid=?";
      List<Vip> histories=new ArrayList<>();
        List<Map<String, Object>> list = JdbcUtil.queryBySql(sql, vipId);
        for (Map<String, Object> map : list) {
            String rechargetime = (String) map.get("rechargetime");
            int money = (int) map.get("money");
            int addday = (int) map.get("addday");
            String userid = (String) map.get("userid");
            Vip vip=new Vip(vipId,rechargetime,money,addday,userid);
            histories.add(vip);
        }
        return histories;
    }

    @Override
    public List<Vip> queryALL() {
        String sql="select * from vip_t";
        List<Vip> histories=new ArrayList<>();
        List<Map<String, Object>> list = JdbcUtil.queryBySql(sql);
        for (Map<String, Object> map : list) {
            String vipid = (String) map.get("vipid");
            String rechargetime = (String) map.get("rechargetime");
            int money = (int) map.get("money");
            int addday = (int) map.get("addday");
            String userid = (String) map.get("userid");
            Vip vip=new Vip(vipid,rechargetime,money,addday,userid);
            histories.add(vip);
        }
        return histories;
    }
}
