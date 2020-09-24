package com.pranavadarsh.RestaurantManagementSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pranavadarsh.RestaurantManagementSystem.DAO.UserRepositoryImpl;
import com.pranavadarsh.RestaurantManagementSystem.Entity.User;

@Service
public class UserServiceImple implements UserService {
 
	@Autowired
	UserRepositoryImpl userRepositoryImpl;
	
	public UserServiceImple(UserRepositoryImpl userRepositoryImpl) {
		this.userRepositoryImpl = userRepositoryImpl;
	}

	@Override
	public User saveUsers(User user) {
		
		return userRepositoryImpl.saveUsers(user);
	}

	@Override
	public List<User> findAllUsers() {
		
		return userRepositoryImpl.findAllUsers();
	}

	@Override
	public User findUserById(int id) {
		
		return userRepositoryImpl.findUserById(id);
	}

	@Override
	public User updateUser(User user) {
		
		return userRepositoryImpl.updateUser(user);
	}

	@Override
	public void deleteUser(int id) {
		userRepositoryImpl.deleteUser(id);
	}
	
	
}
