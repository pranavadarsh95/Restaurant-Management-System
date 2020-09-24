package com.pranavadarsh.RestaurantManagementSystem.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="reservation")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="number_of_person")
	private int numberOfPerson;
	
	@Column(name="booking_start_time")
	private int bookingStartTime;
	
	@Column(name="booking_end_time")
	private int bookingEndTime;
	
	
	@ManyToOne(fetch = FetchType.LAZY,cascade= {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH, CascadeType.REFRESH})//,cascade = {CascadeType.ALL}
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade= {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH, CascadeType.REFRESH})//,cascade = {CascadeType.ALL}
	@JoinColumn(name="restaurant_id")
	private Restaurant restaurant;

	public Reservation() {
		
	}

	public Reservation(int numberOfPerson, int bookingStartTime, int bookingEndTime,User user,Restaurant restaurant) {
	
		this.numberOfPerson = numberOfPerson;
		this.bookingStartTime = bookingStartTime;
		this.bookingEndTime = bookingEndTime;
		this.user = user;
		this.restaurant = restaurant;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumberOfPerson() {
		return numberOfPerson;
	}

	public void setNumberOfPerson(int numberOfPerson) {
		this.numberOfPerson = numberOfPerson;
	}

	public int getBookingStartTime() {
		return bookingStartTime;
	}

	public void setBookingStartTime(int bookingStartTime) {
		this.bookingStartTime = bookingStartTime;
	}

	public int getBookingEndTime() {
		return bookingEndTime;
	}

	public void setBookingEndTime(int bookingEndTime) {
		this.bookingEndTime = bookingEndTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	
}
