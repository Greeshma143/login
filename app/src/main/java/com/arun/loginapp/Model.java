package com.arun.loginapp;

public class Model {
   public String na,ph,pl,us,pa,em;

    public Model() {
    }

    public Model(String na, String ph, String pl, String us, String pa, String em) {
        this.na = na;
        this.ph = ph;
        this.pl = pl;
        this.us = us;
        this.pa = pa;
        this.em = em;
    }

    public String getNa() {
        return na;
    }

    public void setNa(String na) {
        this.na = na;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getPl() {
        return pl;
    }

    public void setPl(String pl) {
        this.pl = pl;
    }

    public String getUs() {
        return us;
    }

    public void setUs(String us) {
        this.us = us;
    }

    public String getPa() {
        return pa;
    }

    public void setPa(String pa) {
        this.pa = pa;
    }

    public String getEm() {
        return em;
    }

    public void setEm(String em) {
        this.em = em;
    }
}
