package com.example.marketplace.views;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class MerchantDealsView {
    @Getter
    private Long id;

    @Getter
    private String name;

    @Getter
    private List<DealMerchantView> deals;

    public MerchantDealsView(List<DealMerchantView> merchantList) {
        if (merchantList == null || merchantList.size() == 0) {
            this.id = 999L;
            this.name = "";
            deals = new ArrayList<>();
        }

        this.id = merchantList.get(0).getMerchant().getId();
        this.name = merchantList.get(0).getMerchant().getName();
        this.deals = merchantList;
    }
}
