package com.example.ordersplit.controller;

import com.example.ordersplit.model.Item;
import com.example.ordersplit.model.PackageResponse;
import com.example.ordersplit.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/items")
@CrossOrigin(origins = "*")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    @PostMapping("/placeOrder")
    public List<PackageResponse> placeOrder(@RequestBody List<Item> selectedItems) {
        List<PackageResponse> packages = new ArrayList<>();
        double maxWeightPerPackage = 1000.0;

        selectedItems.sort(Comparator.comparingDouble(Item::getWeight).reversed());

        List<Item> currentPackage = new ArrayList<>();
        double currentWeight = 0.0;
        double currentPrice = 0.0;

        for (Item item : selectedItems) {
            if (currentWeight + item.getWeight() <= maxWeightPerPackage) {
                currentPackage.add(item);
                currentWeight += item.getWeight();
                currentPrice += item.getPrice();
            } else {
                packages.add(buildPackage(currentPackage, currentWeight, currentPrice));
                currentPackage = new ArrayList<>(Collections.singletonList(item));
                currentWeight = item.getWeight();
                currentPrice = item.getPrice();
            }
        }

        if (!currentPackage.isEmpty()) {
            packages.add(buildPackage(currentPackage, currentWeight, currentPrice));
        }

        return packages;
    }

    private PackageResponse buildPackage(List<Item> items, double weight, double price) {
        double courierCharge;
        if (weight <= 200) {
            courierCharge = 5;
        } else if (weight <= 500) {
            courierCharge = 10;
        } else if (weight <= 1000) {
            courierCharge = 15;
        } else {
            courierCharge = 20;
        }

        List<String> itemNames = new ArrayList<>();
        for (Item item : items) {
            itemNames.add(item.getName());
        }

        return new PackageResponse(itemNames, weight, price, courierCharge);
    }
}
