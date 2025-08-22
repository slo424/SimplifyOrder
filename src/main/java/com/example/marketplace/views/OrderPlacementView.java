package com.example.marketplace.views;

import lombok.Getter;

@Getter
public class OrderPlacementView {
    private int noItems;

    private int tableNo;

    private String errorMessage;

    public OrderPlacementView(int noItems, int tableNo, String errorMessage) {
        this.noItems = noItems;
        this.tableNo = tableNo;
        this.errorMessage = errorMessage;
    }
}
