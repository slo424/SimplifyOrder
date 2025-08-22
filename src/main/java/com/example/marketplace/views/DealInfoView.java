package com.example.marketplace.views;

import lombok.Getter;

@Getter
public class DealInfoView {
    private String message;
    private DealMerchantView deal;

    public DealInfoView(String message, DealMerchantView deal) {
        this.message = message.length() > 0 ? message : "";
        this.deal = message.length() > 0 ? null : deal;
    }
}
