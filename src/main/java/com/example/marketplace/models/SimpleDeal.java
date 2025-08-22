package com.example.marketplace.models;

import lombok.Getter;

@Getter
public class SimpleDeal {

    private Long id;
    private String name;

    private Long priceInLong;

    private Long originalPriceInLong;

    public SimpleDeal(Long id, String name, Long priceInLong, Long originalPriceInLong) {
        this.id = id;
        this.name = name;
        this.priceInLong = priceInLong;
        this.originalPriceInLong = originalPriceInLong;
    }
}
