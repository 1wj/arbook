package com.iweb.wj.model;

public class Admin {
    private String aid;
    private String aname;
    private String apasswd;
    private String anickname;
    private String acreatetime;

    public Admin() {
    }

    public Admin(String aid, String aname, String apasswd, String anickname, String acreatetime) {
        this.aid = aid;
        this.aname = aname;
        this.apasswd = apasswd;
        this.anickname = anickname;
        this.acreatetime = acreatetime;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getApasswd() {
        return apasswd;
    }

    public void setApasswd(String apasswd) {
        this.apasswd = apasswd;
    }

    public String getAnickname() {
        return anickname;
    }

    public void setAnickname(String anickname) {
        this.anickname = anickname;
    }

    public String getAcreatetime() {
        return acreatetime;
    }

    public void setAcreatetime(String acreatetime) {
        this.acreatetime = acreatetime;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "aid='" + aid + '\'' +
                ", aname='" + aname + '\'' +
                ", apasswd='" + apasswd + '\'' +
                ", anickname='" + anickname + '\'' +
                ", acreatetime='" + acreatetime + '\'' +
                '}';
    }
}
