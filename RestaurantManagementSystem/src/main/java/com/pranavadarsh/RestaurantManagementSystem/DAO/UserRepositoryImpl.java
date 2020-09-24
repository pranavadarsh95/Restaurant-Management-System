package com.pranavadarsh.RestaurantManagementSystem.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pranavadarsh.RestaurantManagementSystem.Entity.User;

@Repository
public class UserRepositoryImpl {

	@Autowired
	UserRepository userRepository;
	
	
	public UserRepositoryImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	
	public User saveUsers(User user) {
		
		return userRepository.save(user);
	}

	public List<User> findAllUsers() {
		
		return userRepository.findAll();
	}

	public User findUserById(int id) {
		
		return userRepository.findById(id).get();
	}

	public User updateUser(User user) {
		    
		return userRepository.save(user);
	}

	public void deleteUser(int id) {
		
		userRepository.deleteById(id);
		
	}

}
