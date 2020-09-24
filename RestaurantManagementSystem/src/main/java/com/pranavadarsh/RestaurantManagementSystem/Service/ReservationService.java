package com.pranavadarsh.RestaurantManagementSystem.Service;

import java.util.List;

import com.pranavadarsh.RestaurantManagementSystem.Entity.Reservation;
import com.pranavadarsh.RestaurantManagementSystem.Model.RequestReservation;

public interface ReservationService {

	public Reservation bookReservation(RequestReservation requestReservation);
	
	public Reservation getReservation(int id);
	
	public Reservation updateReservation(RequestReservation requestReservation,int ReservationId);
	
	public void deleteReservation(int id);

	public List<Reservation> findAllReservations();

	public void saveReservation(Reservation editAdminReservation);

	public void updateReservationforAdmin(Reservation editAdminReservation);
	
	
}
