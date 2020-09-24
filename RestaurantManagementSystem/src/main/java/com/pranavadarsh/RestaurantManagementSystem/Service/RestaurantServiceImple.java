package com.pranavadarsh.RestaurantManagementSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pranavadarsh.RestaurantManagementSystem.DAO.RestaurantRepositoryImpl;
import com.pranavadarsh.RestaurantManagementSystem.Entity.Restaurant;


@Service
public class RestaurantServiceImple implements RestaurantService {

	@Autowired
	RestaurantRepositoryImpl restaurantRepositoryImpl;

	public RestaurantServiceImple(RestaurantRepositoryImpl restaurantRepositoryImpl) {
		this.restaurantRepositoryImpl = restaurantRepositoryImpl;
	}

	@Override
	public Restaurant saveRestaurants(Restaurant restaurant) {
		
		return restaurantRepositoryImpl.saveRestaurants(restaurant);
	}

	@Override
	public List<Restaurant> findAllRestaurants() {
		
		return restaurantRepositoryImpl.findAllRestaurants();
	}

	@Override
	public Restaurant findRestaurantById(int id) {
		
		return restaurantRepositoryImpl.findRestaurantById(id);
	}

	@Override
	public Restaurant updateRestaurant(Restaurant restaurant) {
		
		return restaurantRepositoryImpl.updateRestaurant(restaurant);
	}

	@Override
	public void deleteRestaurant(int id) {
	
		restaurantRepositoryImpl.deleteRestaurant(id);		
	}

	
	
}
