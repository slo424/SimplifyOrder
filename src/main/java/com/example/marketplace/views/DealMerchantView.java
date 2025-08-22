package com.example.marketplace.views;

import com.example.marketplace.models.Merchant;
import lombok.Getter;

@Getter
public class DealMerchantView {
    Long id;
    Merchant merchant;
    String bonusValType;
    int discountPercent;
    Long key;

    Long price;

    public DealMerchantView(long dealId, long merchantId, String merchantName, long dealKey, long price) {
        this.id = dealId;
        this.merchant = new Merchant(merchantId, merchantName);
        this.bonusValType = "";
        this.discountPercent = 0;
        this.key = dealKey;
        this.price = price;
    }
}
