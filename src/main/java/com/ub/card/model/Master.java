package com.ub.card.model;

/**
 * Created by matshedisoo on 5/20/2016.
 */
public class Master {

    private String MST_SQ;
    private String MST_TITLE;
    private String MST_FIRSTNAME;
    private String MST_MIDDLENAME;
    private String MST_LASTNAME;
    private String MST_SUFFIX;
    private String MST_GENDER;
    private String MST_TYPE;
    private String MST_CURRENT;
    private String SITE_SLA;
    private String MST_ID;

    public Master() {
    }

    public Master(String MST_SQ, String MST_TITLE, String MST_FIRSTNAME, String MST_MIDDLENAME, String MST_LASTNAME, String MST_SUFFIX, String MST_GENDER, String MST_TYPE, String MST_CURRENT, String SITE_SLA, String MST_ID) {
        this.MST_SQ = MST_SQ;
        this.MST_TITLE = MST_TITLE;
        this.MST_FIRSTNAME = MST_FIRSTNAME;
        this.MST_MIDDLENAME = MST_MIDDLENAME;
        this.MST_LASTNAME = MST_LASTNAME;
        this.MST_SUFFIX = MST_SUFFIX;
        this.MST_GENDER = MST_GENDER;
        this.MST_TYPE = MST_TYPE;
        this.MST_CURRENT = MST_CURRENT;
        this.SITE_SLA = SITE_SLA;
        this.MST_ID = MST_ID;
    }

    public String getMST_SQ() {
        return MST_SQ;
    }

    public void setMST_SQ(String MST_SQ) {
        this.MST_SQ = MST_SQ;
    }

    public String getMST_TITLE() {
        return MST_TITLE;
    }

    public void setMST_TITLE(String MST_TITLE) {
        this.MST_TITLE = MST_TITLE;
    }

    public String getMST_FIRSTNAME() {
        return MST_FIRSTNAME;
    }

    public void setMST_FIRSTNAME(String MST_FIRSTNAME) {
        this.MST_FIRSTNAME = MST_FIRSTNAME;
    }

    public String getMST_MIDDLENAME() {
        return MST_MIDDLENAME;
    }

    public void setMST_MIDDLENAME(String MST_MIDDLENAME) {
        this.MST_MIDDLENAME = MST_MIDDLENAME;
    }

    public String getMST_LASTNAME() {
        return MST_LASTNAME;
    }

    public void setMST_LASTNAME(String MST_LASTNAME) {
        this.MST_LASTNAME = MST_LASTNAME;
    }

    public String getMST_SUFFIX() {
        return MST_SUFFIX;
    }

    public void setMST_SUFFIX(String MST_SUFFIX) {
        this.MST_SUFFIX = MST_SUFFIX;
    }

    public String getMST_GENDER() {
        return MST_GENDER;
    }

    public void setMST_GENDER(String MST_GENDER) {
        this.MST_GENDER = MST_GENDER;
    }

    public String getMST_TYPE() {
        return MST_TYPE;
    }

    public void setMST_TYPE(String MST_TYPE) {
        this.MST_TYPE = MST_TYPE;
    }

    public String getMST_CURRENT() {
        return MST_CURRENT;
    }

    public void setMST_CURRENT(String MST_CURRENT) {
        this.MST_CURRENT = MST_CURRENT;
    }

    public String getSITE_SLA() {
        return SITE_SLA;
    }

    public void setSITE_SLA(String SITE_SLA) {
        this.SITE_SLA = SITE_SLA;
    }

    public String getMST_ID() {
        return MST_ID;
    }

    public void setMST_ID(String MST_ID) {
        this.MST_ID = MST_ID;
    }
}
