package com.iweb.zq.classlnfo.service;

import com.iweb.zq.classlnfo.dao.Class_tDao;
import com.iweb.zq.classlnfo.dao.Class_tlmpl;
import com.iweb.zq.classlnfo.model.Class_t;

import java.util.List;

public class Class_tServicelmpl  implements Class_tService {
    private Class_tDao class_tDao = new Class_tlmpl();
    @Override
    public int saveOne(Class_t class_t) {
        return class_tDao.saveOne(class_t);
    }

    @Override
    public int updateOne(Class_t class_t) {
        return class_tDao.updateOne(class_t);
    }

    @Override
    public int deleteOne(String cid) {
        return class_tDao.deleteOne(cid);
    }

    @Override
    public Class_t queryById(String cid) {
        return class_tDao.queryById(cid);
    }

    @Override
    public List<Class_t> queryAll() {
        return class_tDao.queryAll();
    }
}
