package com.uic.userservice.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String name;

    public User(String name, String id, String email, String phone, String SSN, String address) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.ssn = SSN;
        this.address = address;
        this.wishlistItems = new ArrayList<>();
        this.cart = new ArrayList<>();
    }

    private String id;

    private String email;

    private String phone;

    private String ssn;

    private String address;

    private String passwordHash;

    private List<String> rentedProductIds;

    private List<WishlistItem> wishlistItems;

    private List<CartItem> cart;

    public List<WishlistItem> getWishlistItems() {
        return wishlistItems;
    }


    public void addWishlistItem(WishlistItem item) {
        this.wishlistItems.add(item);
    }


    public List<String> getRentedProductIds() {
        return rentedProductIds;
    }

    public void setRentedProductIds(List<String> rentedProductIds) {
        this.rentedProductIds = rentedProductIds;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public List<CartItem> getCartItems() {
        return cart;
    }

    public void addCartItem(CartItem cartItem) {
        this.cart.add(cartItem);
    }
}
