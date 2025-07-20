package com.example.ordersplit;

import com.example.ordersplit.model.Item;
import com.example.ordersplit.repository.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner initDatabase(ItemRepository itemRepository) {
        return args -> {
            if (itemRepository.count() == 0) {
                itemRepository.save(new Item("Item 1", 120, 200));
                itemRepository.save(new Item("Item 2", 90, 150));
                itemRepository.save(new Item("Item 3", 110, 180));
                itemRepository.save(new Item("Item 4", 80, 160));
                itemRepository.save(new Item("Item 5", 70, 140));
                itemRepository.save(new Item("Item 6", 40, 10));
                itemRepository.save(new Item("Item 7", 200, 10));
                itemRepository.save(new Item("Item 8", 120, 500));
                // ... add more items as needed
                System.out.println("✅ Items seeded to database.");
            } else {
                System.out.println("ℹ️ Items already exist in database.");
            }
        };
    }
}