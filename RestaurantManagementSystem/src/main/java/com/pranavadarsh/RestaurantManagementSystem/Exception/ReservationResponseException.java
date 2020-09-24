package com.pranavadarsh.RestaurantManagementSystem.Exception;


public class ReservationResponseException {

	private String message;

	
	
	public ReservationResponseException() {
	}

	
	
	public ReservationResponseException(String message) {
		this.message = message;
	}

	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
