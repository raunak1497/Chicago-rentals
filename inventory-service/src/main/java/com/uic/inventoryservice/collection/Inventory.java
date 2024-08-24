package com.uic.inventoryservice.collection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
