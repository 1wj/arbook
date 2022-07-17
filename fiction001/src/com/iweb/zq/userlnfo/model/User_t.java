package com.iweb.zq.userlnfo.model;

public class User_t {
    private String userid;
    private String uname;
    private String upwd;
    private String unickname;
    private String aid;
    private String remaindays;
    private int tel;

    public User_t() {
    }

    public User_t(String userid, String uname, String upwd, String unickname, String aid, String remaindays, int tel) {
        this.userid = userid;
        this.uname = uname;
        this.upwd = upwd;
        this.unickname = unickname;
        this.aid = aid;
        this.remaindays = remaindays;
        this.tel = tel;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getUnickname() {
        return unickname;
    }

    public void setUnickname(String unickname) {
        this.unickname = unickname;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getRemaindays() {
        return remaindays;
    }

    public void setRemaindays(String remaindays) {
        this.remaindays = remaindays;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "User_t{" +
                "userid='" + userid + '\'' +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", unickname='" + unickname + '\'' +
                ", aid='" + aid + '\'' +
                ", remaindays='" + remaindays + '\'' +
                ", tel=" + tel +
                '}';
    }
}
