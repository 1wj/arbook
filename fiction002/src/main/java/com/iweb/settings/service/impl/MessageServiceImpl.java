package com.iweb.settings.service.impl;

import com.iweb.settings.dao.MessageDao;
import com.iweb.settings.domain.Messaget;
import com.iweb.settings.service.MessageService;
import com.iweb.settings.vo.PageVO;
import com.iweb.utils.SqlSessionUtil;

import java.util.List;
import java.util.Map;

public class MessageServiceImpl implements MessageService {
    MessageDao messageDao= SqlSessionUtil.getSqlSession().getMapper(MessageDao.class);
    @Override
    public PageVO<Messaget> selectList(Map<String, Object> map) {
        //查类别对象
        List<Messaget> list=messageDao.selectList( map);
        //查数量
        int count=messageDao.queryCount(map);

        PageVO<Messaget> pageVO=new PageVO();

        pageVO.setuList(list);
        //设置总条数
        pageVO.setRecodeCount(count);
        //设置总页数
        pageVO.setTotal();

        return pageVO;
    }

    @Override
    public int deleteById(String mid) {
        int i=messageDao.deleteById(mid);
        return i;
    }

    @Override
    public Messaget selectById(String mid) {
        Messaget messaget=messageDao.selectById(mid);
        return messaget;
    }




    @Override
    public Boolean sendById(Messaget messaget) {
        //查询成需要发送的信息数
        //int count1=messageDao.selectByIds(list);
        //发送信息，实际上收到的备注数
        int count2=messageDao.sendById(messaget);
        Boolean flag=false;
        /*if(count1==count2){
            flag=true;
        }*/
        if(count2==1){
            flag=true;
        }
        return flag;
    }
}
