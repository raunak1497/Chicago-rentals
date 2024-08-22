package com.uic.bookingservice.collection;

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
    public String prodCode;
    public String prodName;
    public Integer quantity;
    public Double price;
    public String locationId;
}
