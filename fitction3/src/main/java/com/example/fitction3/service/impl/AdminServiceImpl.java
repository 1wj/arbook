package com.example.fitction3.service.impl;



import com.example.fitction3.dao.AdminDao;
import com.example.fitction3.domain.Admin;
import com.example.fitction3.service.AdminService;
import com.example.fitction3.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired(required = false)
    private AdminDao adminDao;

    @Override
    public PageVO<Admin> selectList(Map<String, Object> map) {
        //查类别对象
        List<Admin> list=adminDao.selectList( map);
        //查数量
        int count=adminDao.queryCount(map);

        PageVO<Admin> pageVO=new PageVO();

        pageVO.setuList(list);

        //设置总条数
        pageVO.setRecodeCount(count);
        //设置总页数
        pageVO.setTotal();

        return pageVO;
    }

    @Override
    public Admin selectById(String aid) {
        Admin admin =adminDao.selectById(aid);

        return admin;
    }

    @Override
    public Integer save(Admin admin) {
        int i=adminDao.save(admin);
       return i;
    }

    @Override
    public Admin editById(String aid) {
        Admin admin =adminDao.selectById(aid);
        return admin;
    }

    @Override
    public int updateById(Admin admin) {
        int i=adminDao.updateById(admin);
       return i;
    }

    @Override
    public int deleteById(String aid) {
        int i=adminDao.deleteById(aid);
       return i;
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
