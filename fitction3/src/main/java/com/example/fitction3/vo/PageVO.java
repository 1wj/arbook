package com.example.fitction3.vo;

import java.util.List;

public class PageVO<T> {
    private List<T> uList;
    private int pageSize=3; //每页条数固定了
   // private int pageNo; //当前页数  不需要了
    private int recodeCount; //总条数
    private int total;  //总页数



    public int getPageSize() {
        return pageSize;
    }


    public int getRecodeCount() {
        return recodeCount;
    }

    public void setRecodeCount(int recodeCount) {
        this.recodeCount = recodeCount;
    }

    public List<T> getuList() {
        return uList;
    }

    public void setuList(List<T> uList) {
        this.uList = uList;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal() {
        this.total =(recodeCount % pageSize == 0) ?(recodeCount / pageSize) : (recodeCount / pageSize +1);
    }
}
