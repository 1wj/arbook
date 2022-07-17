package com.iweb.zq.Collectlnfo.Service;

import com.iweb.zq.Collectlnfo.dao.Collect_tDao;
import com.iweb.zq.Collectlnfo.dao.Collect_tDaolmpl;
import com.iweb.zq.Collectlnfo.model.Collect_t;

import java.util.List;

public class Collect_tServicelmpl implements Collect_tService {
    private Collect_tDao cool_tDao = new Collect_tDaolmpl();

    @Override
    public int saveOne(Collect_t collect_t) {
        return cool_tDao.saveOne(collect_t);
    }

    @Override
    public int updateOne(Collect_t collect_t,String xbid,String xuid,String ctime1) {
        return cool_tDao.updateOne(collect_t,xbid,xuid,ctime1);
    }

    @Override
    public int deleteOne(String bid, String userid, String ctime) {
        return cool_tDao.deleteOne(bid,userid,ctime);
    }

    @Override
    public Collect_t queryById(String bid, String userid, String ctime) {
        return cool_tDao.queryById(bid,userid,ctime);
    }

    @Override
    public List<Collect_t> queryAll() {
        return cool_tDao.queryAll();
    }
}
