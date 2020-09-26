package com.pranavadarsh.RestaurantManagementSystem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.pranavadarsh.RestaurantManagementSystem.DAO.ReservationRepository;
import com.pranavadarsh.RestaurantManagementSystem.DAO.RestaurantRepository;
import com.pranavadarsh.RestaurantManagementSystem.DAO.UserRepository;
import com.pranavadarsh.RestaurantManagementSystem.Entity.Reservation;
import com.pranavadarsh.RestaurantManagementSystem.Entity.Restaurant;
import com.pranavadarsh.RestaurantManagementSystem.Entity.User;
import com.pranavadarsh.RestaurantManagementSystem.Model.RequestReservation;
import com.pranavadarsh.RestaurantManagementSystem.springsecurityjpa.MyUserDetails;
import com.pranavadarsh.RestaurantManagementSystem.springsecurityjpa.UserServiceRepository;


@Component
public class DBSeeder implements CommandLineRunner {

    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;
    private final ReservationRepository reservationRepository;
    private final UserServiceRepository userServiceRepository;
   

    public DBSeeder(RestaurantRepository restaurantRepository, UserRepository userRepository,UserServiceRepository userServiceRepository,ReservationRepository reservationRepository) {
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
        this.userServiceRepository=userServiceRepository;
        this.reservationRepository=reservationRepository;
        }

    @Override
    public void run(String... args) throws Exception {
    	
    	
    	// Save for User data 
    	
        User pranav = new User("8057810193", "pranavadarsh95@gmail.com",
                "Pranav", "Adarsh", "pass1");
        User abhinav =new User("8097657845", "Abhinavpriyadarshi08@gmail.com",
                "Abhinav", "Priyadarshi", "pass2");
              

        List<User> users = new ArrayList<>();
        users.add(pranav);
        users.add(abhinav);

        userRepository.saveAll(users);

        
        // Save for restaurant data
        
        Restaurant khanna = new Restaurant("Khanna Paratha Wala","9999999999",20, 6,
    			11,"234234234L","234234234L", "Addr1", "Addr2");
        Restaurant samosaWala = new Restaurant("Samosa And Snacks","8888888888",30, 5,
    			12,"289675234L","45680243L", "Haripur delhi", "zummawala rohtak delhi");
      
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(khanna);
        restaurants.add(samosaWala);

        
        restaurantRepository.saveAll(restaurants);
       
       // Book a Reservation for Pranav Adarsh in Khanna Paratha Wala Restaurant 
        
        
        
        Reservation reser= new Reservation(8/*no of person*/,4/*start time*/,5/*end time*/,pranav,khanna);
        reservationRepository.save(reser);
        
        
        // For User Login username and password
        
        userServiceRepository.save(new MyUserDetails("pranav", "$2b$10$B0okuWP.UJhfuJoWbgW2j.WOGn2dV0UAV6Rj7.teAoDiXMoHlM0lG", true,
				"USER:ADMIN:RESTAURANT_OWNER"));//password=>pass
		
		userServiceRepository.save(new MyUserDetails("abc", "$2b$10$V5uL19TONOcDLF2WLmKqe.off0J6vZ/9u8IwkcHbAZ.JY5hedC9py", true,
				"USER:RESTAURANT_OWNER"));//password=>1234
	   			
        userServiceRepository.save(new MyUserDetails("pratibha", "$2b$10$U6ejxALR/Gvmlbh7/qtgzu9iDD9.rLAn3MGmJFOLScmCRHn8rN6gG", true,
				"USER"));//password=>pra123
        
    }
}