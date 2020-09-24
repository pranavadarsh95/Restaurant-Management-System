package com.pranavadarsh.RestaurantManagementSystem.DAO;

import org.springframework.data.jpa.repository.JpaRepository;


import com.pranavadarsh.RestaurantManagementSystem.Entity.Restaurant;


public interface RestaurantRepository extends JpaRepository<Restaurant,Integer>{

	Restaurant findByContactNumber(String restaurantContactNumber);

}
