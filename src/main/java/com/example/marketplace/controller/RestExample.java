package com.example.marketplace.controller;

import com.example.marketplace.commands.GetDealByIdCommand;
import com.example.marketplace.views.DealInfoView;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@CrossOrigin("*")
@RestController
public class RestExample {

    @PostMapping("/test-not-null")
    public DealInfoView testNotNull(@Valid @RequestBody GetDealByIdCommand request) throws IOException {
        try {
            request.execute();
            return new DealInfoView("", null);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return new DealInfoView(e.getMessage(), null);
        }
    }
}