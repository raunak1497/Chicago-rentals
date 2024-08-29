package com.uic.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "cart_items")
public class CartItem {
    @Id
    private String id;
    private String userId;
    private String productId;
    private String productName;
    private double productPrice;
    private int quantity;

}
