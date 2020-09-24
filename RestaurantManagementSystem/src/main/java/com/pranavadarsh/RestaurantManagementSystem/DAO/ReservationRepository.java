package com.pranavadarsh.RestaurantManagementSystem.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.pranavadarsh.RestaurantManagementSystem.Entity.Reservation;
import com.pranavadarsh.RestaurantManagementSystem.Entity.Restaurant;
import com.pranavadarsh.RestaurantManagementSystem.Entity.User;


public interface ReservationRepository extends JpaRepository<Reservation,Integer>{

	@Query(value = "SELECT r FROM Reservation r WHERE r.user = :user_id and " +
            "r.restaurant=:restaurant_id and r.bookingStartTime=:booking_start_time and r.bookingEndTime=:booking_end_time")
    public Reservation findReservationByCustomDetails(
            @Param("user_id") User user,
            @Param("restaurant_id") Restaurant restaurant,
            @Param("booking_start_time") int bookingStartTime,
            @Param("booking_end_time") int bookingEndTime);
}
