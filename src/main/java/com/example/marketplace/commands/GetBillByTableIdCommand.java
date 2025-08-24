package com.example.marketplace.commands;

import com.example.marketplace.enums.OrderStatus;
import com.example.marketplace.models.Order;
import com.example.marketplace.repositories.OrderRepository;
import com.example.marketplace.views.TableBillView;
import java.util.List;
import lombok.Setter;

public class GetBillByTableIdCommand implements Command{
    @Setter
    private OrderRepository orderRepository;

    @Setter
    private Long tableNo;

    @Override
    public TableBillView execute() {
        List<Order> orders = orderRepository.findByTableNoAndStatus(tableNo, OrderStatus.In);

        if (orders.size() > 0) {
            orders.forEach(order -> order.setStatus(OrderStatus.Completed) );
            orderRepository.saveAll((orders));
        }

        return new TableBillView(tableNo, orders, getOrderTotal(orders));
    }

    private Long getOrderTotal(List<Order> orders) {
        return orders.stream()
                .mapToLong(order -> order.getQty() * order.getPriceInCents())
                .sum();
    }
}
