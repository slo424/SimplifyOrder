package com.example.marketplace.views;

import com.example.marketplace.models.Category;
import lombok.Getter;

import java.util.List;

@Getter
public class DealInfoListView {

    private List<Category> bisCategories;
    private List<String> campaigns;
    private List<DealMerchantView> deals;

    public DealInfoListView(List<Category>bixCategories, List<String>campaigns, List<DealMerchantView>merchantDealsViewList) {
        this.bisCategories = bixCategories;
        this.campaigns = campaigns;
        this.deals = merchantDealsViewList;
    }

}
