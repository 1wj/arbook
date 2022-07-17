package com.iweb.wj.service.impl;

import com.iweb.wj.dao.ClassifyDao;
import com.iweb.wj.dao.impl.ClassifyDaoImpl;
import com.iweb.wj.model.Classify;
import com.iweb.wj.service.ClassifyService;

import java.util.List;

public class ClassifyServiceImpl implements ClassifyService {
    ClassifyDao dao=new ClassifyDaoImpl();
    @Override
    public int saveOne(Classify classify) {
        return dao.saveOne(classify);
    }

    @Override
    public int updateOne(Classify classify, String xbid, String xcid) {
        return dao.updateOne(classify,xbid,xcid);
    }

    @Override
    public int deleteOne(String bid, String cid) {
        return dao.deleteOne(bid,cid);
    }

    @Override
    public List<Classify> queryByID(String bid) {
        return dao.queryByID(bid);
    }

    @Override
    public List<Classify> queryALL() {
        return dao.queryALL();
    }
}
