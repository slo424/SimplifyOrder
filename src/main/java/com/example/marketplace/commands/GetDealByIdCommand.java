package com.example.marketplace.commands;

import com.example.marketplace.views.DealMerchantView;
import lombok.Getter;
import lombok.Setter;

//import javax.validation.constraints.NotNull;
import jakarta.validation.constraints.NotNull;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@Setter
@Getter
public class GetDealByIdCommand {

//    @NonNull(message = "stringValue has to be present")
//    @NonNull
//    @Null(message = "null???")
//    @NotNull(message = "blah")
//    private String stringValue;

//    @Min(value = 2, message = "too small omg")
    @NotNull
    public Long dealId;

    public DealMerchantView execute() throws IOException {
        if (dealId < 2)
            throw new IOException("Give deal ID is not found");

        Optional<DealMerchantView> dealOpt = Arrays.stream(Command.getDummyDeals())
                .filter(dealMerchantView -> dealMerchantView.getId() == dealId)
                .findFirst();

        if (!dealOpt.isPresent())
            throw new IOException("No deal found for given Deal ID");

        return dealOpt.get();
    }

    // getters, setters
}
