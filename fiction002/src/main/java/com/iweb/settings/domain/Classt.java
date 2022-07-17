package com.iweb.settings.domain;

public class Classt {
    private String cid;
    private String cname;
    private String describe_1;
    private String ccreatetime;

    public Classt() {
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getDescribe_1() {
        return describe_1;
    }

    public void setDescribe_1(String describe_1) {
        this.describe_1 = describe_1;
    }

    public String getCcreatetime() {
        return ccreatetime;
    }

    public void setCcreatetime(String ccreatetime) {
        this.ccreatetime = ccreatetime;
    }

    @Override
    public String toString() {
        return "Classt{" +
                "cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                ", describe_1='" + describe_1 + '\'' +
                ", ccreatetime='" + ccreatetime + '\'' +
                '}';
    }
}
