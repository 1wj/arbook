package com.iweb.wj.service.impl;

import com.iweb.wj.dao.HistoryDao;
import com.iweb.wj.dao.impl.HistoryDaoImpl;
import com.iweb.wj.model.History;
import com.iweb.wj.service.HistoryService;

import java.util.List;

public class HistoryServiceImpl implements HistoryService {
    HistoryDao dao=new HistoryDaoImpl();
    @Override
    public int saveOne(History history) {
        return dao.saveOne(history);
    }

    @Override
    public int updateOne(History history, String xbid,String readtime, String xuid) {
        return dao.updateOne(history,xbid,readtime,xuid);
    }

    @Override
    public int deleteOne(String userId, String bid) {
        return dao.deleteOne(userId,bid);
    }

    @Override
    public List<History> queryByID(String userId) {
        return dao.queryByID(userId);
    }

    @Override
    public List<History> queryALL() {
        return dao.queryALL();
    }
}
