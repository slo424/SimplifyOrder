package com.example.marketplace.commands;

import com.example.marketplace.views.DealMerchantView;
import com.example.marketplace.views.MerchantDealsView;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GetMerchantDealsByMerIdCommand implements Command{
    @Setter
    private Long merchantId;

    @Override
    public MerchantDealsView execute() {
        List<DealMerchantView> merchantList = Arrays.stream(Command.getDummyDeals())
                .filter(dealMerchantView -> Objects.equals(dealMerchantView.getMerchant().getId(), merchantId))
                .collect(Collectors.toList());

        return new MerchantDealsView(merchantList);
    }
}
