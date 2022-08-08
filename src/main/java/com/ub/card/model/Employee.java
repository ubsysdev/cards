package com.ub.card.model;

/**
 * Created by matshedisoo on 5/20/2016.
 */
public class Employee {

    private String MST_SQ;
    private String MST_EMPLOYER;
    private String MST_DEPTNO;
    private String SITE_SLA;
    private String MST_EMP_EMPLOYEENO;
    private String MST_POSITION;

    public Employee() {
    }

    public Employee(String MST_SQ, String MST_EMPLOYER, String MST_DEPTNO, String SITE_SLA, String MST_EMP_EMPLOYEENO, String MST_POSITION) {
        this.MST_SQ = MST_SQ;
        this.MST_EMPLOYER = MST_EMPLOYER;
        this.MST_DEPTNO = MST_DEPTNO;
        this.SITE_SLA = SITE_SLA;
        this.MST_EMP_EMPLOYEENO = MST_EMP_EMPLOYEENO;
        this.MST_POSITION = MST_POSITION;
    }

    public void setMST_SQ(String MST_SQ) {
        this.MST_SQ = MST_SQ;
    }

    public void setMST_EMPLOYER(String MST_EMPLOYER) {
        this.MST_EMPLOYER = MST_EMPLOYER;
    }

    public void setMST_DEPTNO(String MST_DEPTNO) {
        this.MST_DEPTNO = MST_DEPTNO;
    }

    public void setSITE_SLA(String SITE_SLA) {
        this.SITE_SLA = SITE_SLA;
    }

    public void setMST_EMP_EMPLOYEENO(String MST_EMP_EMPLOYEENO) {
        this.MST_EMP_EMPLOYEENO = MST_EMP_EMPLOYEENO;
    }

    public void setMST_POSITION(String MST_POSITION) {
        this.MST_POSITION = MST_POSITION;
    }

    public String getMST_SQ() {
        return MST_SQ;
    }

    public String getMST_EMPLOYER() {
        return MST_EMPLOYER;
    }

    public String getMST_DEPTNO() {
        return MST_DEPTNO;
    }

    public String getSITE_SLA() {
        return SITE_SLA;
    }

    public String getMST_EMP_EMPLOYEENO() {
        return MST_EMP_EMPLOYEENO;
    }

    public String getMST_POSITION() {
        return MST_POSITION;
    }
}
