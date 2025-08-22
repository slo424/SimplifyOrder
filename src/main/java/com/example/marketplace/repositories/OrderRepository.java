package com.example.marketplace.repositories;

import com.example.marketplace.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
    // You can add custom query methods here
    Order findByName(String name);
}