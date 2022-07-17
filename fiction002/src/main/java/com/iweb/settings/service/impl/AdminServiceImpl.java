package com.iweb.settings.service.impl;

import com.iweb.settings.dao.AdminDao;
import com.iweb.settings.domain.Admint;
import com.iweb.settings.domain.Book;
import com.iweb.settings.domain.Classt;
import com.iweb.settings.service.AdminService;
import com.iweb.settings.vo.PageVO;
import com.iweb.utils.SqlSessionUtil;

import java.util.List;
import java.util.Map;

public class AdminServiceImpl implements AdminService {
    AdminDao adminDao= SqlSessionUtil.getSqlSession().getMapper(AdminDao.class);
    @Override
    public PageVO<Admint> selectList(Map<String, Object> map) {
        //查类别对象
        List<Admint> list=adminDao.selectList( map);
        //查数量
        int count=adminDao.queryCount(map);

        PageVO<Admint> pageVO=new PageVO();

        pageVO.setuList(list);

        //设置总条数
        pageVO.setRecodeCount(count);
        //设置总页数
        pageVO.setTotal();

        return pageVO;
    }

    @Override
    public Boolean selectById(String aid) {
        Admint admint=adminDao.selectById(aid);
        boolean flag=false;
        if(admint!=null){
            flag=true;
        }
        return flag;
    }

    @Override
    public Boolean save(Admint admint) {
        int i=adminDao.save(admint);
        boolean flag=false;
        if(i==1){
            flag=true;
        }
        return flag;
    }

    @Override
    public Admint editById(String aid) {
        Admint admint=adminDao.selectById(aid);
        return admint;
    }

    @Override
    public Boolean updateById(Admint admint) {
        int i=adminDao.updateById(admint);
        boolean flag=false;
        if(i==1){
            flag=true;
        }
        return flag;
    }

    @Override
    public Boolean deleteById(String aid) {
        int i=adminDao.deleteById(aid);
        Boolean flag=false;
        if(i==1){
            flag=true;
        }
        return flag;
    }

    @Override
    public Boolean chongzhi(Map<String, Object> map) {
        int i=adminDao.selectByIdPad(map);
        Boolean flag=false;
        if(i!=1){
           return flag;
        }
        int i2= adminDao.updateByIdPad(map);
        if(i2==1){
            flag=true;
        }
        return flag;
    }
}
