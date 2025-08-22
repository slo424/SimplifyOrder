package com.example.marketplace.commands;


import com.example.marketplace.views.DealMerchantView;

public interface Command {

    static DealMerchantView[] getDummyDeals() {
        final DealMerchantView[] merchantDealsViewsArr = new DealMerchantView[12];
        merchantDealsViewsArr[0] = new DealMerchantView(1L, 2L, "Apple", 1L, 1000L);
        merchantDealsViewsArr[1] = new DealMerchantView(2L, 4L, "Banana", 2L, 2000L);
        merchantDealsViewsArr[2] = new DealMerchantView(3L, 3L, "Carrot", 3L, 3000L);
        merchantDealsViewsArr[3] = new DealMerchantView(4L, 5L, "Donut", 4L, 4000L);
        merchantDealsViewsArr[4] = new DealMerchantView(5L, 6L, "Egg", 5L, 5000L);
        merchantDealsViewsArr[5] = new DealMerchantView(6L, 7L, "Fish", 6L, 6000L);
        merchantDealsViewsArr[6] = new DealMerchantView(7L, 8L, "Green Pepper", 7L, 7000L);
        merchantDealsViewsArr[7] = new DealMerchantView(8L, 9L, "Ham", 8L, 8000L);
        merchantDealsViewsArr[8] = new DealMerchantView(9L, 10L, "Ice cream", 9L, 9000L);
        merchantDealsViewsArr[9] = new DealMerchantView(10L, 11L, "Jello", 10, 10000L);
        merchantDealsViewsArr[10] = new DealMerchantView(6L, 3L, "Ketchup ", 11L, 6000L);
        merchantDealsViewsArr[11] = new DealMerchantView(9L, 3L, "Lemon", 12L, 9000L);

        return merchantDealsViewsArr;
    }

    public Object execute();
}
