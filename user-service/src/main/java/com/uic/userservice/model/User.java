package com.uic.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class User {

    private String name;

    @Id
    private String id;

    private String email;

    private String phone;

    private String ssn;

    private String address;

    private String passwordHash;

    private List<String> rentedProductIds;

    private List<WishlistItem> wishlistItems;

    private List<CartItem> cart;


    public void addCartItem(CartItem cartItem) {
        this.cart.add(cartItem);
    }
}
