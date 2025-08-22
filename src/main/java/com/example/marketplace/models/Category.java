package com.example.marketplace.models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class Category {

    private Long id;

    private String enumValue;
    private String text;
    private List<Long> dealIds;

    private List<Merchant> merchants;

    public Category(Long id, String enumValue) {
        Random random = new Random();

        this.id = id;
        this.enumValue = enumValue;
        this.text = enumValue;
        this.dealIds = new ArrayList<>();
        // Generates random integers 0 to 49
        for (int i=0; i<10; i++) {
            dealIds.add(random.nextLong(10) + 1);
        }
    }
}
