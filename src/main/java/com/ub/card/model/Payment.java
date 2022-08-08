package com.ub.card.model;

public class Payment {

    private String TX_ID;
    private String EMPLID;
    private String ITEM_AMT;
    private String ITEM_TYPE;
    private String REFERENCE;
    private String ACCOUNTING_DATE;
    private String DUE_DATE;
    private String ACCOUNT_TYPE_SF;
    private String STRM;

    public Payment() {
    }

    public Payment(String TX_ID, String EMPLID, String ITEM_AMT, String ITEM_TYPE, String REFERENCE, String ACCOUNTING_DATE, String DUE_DATE, String ACCOUNT_TYPE_SF, String STRM) {
        this.TX_ID = TX_ID;
        this.EMPLID = EMPLID;
        this.ITEM_AMT = ITEM_AMT;
        this.ITEM_TYPE = ITEM_TYPE;
        this.REFERENCE = REFERENCE;
        this.ACCOUNTING_DATE = ACCOUNTING_DATE;
        this.DUE_DATE = DUE_DATE;
        this.ACCOUNT_TYPE_SF = ACCOUNT_TYPE_SF;
        this.STRM = STRM;
    }

    public String getTX_ID() {
        return TX_ID;
    }

    public void setTX_ID(String TX_ID) {
        this.TX_ID = TX_ID;
    }

    public String getEMPLID() {
        return EMPLID;
    }

    public void setEMPLID(String EMPLID) {
        this.EMPLID = EMPLID;
    }

    public String getITEM_AMT() {
        return ITEM_AMT;
    }

    public void setITEM_AMT(String ITEM_AMT) {
        this.ITEM_AMT = ITEM_AMT;
    }

    public String getITEM_TYPE() {
        return ITEM_TYPE;
    }

    public void setITEM_TYPE(String ITEM_TYPE) {
        this.ITEM_TYPE = ITEM_TYPE;
    }

    public String getREFERENCE() {
        return REFERENCE;
    }

    public void setREFERENCE(String REFERENCE) {
        this.REFERENCE = REFERENCE;
    }

    public String getACCOUNTING_DATE() {
        return ACCOUNTING_DATE;
    }

    public void setACCOUNTING_DATE(String ACCOUNTING_DATE) {
        this.ACCOUNTING_DATE = ACCOUNTING_DATE;
    }

    public String getDUE_DATE() {
        return DUE_DATE;
    }

    public void setDUE_DATE(String DUE_DATE) {
        this.DUE_DATE = DUE_DATE;
    }

    public String getACCOUNT_TYPE_SF() {
        return ACCOUNT_TYPE_SF;
    }

    public void setACCOUNT_TYPE_SF(String ACCOUNT_TYPE_SF) {
        this.ACCOUNT_TYPE_SF = ACCOUNT_TYPE_SF;
    }

    public String getSTRM() {
        return STRM;
    }

    public void setSTRM(String STRM) {
        this.STRM = STRM;
    }

}
