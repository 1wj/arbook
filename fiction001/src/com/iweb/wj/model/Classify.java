package com.iweb.wj.model;

public class Classify {
    private String bid;
    private String cid;

    public Classify() {
    }

    public Classify(String bid, String cid) {
        this.bid = bid;
        this.cid = cid;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    @Override
    public String toString() {
        return "Classify{" +
                "bid='" + bid + '\'' +
                ", cid='" + cid + '\'' +
                '}';
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
}
