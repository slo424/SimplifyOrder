package com.example.marketplace.models;

import lombok.Getter;

@Getter
public class Deal {
    private Long id;

    public Deal(Long id) {
        this.id = id;
    }
}
