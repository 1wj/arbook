package com.iweb.settings.service.impl;

import com.iweb.settings.dao.Book_UserDao;
import com.iweb.settings.dao.UserDao;
import com.iweb.settings.dao.VipDao;
import com.iweb.settings.domain.*;
import com.iweb.settings.service.UserService;
import com.iweb.settings.vo.PageVO;
import com.iweb.utils.SqlSessionUtil;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    UserDao userDao= SqlSessionUtil.getSqlSession().getMapper(UserDao.class);
    Book_UserDao book_userDao=SqlSessionUtil.getSqlSession().getMapper(Book_UserDao.class);
    VipDao vipDao=SqlSessionUtil.getSqlSession().getMapper(VipDao.class);
    //登录
    @Override
    public Admint login(Admint admint) {
        Admint admint1=userDao.login(admint);

        return admint1;
    }

    @Override
    public PageVO<User> selectList(Map<String, Object> map) {
        //查类别对象
        List<User> list=userDao.selectList( map);
        //查数量
        int count=userDao.queryCount(map);

        PageVO<User> pageVO=new PageVO();

        pageVO.setuList(list);

        //设置总条数
        pageVO.setRecodeCount(count);
        //设置总页数
        pageVO.setTotal();

        return pageVO;

    }

    @Override
    public User editById(String userid) {
        User user=userDao.editById(userid);
        return user;
    }

    @Override
    public Boolean update(User user) {
        int i=userDao.update(user);
        Boolean flag=false;
        if(i==1){
            flag=true;
        }
        return flag;
    }

    @Override
    public int deleteById(String userid) {
        int i=userDao.deleteById(userid);
        return i;
    }

    @Override
    public PageVO<Book> collectSelectList(Map<String, Object> map) {
        //查类别对象
        List<Book> list=userDao.collectSelectList( map);
        //查数量
        int count=userDao.collectqueryCount(map);


        PageVO<Book> pageVO=new PageVO();

        pageVO.setuList(list);

        //设置总条数
        pageVO.setRecodeCount(count);
        //设置总页数
        pageVO.setTotal();

        return pageVO;
    }

    @Override
    public int collectdeleteById(Map<String, Object> map) {
        int i=userDao.collectdeleteById(map);
        return i;
    }

    @Override
    public PageVO<Book_User> historySelectList(Map<String, Object> map) {
        //查类别对象
        List<Book_User> list=book_userDao.historySelectList( map);
        //查数量
        int count=book_userDao.historyqueryCount(map);


        PageVO<Book_User> pageVO=new PageVO();

        pageVO.setuList(list);

        //设置总条数
        pageVO.setRecodeCount(count);
        //设置总页数
        pageVO.setTotal();

        return pageVO;
    }

    @Override
    public PageVO<Vipt> vipSelectList(Map<String, Object> map) {
        //查类别对象
        List<Vipt> list=vipDao.vipSelectList( map);
        //查数量
        int count=vipDao.vipqueryCount(map);


        PageVO<Vipt> pageVO=new PageVO();

        pageVO.setuList(list);

        //设置总条数
        pageVO.setRecodeCount(count);
        //设置总页数
        pageVO.setTotal();

        return pageVO;
    }
}
