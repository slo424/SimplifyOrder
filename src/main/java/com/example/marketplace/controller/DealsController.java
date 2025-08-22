package com.example.marketplace.controller;


import com.example.marketplace.commands.GetDealByIdCommand;
import com.example.marketplace.commands.GetDealsCommand;
import com.example.marketplace.commands.PlaceOrderCommand;
import com.example.marketplace.commands.GetMerchantDealsByMerIdCommand;
import com.example.marketplace.commands.UpdateDataCommand;
import com.example.marketplace.models.Greeting;
import com.example.marketplace.views.*;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("deals")
public class DealsController {

    private static final String template = "Hello, %s!";

    private final AtomicLong counter = new AtomicLong();

    @GetMapping
    public DealInfoListView getDeals(GetDealsCommand getDealsCommand) {
        return getDealsCommand.execute();
    }

    @PostMapping("order")
    public SimpleOrderPurchaseView placeOrder(@Valid @RequestBody PlaceOrderCommand placeOrderCommand) {
        return placeOrderCommand.execute();
    }

    @GetMapping("deal")
    public DealInfoView getDealById(@Valid @RequestBody GetDealByIdCommand request) throws IOException {
        try {;
            return new DealInfoView("", request.execute());
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return new DealInfoView(e.getMessage(), null);
        }
    }

    @GetMapping("/{id}")
    public MerchantDealsView getDealById(@PathVariable Long id, @Valid @RequestBody GetMerchantDealsByMerIdCommand getDealByIdCommand) {
        getDealByIdCommand.setMerchantId(id);
        return getDealByIdCommand.execute();
    }

    @PostMapping("/data")
    public void handleData(@RequestBody UpdateDataCommand updateDataCommand) {
        updateDataCommand.execute();
    }

    @GetMapping("/greeting-javaconfig")
    public Greeting greetingWithJavaconfig(@RequestParam(required = false, defaultValue = "World") String name) {
        System.out.println("==== get greeting ====");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
