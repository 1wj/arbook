package com.iweb.zq.Collectlnfo.model;

public class Collect_t {
    private String bid;
    private String userid;
    private String ctime;

    public Collect_t() {
    }

    public Collect_t(String bid, String userid, String ctime) {
        this.bid = bid;
        this.userid = userid;
        this.ctime = ctime;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    @Override
    public String toString() {
        return "Collect_t{" +
                "bid='" + bid + '\'' +
                ", userid='" + userid + '\'' +
                ", ctime='" + ctime + '\'' +
                '}';
    }
}
