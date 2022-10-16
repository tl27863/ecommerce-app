package com.example.insorma;

public class Transactions {
    private Integer transId;
    private String UID;
    private String PID;
    private String transDate;
    private Integer transQty;

    public Transactions(Integer transId, String UID, String PID, String transDate, Integer transQty) {
        this.transId = transId;
        this.UID = UID;
        this.PID = PID;
        this.transDate = transDate;
        this.transQty = transQty;
    }

    public Integer getTransId() {
        return transId;
    }

    public void setTransId(Integer transId) {
        this.transId = transId;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }

    public String getTransDate() {
        return transDate;
    }

    public void setTransDate(String transDate) {
        this.transDate = transDate;
    }

    public Integer getTransQty() {
        return transQty;
    }

    public void setTransQty(Integer transQty) {
        this.transQty = transQty;
    }
}
