package com.example.marketplace.views;

import com.example.marketplace.models.Order;
import java.util.List;
import lombok.Getter;

@Getter
public class TableBillView {

    private Long tableId;

    private List<Order> orders;

    private Long totalInCents;

    public TableBillView(Long tableId, List<Order> orders, Long totalInCents) {
        this.tableId = tableId;
        this.orders = orders;
        this.totalInCents = totalInCents;
    }
}
