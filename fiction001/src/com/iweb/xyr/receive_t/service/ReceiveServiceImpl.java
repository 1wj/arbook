package com.iweb.xyr.receive_t.service;

import com.iweb.xyr.receive_t.dao.ReceiveDao;
import com.iweb.xyr.receive_t.dao.ReceiveDaoImpl;
import com.iweb.xyr.receive_t.model.Receive_t;

import java.util.List;

public class ReceiveServiceImpl implements  ReceiveService {

    private ReceiveDao receivedao = new ReceiveDaoImpl();

    @Override
    public int saveOne(Receive_t r) {
        return receivedao.saveOne(r);
    }

    @Override
    public int updateOne1(Receive_t r,String xuid,String xmid) {
        return receivedao.updateOne1(r,xuid,xmid);
    }



    @Override
    public int deleteById(String userid, String mid) {
        return receivedao.deleteById(userid,mid);
    }

    @Override
    public Receive_t queryById(String userid, String mid) {
        return receivedao.queryById(userid,mid);
    }

    @Override
    public List<Receive_t> queryAll() {
        return receivedao.queryAll();
    }
}
