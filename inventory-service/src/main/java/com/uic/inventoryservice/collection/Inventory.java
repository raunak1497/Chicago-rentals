package com.uic.inventoryservice.collection;

import org.springframework.data.annotation.Id;

public class Inventory {
    @Id
    private Integer inventoryId;
    private String prodCode;
    private String prodName;
    private Type type;
    private Location location;
    private Integer quantity;
    private Double price;
    private Double discount;
}
