package com.pranavadarsh.RestaurantManagementSystem.Common;

public enum ResponseEnum {
	TABLE_UNAVAILABLE("Demanded Number of tables cann't be allocated presently."),
    RESERVATION_ALREADY_BOOKED("Reservation for same request is already booked"),
    INVALID_RESERVATION_ID("Reservation id is invalid. Please pass correct reservation id"),
	RESTAURANT_ISCLOSED("Restaurant is currently not taking orders! Sorry for inconvience"),
	ENTERED_VALUE_ISWRONG("Please verify number of persons!!!");
    String message;

    ResponseEnum(String message) {
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
