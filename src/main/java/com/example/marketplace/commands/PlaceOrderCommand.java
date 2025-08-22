package com.example.marketplace.commands;

import com.example.marketplace.models.SimpleDeal;
import com.example.marketplace.views.*;
import java.util.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.stream.Collectors;

@Getter
@Setter
class SimpleOrder {
    private Long id;

    private int qty;
}

public class PlaceOrderCommand implements Command{
    @Setter
    @NotEmpty(message = "Cart cannot be empty.")
    private SimpleOrder[] cart;

    @Setter
    private String buyerName;

    @Setter
    private String buyerEmail;
    
    @Override
    public SimpleOrderPurchaseView execute() {
        Map<Long, DealMerchantView> deals = Arrays.stream(Command.getDummyDeals())
                .collect(Collectors.toMap(DealMerchantView::getId, simpleDeal -> simpleDeal));

        Long total = 0L;
        for (SimpleOrder simpleOrder : cart) {
            total += (deals.containsKey(simpleOrder.getId()) ? (deals.get(simpleOrder.getId()).getPrice() * simpleOrder.getQty()) : 0L);
        }

        return new SimpleOrderPurchaseView((long) (total*1.05), "");
    }
}

