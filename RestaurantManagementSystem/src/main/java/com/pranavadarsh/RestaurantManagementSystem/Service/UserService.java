package com.pranavadarsh.RestaurantManagementSystem.Service;

import java.util.List;

import com.pranavadarsh.RestaurantManagementSystem.Entity.User;

public interface UserService {
   
   public User saveUsers(User user);	
  
   public List<User> findAllUsers();
   
   public User findUserById(int id);
   
   public User updateUser(User user);
   
   public void deleteUser(int id);
}
