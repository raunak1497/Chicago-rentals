package com.uic.inventoryservice.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    private String prodId;
    private String productName;
    private  String brand;
    private String productDescription;
    private Double productPrice;
}
