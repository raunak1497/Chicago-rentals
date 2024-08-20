package com.uic.userservice.service;

import com.uic.userservice.model.CartItem;
import com.uic.userservice.model.User;
import com.uic.userservice.model.WishlistItem;

import java.util.List;

public interface UserService {
    User registerUser(User user);

    boolean validateUserLogin(String email, String rawPassword);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(String id);

    User findUserById(String id);

    List<String> getRentedProductIds(String userId);

    void changePassword(String userId, String oldPassword, String newPassword);

    void resetPassword(String email, String newPassword);

    List<WishlistItem> getUserWishListItems(String userId);

    User addWishlistItem(String userId, WishlistItem wishlistItem);

    void removeWishlistItem(String userId, String productId);

    List<CartItem> getCartItems(String userId);

    User addCartItem(String userId, CartItem cartItem);

    void removeCartItem(String userId, String productId);
}
