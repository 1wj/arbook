package com.iweb.xyr.message.service;


import com.iweb.xyr.message.dao.MessageDao;
import com.iweb.xyr.message.dao.MessageDaoImpl;
import com.iweb.xyr.message.model.Message_t;

import java.util.List;

public abstract class MessageServiceImpl implements MessageService {

    private MessageDao messagedao = new MessageDaoImpl();

    @Override
    public int saveOne(Message_t m) {
        return messagedao.saveOne(m);
    }

    @Override
    public int updateOne(Message_t m) {
        return messagedao.updateOne(m);
    }

    @Override
    public int deleteById(String mid) {
        return messagedao.deleteById(mid);
    }

    @Override
    public Message_t queryById(String mid) {
        return messagedao.queryById(mid);
    }

    @Override
    public List<Message_t> queryAll() {
        return messagedao.queryAll();
    }
}
