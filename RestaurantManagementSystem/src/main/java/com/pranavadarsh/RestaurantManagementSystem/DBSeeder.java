/*package com.pranavadarsh.RestaurantManagementSystem;

import java.util.ArrayList;
import java.util.List;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.pranavadarsh.RestaurantManagementSystem.DAO.RestaurantRepository;
import com.pranavadarsh.RestaurantManagementSystem.DAO.UserRepository;
import com.pranavadarsh.RestaurantManagementSystem.Entity.Restaurant;
import com.pranavadarsh.RestaurantManagementSystem.Entity.User;
import com.pranavadarsh.RestaurantManagementSystem.springsecurityjpa.MyUserDetails;
import com.pranavadarsh.RestaurantManagementSystem.springsecurityjpa.UserServiceRepository;


@Component
public class DBSeeder implements CommandLineRunner {

    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;
    
    private final UserServiceRepository userServiceRepository;
   

    public DBSeeder(RestaurantRepository restaurantRepository, UserRepository userRepository,UserServiceRepository userServiceRepository) {
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
        this.userServiceRepository=userServiceRepository;
        }

    @Override
    public void run(String... args) throws Exception {
        User pranav = new User("8057810193", "pranavadarsh95@gmail.com",
                "Pranav", "Adarsh", "pass1");
        User abhinav =new User("8097657845", "Abhinavpriyadarshi08@gmail.com",
                "Abhinav", "Priyadarshi", "pass2");
              

        List<User> users = new ArrayList<>();
        users.add(pranav);
        users.add(abhinav);

        userRepository.saveAll(users);

        Restaurant khanna = new Restaurant("Khanna Paratha Wala","99999999", 6,
    			11,"234234234L","234234234L", "Addr1", "Addr2");
       
        restaurantRepository.save(khanna);
       
       
        
        userServiceRepository.save(new MyUserDetails("pranav", "$2b$10$B0okuWP.UJhfuJoWbgW2j.WOGn2dV0UAV6Rj7.teAoDiXMoHlM0lG", true,
				"USER:ADMIN:RESTAURANT_OWNER"));//password=>pass
		
		userServiceRepository.save(new MyUserDetails("abc", "$2b$10$V5uL19TONOcDLF2WLmKqe.off0J6vZ/9u8IwkcHbAZ.JY5hedC9py", true,
				"USER:RESTAURANT_OWNER"));//password=>1234
	   			
        userServiceRepository.save(new MyUserDetails("pratibha", "$2b$10$U6ejxALR/Gvmlbh7/qtgzu9iDD9.rLAn3MGmJFOLScmCRHn8rN6gG", true,
				"USER"));//password=>pra123
        
    }
}*/