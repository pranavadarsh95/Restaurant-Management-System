package com.pranavadarsh.RestaurantManagementSystem.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pranavadarsh.RestaurantManagementSystem.Entity.Restaurant;

@Repository
public class RestaurantRepositoryImpl {

	@Autowired
	RestaurantRepository restaurantRepository;
	
	public RestaurantRepositoryImpl(RestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository;
	}

	public Restaurant saveRestaurants(Restaurant restaurant) {
		
		return restaurantRepository.save(restaurant);
	}

	public List<Restaurant> findAllRestaurants() {
		
		return restaurantRepository.findAll();
	}

	public Restaurant findRestaurantById(int id) {
		
		return restaurantRepository.findById(id).get();
	}

	public Restaurant updateRestaurant(Restaurant restaurant) {
		
		return restaurantRepository.save(restaurant);
	}

	public void deleteRestaurant(int id) {
		
		restaurantRepository.deleteById(id);
	}

}
