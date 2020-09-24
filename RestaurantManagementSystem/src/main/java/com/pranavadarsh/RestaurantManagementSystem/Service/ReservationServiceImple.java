package com.pranavadarsh.RestaurantManagementSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pranavadarsh.RestaurantManagementSystem.DAO.ReservationRepositoryImpl;
import com.pranavadarsh.RestaurantManagementSystem.Entity.Reservation;
import com.pranavadarsh.RestaurantManagementSystem.Model.RequestReservation;

@Service
public class ReservationServiceImple implements ReservationService {

	@Autowired
	ReservationRepositoryImpl reservationRepositoryImpl;

	public ReservationServiceImple(ReservationRepositoryImpl reservationRepositoryImpl) {
		this.reservationRepositoryImpl = reservationRepositoryImpl;
	}

	@Override
	public Reservation bookReservation(RequestReservation requestReservation) {
		
		return reservationRepositoryImpl.bookReservation(requestReservation);
	}

	@Override
	public Reservation getReservation(int reservationId) {
		
		return reservationRepositoryImpl.getReservation(reservationId);
	}

	@Override
	public Reservation updateReservation(RequestReservation requestReservation,int reservationId) {
		
		return reservationRepositoryImpl.updateReservation(requestReservation, reservationId);
	}

	@Override
	public void deleteReservation(int reservationId) {
		
		reservationRepositoryImpl.deleteReservation(reservationId);
	}

	@Override
	public List<Reservation> findAllReservations() {
		
		return reservationRepositoryImpl.findAllReservations();
	}

	@Override
	public void saveReservation(Reservation reservation) {
		reservationRepositoryImpl.saveReservation(reservation);
		
	}

	@Override
	public void updateReservationforAdmin(Reservation editAdminReservation) {
		reservationRepositoryImpl.updateReservationforAdmin(editAdminReservation);
		
	}
	
	
}
