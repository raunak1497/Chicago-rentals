package com.uic.userservice.service;

import com.uic.userservice.exception.UserNotFoundException;
import com.uic.userservice.model.CartItem;
import com.uic.userservice.model.User;
import com.uic.userservice.model.WishlistItem;
import com.uic.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPasswordHash());
        user.setPasswordHash(encodedPassword);
        return userRepository.save(user);
    }

    @Override
    public boolean validateUserLogin(String email, String rawPassword) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return passwordEncoder.matches(rawPassword, user.getPasswordHash());
    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<String> getRentedProductIds(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));

        return user.getRentedProductIds();
    }

    @Override
    public void changePassword(String userId, String oldPassword, String newPassword) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        if (passwordEncoder.matches(oldPassword, user.getPasswordHash())) {
            user.setPasswordHash(passwordEncoder.encode(newPassword));
            userRepository.save(user);
        } else {
            throw new IllegalArgumentException("Old password is incorrect");
        }
    }

    @Override
    public void resetPassword(String email, String newPassword) {
        User user = Optional.ofNullable(userRepository.findByEmail(email))
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        user.setPasswordHash(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }

    @Override
    public List<WishlistItem> getUserWishListItems(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        return user.getWishlistItems();
    }

    @Override
    public User addWishlistItem(String userId, WishlistItem wishlistItem) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        user.addWishlistItem(wishlistItem);
        return userRepository.save(user);
    }

    @Override
    public void removeWishlistItem(String userId, String productId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        user.getWishlistItems().removeIf(item -> item.getProductId().equals(productId));
        userRepository.save(user);
    }

    @Override
    public List<CartItem> getCartItems(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        return user.getCartItems();
    }

    @Override
    public User addCartItem(String userId, CartItem cartItem) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        user.addCartItem(cartItem);
        return userRepository.save(user);
    }

    @Override
    public void removeCartItem(String userId, String productId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        user.getCartItems().removeIf(item -> item.getProductId().equals(productId));
        userRepository.save(user);
    }

}
