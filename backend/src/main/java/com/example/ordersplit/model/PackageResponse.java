package com.example.ordersplit.model;

import java.util.List;

public class PackageResponse {
    private List<String> items;
    private double totalWeight;
    private double totalPrice;
    private double courierPrice;

    public PackageResponse(List<String> items, double totalWeight, double totalPrice, double courierPrice) {
        this.items = items;
        this.totalWeight = totalWeight;
        this.totalPrice = totalPrice;
        this.courierPrice = courierPrice;
    }

    public List<String> getItems() { return items; }
    public double getTotalWeight() { return totalWeight; }
    public double getTotalPrice() { return totalPrice; }
    public double getCourierPrice() { return courierPrice; }
}
