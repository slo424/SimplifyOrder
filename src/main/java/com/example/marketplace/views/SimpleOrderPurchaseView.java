package com.example.marketplace.views;

import lombok.Getter;

@Getter
public class SimpleOrderPurchaseView {

    private Long totalChargedInLong;

    private String errorMessage;

    public SimpleOrderPurchaseView(Long totalInCents, String errorMsg) {
        this.totalChargedInLong = totalInCents;
        this.errorMessage = errorMsg;
    }
}
