package com.pranavadarsh.RestaurantManagementSystem.Service;

import java.util.List;



import com.pranavadarsh.RestaurantManagementSystem.Entity.Restaurant;


public interface RestaurantService {

	   public Restaurant saveRestaurants(Restaurant restaurant);	
	  
	   public List<Restaurant> findAllRestaurants();
	   
	   public Restaurant findRestaurantById(int id);
	   
	   public Restaurant updateRestaurant(Restaurant restaurant);
	   
	   public void deleteRestaurant(int id);
	}
