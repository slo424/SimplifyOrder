package com.example.marketplace.repositories;

import com.example.marketplace.enums.OrderStatus;
import com.example.marketplace.models.Order;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
    // You can add custom query methods here
    Order findByName(String name);

    List<Order> findByTableNoAndStatus(Long tableNo, OrderStatus in);
}