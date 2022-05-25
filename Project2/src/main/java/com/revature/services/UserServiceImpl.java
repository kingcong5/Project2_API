package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Comment;
import com.revature.models.User;
import com.revature.repositories.UserRepository;


@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public boolean createUser(User user) {
		int pk = userRepo.save(user).getId();
		return (pk > 0) ? true : false;
	}

	@Override
	public User findUserById(int id) {
		return userRepo.getReferenceById(id);
	}


	@Override
	public List<User> findAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public boolean updateUser(User user) {
		User target = userRepo.findById(user.getId()).stream().findFirst().get();
		target.setF_name(user.getF_name());
		target.setL_name(user.getL_name());
		target.setFavorite_artist(user.getFavorite_artist());
		target.setUsername(user.getUsername());
		target.setPassword(user.getPassword());
		return (userRepo.save(target) != null) ? true : false;
	}

	@Override
	public boolean deleteUser(User user) {
		userRepo.delete(user);
		return true;
	}


}
