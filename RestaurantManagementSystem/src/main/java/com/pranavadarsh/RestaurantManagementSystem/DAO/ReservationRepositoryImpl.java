package com.pranavadarsh.RestaurantManagementSystem.DAO;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pranavadarsh.RestaurantManagementSystem.Entity.Reservation;
import com.pranavadarsh.RestaurantManagementSystem.Entity.Restaurant;
import com.pranavadarsh.RestaurantManagementSystem.Entity.User;
import com.pranavadarsh.RestaurantManagementSystem.Exception.InvalidReservationException;
import com.pranavadarsh.RestaurantManagementSystem.Exception.ReservationAlreadyBookedException;
import com.pranavadarsh.RestaurantManagementSystem.Exception.TableUnAvailableException;
import com.pranavadarsh.RestaurantManagementSystem.Model.RequestReservation;

import static com.pranavadarsh.RestaurantManagementSystem.Common.ResponseEnum.*;

@Repository
public class ReservationRepositoryImpl {
  
	
   Logger log = LoggerFactory.getLogger(ReservationRepositoryImpl.class);
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	RestaurantRepository restaurantRepository;
	
	@Autowired
	UserRepository userRepository;


	public ReservationRepositoryImpl(ReservationRepository reservationRepository,
			RestaurantRepository restaurantRepository, UserRepository userRepository) {
		this.reservationRepository = reservationRepository;
		this.restaurantRepository = restaurantRepository;
		this.userRepository = userRepository;
	}

   // To save reservation detail in Database
	public Reservation bookReservation(RequestReservation requestReservation) {
		
		// Condition 1 - Is Restaurant open?
		
		Restaurant restaurant = restaurantRepository.findByContactNumber(requestReservation.getRestaurantContactNumber().trim());
		if (!restaurant.getIsActive())//if restaurant is closed
           throw new TableUnAvailableException(RESTAURANT_ISCLOSED.getMessage());

		// Condition 2 - table is available
        
		          isTableAvailable(requestReservation,restaurant);
        log.info("Step 1 ");
        User user = userRepository.findByContactNumber(requestReservation.getUserContactNumber().trim());
        log.info("Step 2 ");
        
        // Condition 3 - don't allow more than one booking for one user with same restaurant and time slot
        
        isReservationAlreadyBooked(user,restaurant,requestReservation);
        log.info("Step 3 ");
        Reservation reservation = new Reservation(requestReservation.getNumberOfPerson(), requestReservation.getStartTime(),
        		requestReservation.getStartTime() + requestReservation.getDuration(),user, restaurant);
        log.info("Step 4 ");
        
        return reservationRepository.save(reservation);
	}
	
	
	// helper method for bookReservation
	private void isTableAvailable(RequestReservation requestReservation,Restaurant restaurant) {
		
        int tableAvaliableNumber = restaurant.isTableAvailable(requestReservation.getNumberOfPerson());// this is restaurant class isTableAvailable() method
        log.info("YYYYYYYYYYYYYYYYYYYYYYYYY"+""+tableAvaliableNumber);
        if (tableAvaliableNumber!=Integer.MAX_VALUE)
        {
        	TABLE_UNAVAILABLE.setMessage(TABLE_UNAVAILABLE.getMessage()+" "+"currently available table in Restaurant is "+tableAvaliableNumber);
            throw new TableUnAvailableException(TABLE_UNAVAILABLE.getMessage());
        }
        return;
    }
	
	
	// helper method for bookReservation
	private void isReservationAlreadyBooked(User user, Restaurant restaurant, RequestReservation requestReservation){
        Reservation reservationByCustomDetails = reservationRepository.findReservationByCustomDetails(user, restaurant, requestReservation.getStartTime(),
        		requestReservation.getStartTime() + requestReservation.getDuration());

        if (reservationByCustomDetails!=null){
            throw new ReservationAlreadyBookedException(RESERVATION_ALREADY_BOOKED.getMessage());
        }
    }
	
	
	

	// to fetch a row on the basis of given id from Reservation database
	public Reservation getReservation(int id) {
		
		Optional<Reservation> reservation = reservationRepository.findById(id);
		if(reservation.isPresent())
		{
			return reservation.get();
		}
		else
			throw new InvalidReservationException(INVALID_RESERVATION_ID.getMessage());
	}

	
	
	
	
	
	
	
	
	
	// update already existing detail in Reservation database
	public Reservation updateReservation(RequestReservation requestReservation,int reservationId) {
		
		//checking if givenId is present in Reservation database or not.
		
		Optional<Reservation> reservation =reservationRepository.findById(reservationId);
		if(reservation.isPresent())
		{
			// we are taking data from user in RequestReservation form and saving it into ReservationRepository form.
			Reservation resrv = reservation.get();
	        resrv.setBookingEndTime(requestReservation.getStartTime()+ requestReservation.getDuration());
	        resrv.setNumberOfPerson(requestReservation.getNumberOfPerson());
	        resrv.setBookingStartTime(requestReservation.getStartTime());
	        resrv.setUser(userRepository.findByContactNumber(requestReservation.getUserContactNumber()));
	        resrv.setRestaurant(restaurantRepository.findByContactNumber(requestReservation.getRestaurantContactNumber()));
	        return reservationRepository.save(resrv);
		}
		throw new InvalidReservationException(INVALID_RESERVATION_ID.getMessage());
	}

	
	
	
	
	
	
	
	// delete detail from Reservation database
	public void deleteReservation(int reservationId) {
		
		// free already occupied tables
		Reservation reservation=reservationRepository.findById(reservationId).get();
		
		reservation.getRestaurant().freeAvailableTableCount(reservation.getNumberOfPerson());
		
		//delete record from database
		reservationRepository.deleteById(reservationId);
	}

	public List<Reservation> findAllReservations() {
		
		return reservationRepository.findAll();
	}

	public void saveReservation(Reservation reservation) {
		reservationRepository.save(reservation);
		
	}

	public void updateReservationforAdmin(Reservation editAdminReservation) {
		Restaurant restaurant = restaurantRepository.findById(editAdminReservation.getRestaurant().getId()).get();
		
		Reservation reservation = reservationRepository.findById(editAdminReservation.getId()).get();// will provide database same(editAdminReservation) id based record which hasn't updated yet in database.
		
		restaurant.freeAvailableTableCount(reservation.getNumberOfPerson());// firstly free the table
		
		restaurant.isTableAvailable(editAdminReservation.getNumberOfPerson());// now according to demanded value allocate new table value
		
		
		System.out.println(" Inside updateReservationforAdmin "+restaurant.getAvailableTableCount());
		
		editAdminReservation.getRestaurant().setAvailableTableCount(restaurant.getAvailableTableCount());// we are replacing Restaurant value by the value changed in the reservation
		reservationRepository.save(editAdminReservation);
		
		
	}
	
	
}
