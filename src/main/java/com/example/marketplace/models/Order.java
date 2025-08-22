package com.example.marketplace.models;


import java.util.Date;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Orders")
public class Order {
    private String name;
    private long itemId;
    private long priceInCents;
    private int qty;
    private Date orderedDate;
    private Date updatedDate;
    @Getter
    private int tableNo;

    public Order(String name, long itemID, long priceInCents, int qty, int tableNo) {
        this.name = name;
        this.itemId = itemID;
        this.priceInCents = priceInCents;
        this.qty = qty;
        this.orderedDate = new Date();
        this.updatedDate = new Date();
        this.tableNo = tableNo;
    }

    public void updateQty(int qty) {
        this.qty = qty;
        this.updatedDate = new Date();
    }
}
