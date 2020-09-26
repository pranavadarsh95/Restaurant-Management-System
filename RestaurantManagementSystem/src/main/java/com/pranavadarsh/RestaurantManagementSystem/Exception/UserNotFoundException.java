package com.pranavadarsh.RestaurantManagementSystem.Exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
