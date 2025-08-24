package com.example.marketplace.models;


import com.example.marketplace.enums.OrderStatus;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Orders")
public class Order {
    @Id
    private String id;
    @Setter
    private OrderStatus status;

    @NotNull
    @Length(min = 2)
    private String name;

    @Min(1)
    private Long itemId;
    @Getter
    @NotNull
    private long priceInCents;

    @Getter
    @NotNull
    @Min(1)
    private int qty;
    private Date orderedDate;
    private Date updatedDate;
    @Getter
    private int tableNo;

    public Order(String name, Long itemId, long priceInCents, int qty, int tableNo) {
        this.status = OrderStatus.In;
        this.name = name;
        this.itemId = itemId;
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
