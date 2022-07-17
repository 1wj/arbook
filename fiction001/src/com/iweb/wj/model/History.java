package com.iweb.wj.model;

public class History {
    private String userid;
    private String bid;
    private String readtime;

    public History() {
    }

    public History(String userid, String bid, String readtime) {
        this.userid = userid;
        this.bid = bid;
        this.readtime = readtime;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getReadtime() {
        return readtime;
    }

    public void setReadtime(String readtime) {
        this.readtime = readtime;
    }

    @Override
    public String toString() {
        return "History{" +
                "userid='" + userid + '\'' +
                ", bid='" + bid + '\'' +
                ", readtime='" + readtime + '\'' +
                '}';
    }
}
