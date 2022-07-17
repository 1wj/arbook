package com.iweb.wj.service;

import com.iweb.wj.model.Vip;

import java.util.List;

public interface VipService {
    //新增一条记录
    public int saveOne(Vip vip);

    //修改一条记录  注意：：
    public int updateOne(Vip vip);

    //删除一条记录
    public int deleteOne(String vipId);

    //根据id查询一条记录
    public List<Vip> queryByID(String vipId);

    //查询全部
    public List<Vip> queryALL();
}
