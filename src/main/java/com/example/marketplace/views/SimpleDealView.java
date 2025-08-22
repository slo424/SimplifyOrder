package com.example.marketplace.views;

import com.example.marketplace.models.SimpleDeal;
import lombok.Getter;

import java.util.List;

@Getter
public class SimpleDealView {

    private List<SimpleDeal> deals;

    public SimpleDealView(List<SimpleDeal> deals) {
        this.deals = deals;
    }
}
