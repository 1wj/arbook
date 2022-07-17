package com.iweb.xyr.receive_t.model;

public class Receive_t {
    private String userid;
    private String mid;

    @Override
    public String toString() {
        return "Receive_t{" +
                "userid='" + userid + '\'' +
                ", mid='" + mid + '\'' +
                '}';
    }

    public Receive_t(String sql, String userid, String mid) {
    }

    public Receive_t(String userid, String mid) {
        this.userid = userid;
        this.mid = mid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }
}
