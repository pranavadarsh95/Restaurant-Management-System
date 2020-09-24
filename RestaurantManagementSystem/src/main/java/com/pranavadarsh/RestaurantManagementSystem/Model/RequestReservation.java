package com.pranavadarsh.RestaurantManagementSystem.Model;

public class RequestReservation {

	private String userContactNumber;
    private String restaurantContactNumber;
    private int startTime;
    private int duration;
    private int numberOfPerson;
	
    public RequestReservation() {
		
	}
    
	public RequestReservation(String userContactNumber, String restaurantContactNumber, int startTime, int duration,
			int numberOfPerson) {
		this.userContactNumber = userContactNumber;
		this.restaurantContactNumber = restaurantContactNumber;
		this.startTime = startTime;
		this.duration = duration;
		this.numberOfPerson = numberOfPerson;
	}

	public String getUserContactNumber() {
		return userContactNumber;
	}

	public void setUserContactNumber(String userContactNumber) {
		this.userContactNumber = userContactNumber;
	}

	public String getRestaurantContactNumber() {
		return restaurantContactNumber;
	}

	public void setRestaurantContactNumber(String restaurantContactNumber) {
		this.restaurantContactNumber = restaurantContactNumber;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getNumberOfPerson() {
		return numberOfPerson;
	}

	public void setNumberOfPerson(int numberOfPerson) {
		this.numberOfPerson = numberOfPerson;
	}
	
	
}
