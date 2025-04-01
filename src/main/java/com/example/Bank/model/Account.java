package com.example.Bank.model;

import jakarta.persistence.*;

import java.util.Random;

@Entity
@Table(name = "bank")
public class Account {

    private String name;

    @Id
    private long acNo;

    @Column(nullable = false)
    private double balance;


    public void setName(String name) {
        this.name = name;
    }

    public void setAcNo(long acNo) {
        this.acNo = acNo;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }



    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public long getAcNo() {
        return acNo;
    }



}
