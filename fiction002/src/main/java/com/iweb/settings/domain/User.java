package com.iweb.settings.domain;

public class User {
    private String userid;
    private String uname;
    private String upwd ;
    private String unickname;
    private String aid;
    private String remaindays;
    private String tel;

    public User() {
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "User{" +
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
