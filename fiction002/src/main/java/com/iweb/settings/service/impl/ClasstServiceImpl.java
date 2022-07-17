package com.iweb.settings.service.impl;

import com.iweb.settings.dao.ClasstDao;
import com.iweb.settings.domain.Classt;
import com.iweb.settings.service.ClasstService;
import com.iweb.settings.vo.PageVO;
import com.iweb.utils.SqlSessionUtil;

import java.util.List;
import java.util.Map;

public class ClasstServiceImpl implements ClasstService {
    ClasstDao classtDao= SqlSessionUtil.getSqlSession().getMapper(ClasstDao.class);

    @Override
    public PageVO<Classt> selectList(Map map) {
        //查类别对象
        List<Classt> list=classtDao.selectList( map);
        //查数量
        int count=classtDao.queryCount(map);
        PageVO<Classt> pageVO=new PageVO();
        pageVO.setuList(list);
        //设置总条数
        pageVO.setRecodeCount(count);
        //设置总页数
        pageVO.setTotal();

        return pageVO;
    }

    @Override
    public Boolean save(Classt classt) {
        int i=classtDao.save(classt);
        boolean flag=false;
        if(i==1){
            flag=true;
        }
        return flag;
    }

    @Override
    public Boolean selectById(String lbid) {
        Classt classt=classtDao.selectById(lbid);
        boolean flag=false;
        if(classt!=null){
            flag=true;
        }
        return flag;
    }

    @Override
    public Classt editById(String cid) {
        Classt classt=classtDao.selectById(cid);
        return classt;
    }

    @Override
    public Boolean update(Classt classt) {
        int i=classtDao.update(classt);
        boolean flag=false;
        if(i==1){
            flag=true;
        }
        return flag;
    }

    @Override
    public int deleteById(String cid) {
        int i=classtDao.deleteById(cid);
        return i;
    }
}
