package com.pranavadarsh.RestaurantManagementSystem.DAO;

import org.springframework.data.jpa.repository.JpaRepository;


import com.pranavadarsh.RestaurantManagementSystem.Entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {

	User findByContactNumber(String userContactNumber);

}
