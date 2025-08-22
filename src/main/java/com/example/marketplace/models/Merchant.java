package com.example.marketplace.models;

import lombok.Getter;

import java.util.List;

@Getter
public class Merchant {
    private Long id;

    private String name;

    private String webUrlName;

    private List<Long> dealIds;

    private String bestDealType;

    private String bestDiscount;

    public Merchant(Long id, String name) {
        this.id = id;
        this.name = name;
        this.webUrlName = name;
    }
}
