package com.revature.controllers;

import static com.revature.util.ClientMessageUtil.CREATION_FAILED;
import static com.revature.util.ClientMessageUtil.CREATION_SUCCESSFUL;
import static com.revature.util.ClientMessageUtil.DELETION_FAILED;
import static com.revature.util.ClientMessageUtil.DELETION_SUCCESSFUL;
import static com.revature.util.ClientMessageUtil.UPDATE_FAILED;
import static com.revature.util.ClientMessageUtil.UPDATE_SUCCESSFUL;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.models.ClientMessage;
//import com.revature.models.Comment;
import com.revature.models.User;
import com.revature.services.UserService;

import io.jsonwebtoken.security.InvalidKeyException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:5500/", "http://127.0.0.1:5500/", "http://localhost:4200/", "http://127.0.0.1:5501/", "http://localhost:8080/", "http://127.0.0.1:8080/", "http://localhost:5502/", "http://127.0.0.1:5502/"})
@Api(value = "UserRestController", tags = {"REST controller related to User Entities"})
public class UserController {
	
	private static Logger log = Logger.getLogger(UserController.class);

	
	@Autowired
	private UserService userServ;
	
//	private JwtService jwtServ;

	
	// Create new user
	@PostMapping("/user")
	@ApiOperation(value="Create new user entity")
	public @ResponseBody ClientMessage createUser(@RequestBody User user) {
		
		log.info("Creating user...");
		
		return userServ.createUser(user) ? CREATION_SUCCESSFUL : CREATION_FAILED;
	}
	
	
	// Find all users
	@GetMapping("/users")
	@ApiOperation(value="Find all users")
	public @ResponseBody List<User> getAll() {
		
		log.info("Getting all users...");
		
		return userServ.getAllUsers();
	}
	
	
	 // Find user by ID
	 @ApiOperation(value="Find user by id number", notes="Provide an id to lookup a specific user from the API", response = User.class)
	 @GetMapping("/user") 
	 public @ResponseBody User getById(@RequestParam(value = "user_id", name = "user_id") int user_id) { 
		 
		 log.info("Getting user by id...");
		 
		 System.out.println("TEST: " + userServ.getUserById(user_id));
		 return userServ.getUserById(user_id);
	 }

	
	 // Update user
	 @ApiOperation(value="Update user entity")
	 @PutMapping(path = "/user")
	 public @ResponseBody ClientMessage updateUser(@RequestBody User user) {
		 
		 log.info("Updating user...");
		 
		 return userServ.updateUser(user) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
	 }
	
	//update User Password by user_id
	@ApiOperation(value="Update User Password by user_id", notes="Provide a password and id to lookup a specific comment password from the API and edit it", response = User.class)
	@PutMapping(path = "/userpassword")
	 public @ResponseBody ClientMessage updateUserPassword(@RequestBody User user) { 
		
		log.info("Updating user password...");
		
		 return userServ.updateUserPassword(user) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
	 }
	
	
	 // Delete User
	 @DeleteMapping("/user")
	 @ApiOperation(value="Remove user entity")
	 public @ResponseBody ClientMessage deleteUser(@RequestBody User user) {
		 
		 log.info("Deleting user...");
		 
		 return userServ.deleteUser(user) ? DELETION_SUCCESSFUL : DELETION_FAILED;
	 }
	 
	 // Login User
	 @GetMapping("/login")
	 @ApiOperation(value="Login user")
	 public @ResponseBody User login(@RequestParam(value = "user_username", name = "user_username") String user_username, @RequestParam(value = "user_password", name = "user_password") String user_password) throws InvalidKeyException, JsonProcessingException {
		 return userServ.login(user_username, user_password);

	 }



}