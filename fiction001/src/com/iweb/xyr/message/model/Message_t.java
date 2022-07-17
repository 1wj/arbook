package com.iweb.xyr.message.model;

public class Message_t {
    private String mid;
    private String sendtime;
    private String message;
    private String senderid;
    private String aid;

    @Override
    public String toString() {
        return "Message_t{" +
                "mid='" + mid + '\'' +
                ", sendtime='" + sendtime + '\'' +
                ", message='" + message + '\'' +
                ", senderid='" + senderid + '\'' +
                ", aid='" + aid + '\'' +
                '}';
    }

    public Message_t() {
    }

    public Message_t(String mid, String sendtime, String message, String senderid, String aid) {
        this.mid = mid;
        this.sendtime = sendtime;
        this.message = message;
        this.senderid = senderid;
        this.aid = aid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getSendtime() {
        return sendtime;
    }

    public void setSendtime(String sendtime) {
        this.sendtime = sendtime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSenderid() {
        return senderid;
    }

    public void setSenderid(String senderid) {
        this.senderid = senderid;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }
}
