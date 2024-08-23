package com.uic.userservice.controller;

import com.uic.userservice.model.CartItem;
import com.uic.userservice.model.User;
import com.uic.userservice.model.WishlistItem;
import com.uic.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        System.out.println("added user with id: " + user.getName());
        return userService.registerUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.findUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user) {
        user.setId(id);
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}/rented-products")
    public List<String> getRentedProducts(@PathVariable String userId) {
        return userService.getRentedProductIds(userId);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        boolean isValidUser = userService.validateUserLogin(user.getEmail(), user.getPasswordHash());
        if (isValidUser) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    @GetMapping("/{userId}/wishlist")
    public List<WishlistItem> getUserWishListItems(@PathVariable String userId) {
        return userService.getUserWishListItems(userId);
    }

    @PostMapping("/{userId}/wishlist")
    public User addWishlistItem(@PathVariable String userId, @RequestBody WishlistItem wishlistItem) {
        return userService.addWishlistItem(userId, wishlistItem);
    }

    @DeleteMapping("/{userId}/wishlist/{productId}")
    public void removeWishlistItem(@PathVariable String userId, @PathVariable String productId) {
        userService.removeWishlistItem(userId, productId);
    }

    @GetMapping("/{userId}/cart")
    public List<CartItem> getCartItems(@PathVariable String userId) {
        return userService.getCartItems(userId);
    }

    @PostMapping("/{userId}/cart")
    public User addCartItem(@PathVariable String userId, @RequestBody CartItem cartItem) {
        return userService.addCartItem(userId, cartItem);
    }

    @DeleteMapping("/{userId}/cart/{productId}")
    public void removeCartItem(@PathVariable String userId, @PathVariable String productId) {
        userService.removeCartItem(userId, productId);
    }



}
