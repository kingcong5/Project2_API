package com.revature.services;

import java.util.*;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.User;
import com.revature.repositories.UserRepository;


@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	private static Logger log = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	public UserServiceImpl(UserRepository dao) {
		this.userRepo = dao;
	}
	
	// Create new user
	@Override
	public boolean createUser(User user) {
		
		log.info("In service layer: creating new user: " + user);
		
		int pk = userRepo.save(user).getUser_id();
		return (pk > 0) ? true : false;
	}

	// Find user by ID
	@Override
	public User getUserById(int user_id) {
		
		log.info("In service layer: Finding user by id: " + user_id);
		
		return userRepo.findById(user_id);
	}
	
	// Find all users
	@Override
	public List<User> getAllUsers() {
		
		log.info("In service layer: Getting all users...");
		
		return userRepo.findAll();
	}
	
	// Update user
	@Override
	public boolean updateUser(User user) {
		
		log.info("In service layer: Updating user: " + user);
		
		User target = userRepo.findById(user.getUser_id());
		target.setF_name(user.getF_name());
		target.setL_name(user.getL_name());
		target.setFavorite_artist(user.getFavorite_artist());
		target.setUsername(user.getUsername());
		target.setPassword(user.getPassword());
		return (userRepo.save(target) != null) ? true : false;
	}

	// Update user password
	@Override
	public boolean updateUserPassword(User user) {
		
		log.info("In service layer: Updating user password: " + user);
		
		User target = userRepo.findById(user.getUser_id());
		target.setPassword(user.getPassword());
		return (userRepo.save(target) != null) ? true : false;
	}
	
	// Delete User
	@Override
	public boolean deleteUser(User user) {
		
		log.info("In service layer: Deleting user: " + user);
		
		userRepo.delete(user);
		return true;
	}

	// Login User
	@Override
	public User login(String username, String password) {
		
		log.info("In service layer: Logging in user: " + username);
		
		Optional<User> users = userRepo.findAll().stream().filter(u -> (u.getUsername().equals(username) && u.getPassword().equals(password))).findFirst();
		return (users.isPresent() ? users.get() : null);
	}

}
