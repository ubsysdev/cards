package com.ub.card.model;

/**
 * Created by Matshedisoo on 6/28/2016.
 */
public class Term {

    private String STRMA;
    private String STRMB;

    public Term() {
    }

    public Term(String STRMA,String STRMB) {
        this.STRMA = STRMA;
        this.STRMB = STRMB;
    }

    public String getSTRMB() {
        return STRMB;
    }

    public void setSTRMB(String STRMB) {
        this.STRMB = STRMB;
    }

    public String getSTRMA() {
        return STRMA;
    }

    public void setSTRMA(String STRMA) {
        this.STRMA = STRMA;
    }

    @Override
    public String toString() {
        return "Term{" +
                "STRMA='" + STRMA + '\'' +
                ", STRMB='" + STRMB + '\'' +
                '}';
    }
}
