package com.iweb.wj.service;

import com.iweb.wj.model.Admin;
import com.iweb.wj.model.History;

import java.util.List;

public interface HistoryService {
    //新增一条记录
    public int saveOne(History history);

    //修改一条记录  注意：：
    public int updateOne(History history,String xbid,String readtime,String xuid);

    //删除一条记录
    public int deleteOne(String userId,String bid);

    //根据id查询一条记录
    public List<History> queryByID(String userId);

    //查询全部
    public List<History> queryALL();


}
