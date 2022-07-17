package com.iweb.wj.model;

public class Vip {
    private String vipid;
    private String rechargetime;
    private int money;
    private int addday;
    private String userid;

    public Vip() {
    }

    public Vip(String vipid, String rechargetime, int money, int addday, String userid) {
        this.vipid = vipid;
        this.rechargetime = rechargetime;
        this.money = money;
        this.addday = addday;
        this.userid = userid;
    }

    public String getVipid() {
        return vipid;
    }

    public void setVipid(String vipid) {
        this.vipid = vipid;
    }

    public String getRechargetime() {
        return rechargetime;
    }

    public void setRechargetime(String rechargetime) {
        this.rechargetime = rechargetime;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getAddday() {
        return addday;
    }

    public void setAddday(int addday) {
        this.addday = addday;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Vip{" +
                "vipid='" + vipid + '\'' +
                ", rechargetime='" + rechargetime + '\'' +
                ", money=" + money +
                ", addday=" + addday +
                ", userid=" + userid +
                '}';
    }
}
