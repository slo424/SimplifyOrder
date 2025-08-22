package com.example.marketplace.commands;

import com.example.marketplace.models.Order;
import com.example.marketplace.repositories.OrderRepository;
import com.example.marketplace.views.OrderPlacementView;
import javax.validation.constraints.NotEmpty;
import lombok.Setter;

public class PlaceOrderCommand implements Command {

    @Setter
    private OrderRepository orderRepository;

    @Setter
    @NotEmpty(message = "Cart cannot be empty.")
    private Order[] cart;

    @Override
    public OrderPlacementView execute() {
        for (Order order : cart)
            orderRepository.save(order);

        return new OrderPlacementView(cart.length, cart[0].getTableNo(), "");
    }
}