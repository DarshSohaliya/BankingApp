package com.example.Bank.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transactionId;

    private long acNo;
    private Date date;
    private double amount;
    private String type;




    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setAcNo(long acNo) {
        this.acNo = acNo;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getAcNo() {
        return acNo;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }
}
