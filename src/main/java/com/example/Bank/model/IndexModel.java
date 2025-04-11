package com.example.Bank.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Practice")
public class IndexModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    private  int price;
    private int name;
}
