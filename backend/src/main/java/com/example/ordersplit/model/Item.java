package com.example.ordersplit.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.*;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private double weight;

    //Getters and setters
    public Long getId() {return id;}
    public String getName() {return name;}
    public double getPrice() {return price;}
    public double getWeight() {return weight;}

    public void setId(Long id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setPrice(double price) {this.price = price;}
    public void setWeight(double weight) {this.weight = weight;}
}