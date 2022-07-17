package com.iweb.fiction.chararcter_t.model;

public class Character_t {
    private String bid;
    private String characterid;
    private String chararctername;
    private String characterpath;

    @Override
    public String toString() {
        return "Character_t{" +
                "bid='" + bid + '\'' +
                ", characterid='" + characterid + '\'' +
                ", chararctername='" + chararctername + '\'' +
                ", characterpath='" + characterpath + '\'' +
                '}';
    }

    public Character_t() {
    }

    public Character_t(String bid, String characterid) {
        this.bid = bid;
        this.characterid = characterid;
    }

    public Character_t(String bid, String characterid, String chararctername, String characterpath) {
        this.bid = bid;
        this.characterid = characterid;
        this.chararctername = chararctername;
        this.characterpath = characterpath;
    }

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

    public String getChararctername() {
        return chararctername;
    }

    public void setChararctername(String chararctername) {
        this.chararctername = chararctername;
    }

    public String getCharacterpath() {
        return characterpath;
    }

    public void setCharacterpath(String characterpath) {
        this.characterpath = characterpath;
    }
}
