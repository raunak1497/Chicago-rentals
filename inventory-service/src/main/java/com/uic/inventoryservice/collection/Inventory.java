package com.uic.inventoryservice.collection;

import org.springframework.data.annotation.Id;

public class Inventory {
    @Id
    private String inventoryId;
    private String productCode;
    private String prodName;
    private Type type;
    private String locationId;
    private Integer quantity;
    private Double price;
    private Double discount;
    private Category category;
}
