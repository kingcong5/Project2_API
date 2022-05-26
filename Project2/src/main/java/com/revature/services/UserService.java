package com.revature.services;

import java.util.List;

import com.revature.models.User;

public interface UserService {

	// Create new user
	boolean createUser(User user);
	
	// Find user by ID
	User getUserById(int user_id);
	
	// Find all users
	List<User> getAllUsers();
	
	// Update user
	boolean updateUser(User user);
	
	// Update user password
	boolean updateUserPassword(User user);
	
	// Delete User
	boolean deleteUser(User user);
	
}
