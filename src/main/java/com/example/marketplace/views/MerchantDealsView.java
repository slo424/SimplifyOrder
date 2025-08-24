package com.example.marketplace.views;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class MerchantDealsView {
    private Long id;

    private String name;

    private List<DealMerchantView> deals;

    private String message;

    public MerchantDealsView(List<DealMerchantView> merchantList) {
        if (merchantList == null || merchantList.size() == 0) {
            this.id = 999L;
            this.name = "";
            deals = new ArrayList<>();
            this.message = "Merchant not found.";
        } else {
            this.id = merchantList.get(0).getMerchant().getId();
            this.name = merchantList.get(0).getMerchant().getName();
            this.deals = merchantList;
            this.message = "";
        }
    }
}
