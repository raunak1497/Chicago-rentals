package com.uic.inventoryservice.collection;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    private String prodId;
    private String productName;
    private  String brand;
    private String prodCode;
    private String productDescription;
    private Double productPrice;
    private String  locationId;
}
