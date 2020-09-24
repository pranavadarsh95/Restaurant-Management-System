package com.pranavadarsh.RestaurantManagementSystem.springsecurityjpa;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserServiceRepository extends JpaRepository<MyUserDetails, Integer> {

    MyUserDetails findByUserName(String username);
}
