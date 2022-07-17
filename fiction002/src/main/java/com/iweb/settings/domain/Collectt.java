package com.iweb.settings.domain;

public class Collectt {
    private String bid;

    private String userid;

    private String ctime;

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
        return "Collectt{" +
                "bid='" + bid + '\'' +
                ", userid='" + userid + '\'' +
                ", ctime='" + ctime + '\'' +
                '}';
    }
}
