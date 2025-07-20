package com.example.ordersplit.repository;

import com.example.ordersplit.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
