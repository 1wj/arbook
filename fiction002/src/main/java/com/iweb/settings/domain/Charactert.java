package com.iweb.settings.domain;

public class Charactert {
    private String bid;
    private String characterid;
    private String charactername;
    private String characterpath;

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getCharacterid() {
        return characterid;
    }

    public void setCharacterid(String characterid) {
        this.characterid = characterid;
    }

    public String getCharactername() {
        return charactername;
    }

    public void setCharactername(String charactername) {
        this.charactername = charactername;
    }

    public String getCharacterpath() {
        return characterpath;
    }

    public void setCharacterpath(String characterpath) {
        this.characterpath = characterpath;
    }

    @Override
    public String toString() {
        return "Character{" +
                "bid='" + bid + '\'' +
                ", characterid='" + characterid + '\'' +
                ", charactername='" + charactername + '\'' +
                ", characterpath='" + characterpath + '\'' +
                '}';
    }
}
