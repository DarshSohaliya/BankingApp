package com.example.Bank.model;

public class TransactionDTO {
    private long senderAcNo;
    private long RecieverAcNo;
    private double amount;

    public long getSenderAcNo() {
        return senderAcNo;
    }

    public void setSenderAcNo(long senderAcNo) {
        this.senderAcNo = senderAcNo;
    }

    public long getRecieverAcNo() {
        return RecieverAcNo;
    }

    public void setRecieverAcNo(long recieverAcNo) {
        RecieverAcNo = recieverAcNo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
