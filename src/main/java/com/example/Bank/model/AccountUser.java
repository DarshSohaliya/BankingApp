package com.example.Bank.model;

public class AccountUser {
    private  double amount;
    private long acNo;

    public long getAcNo() {
        return acNo;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setAcNo(long acNo) {
        this.acNo = acNo;
    }

    public double getAmount() {
        return amount;
    }
}
