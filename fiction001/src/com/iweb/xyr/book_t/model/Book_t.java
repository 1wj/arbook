package com.iweb.xyr.book_t.model;

public class Book_t {
    private String bid;
    private String bname;
    private String bproperty;
    private String author;
    private String isvip;
    private int page;
    private String bcreatetime;
    private String status;
    private String publishtime;

    public Book_t(String bid, String bname, String bproperty, String author, String isvip, int page, String bcreatetime, String status, String publishtime) {
        this.bid = bid;
        this.bname = bname;
        this.bproperty = bproperty;
        this.author = author;
        this.isvip = isvip;
        this.page = page;
        this.bcreatetime = bcreatetime;
        this.status = status;
        this.publishtime = publishtime;
    }

    @Override
    public String toString() {
        return "Book_t{" +
                "bid='" + bid + '\'' +
                ", bname='" + bname + '\'' +
                ", bproperty='" + bproperty + '\'' +
                ", author='" + author + '\'' +
                ", isvip='" + isvip + '\'' +
                ", page='" + page + '\'' +
                ", bcreatetime='" + bcreatetime + '\'' +
                ", status='" + status + '\'' +
                ", publishtime='" + publishtime + '\'' +
                '}';
    }

    public Book_t() {
    }





    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBproperty() {
        return bproperty;
    }

    public void setBproperty(String bproperty) {
        this.bproperty = bproperty;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsvip() {
        return isvip;
    }

    public void setIsvip(String isvip) {
        this.isvip = isvip;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getBcreatetime() {
        return bcreatetime;
    }

    public void setBcreatetime(String bcreatetime) {
        this.bcreatetime = bcreatetime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(String publishtime) {
        this.publishtime = publishtime;
    }
}
