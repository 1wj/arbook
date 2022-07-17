package com.iweb.zq.userlnfo.service;

import com.iweb.zq.userlnfo.dao.User_tDao;
import com.iweb.zq.userlnfo.dao.User_tDaolmpl;
import com.iweb.zq.userlnfo.model.User_t;

import java.util.List;

public class User_tServicelmpl implements User_tService {
    private User_tDao user_tDao = new User_tDaolmpl();
    @Override
    public int saveOne(User_t user_t) {
        return user_tDao.saveOne(user_t);
    }

    @Override
    public int updateOne(User_t user_t) {
        return user_tDao.updateOne(user_t);
    }

    @Override
    public int deleteOne(String userid) {
        return user_tDao.deleteOne(userid);
    }

    @Override
    public User_t queryById(String userid) {
        return user_tDao.queryById(userid);
    }

    @Override
    public List<User_t> queryAll() {
        return user_tDao.queryAll();
    }



    @Override
    public boolean login(String uname, String psw) {
        int result = user_tDao.queryUsernamePsw(uname,psw);
        if(result>0){
            return true;
        }else {
            return false;
        }
    }
}
