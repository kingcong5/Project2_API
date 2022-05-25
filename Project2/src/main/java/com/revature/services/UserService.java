package com.revature.services;

import java.util.List;

import com.revature.models.User;

public interface UserService {

	//public User login(String username, String password);
	
	public boolean createUser(User user);
	
	public User findUserById(int id);
	
	public List<User> findAllUsers();
	
	public boolean updateUser(User user);
	
	public boolean deleteUser(User user);
}
