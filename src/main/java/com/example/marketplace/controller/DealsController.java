package com.example.marketplace.controller;

import com.example.marketplace.commands.GetDealByIdCommand;
import com.example.marketplace.commands.GetDealsCommand;
import com.example.marketplace.commands.GetMerchantDealsByMerIdCommand;
import com.example.marketplace.commands.PlaceOrderCommand;
import com.example.marketplace.commands.UpdateDataCommand;
import com.example.marketplace.models.Greeting;
import com.example.marketplace.repositories.OrderRepository;
import com.example.marketplace.views.DealInfoListView;
import com.example.marketplace.views.DealInfoView;
import com.example.marketplace.views.MerchantDealsView;
import com.example.marketplace.views.OrderPlacementView;
import jakarta.validation.Valid;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("deals")
public class DealsController {

    @Autowired
    private OrderRepository orderRepository;

    private static final String template = "Hello, %s!";

    private final AtomicLong counter = new AtomicLong();

    @GetMapping
    public DealInfoListView getDeals(GetDealsCommand getDealsCommand) {
        return getDealsCommand.execute();
    }

    @PostMapping("order")
    public OrderPlacementView placeOrder(@Valid @RequestBody PlaceOrderCommand placeOrderCommand) {
        placeOrderCommand.setOrderRepository(orderRepository);
        return placeOrderCommand.execute();
    }

    @GetMapping("deal")
    public DealInfoView getDealById(@Valid @RequestBody GetDealByIdCommand request) throws IOException {
        try {
            return new DealInfoView("", request.execute());
        } catch (Exception e) {
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
