package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.User;
import com.revature.repositories.UserRepository;


@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	public UserServiceImpl(UserRepository dao) {
		this.userRepo = dao;
	}
	
	// Create new user
	@Override
	public boolean createUser(User user) {
		int pk = userRepo.save(user).getUser_id();
		return (pk > 0) ? true : false;
	}

	// Find user by ID
	@Override
	public User getUserById(int user_id) {
		return userRepo.findById(user_id);
	}
	
	// Find all users
	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	
	// Update user
	@Override
	public boolean updateUser(User user) {
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
		User target = userRepo.findById(user.getUser_id());
		target.setPassword(user.getPassword());
		return (userRepo.save(target) != null) ? true : false;
	}
	
	// Delete User
	@Override
	public boolean deleteUser(User user) {
		userRepo.delete(user);
		return true;
	}

}
