package com.pranavadarsh.RestaurantManagementSystem.Exception;

public class RestaurantNotFoundException extends RuntimeException {
    public RestaurantNotFoundException(String message) {
        super(message);
    }
}
