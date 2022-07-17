package com.iweb.wj.service.impl;

import com.iweb.wj.dao.VipDao;
import com.iweb.wj.dao.impl.VipDaoImpl;
import com.iweb.wj.model.Vip;
import com.iweb.wj.service.VipService;

import java.util.List;

public class VipServiceImpl implements VipService {
    VipDao dao=new VipDaoImpl();
    @Override
    public int saveOne(Vip vip) {
       return dao.saveOne(vip);
    }

    @Override
    public int updateOne(Vip vip) {
        return dao.updateOne(vip);
    }

    @Override
    public int deleteOne(String vipId) {
        return dao.deleteOne(vipId);
    }

    @Override
    public List<Vip> queryByID(String vipId) {
        return dao.queryByID(vipId);
    }

    @Override
    public List<Vip> queryALL() {
        return dao.queryALL();
    }
}
