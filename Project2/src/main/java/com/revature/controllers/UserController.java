package com.revature.controllers;

import static com.revature.util.ClientMessageUtil.CREATION_FAILED;
import static com.revature.util.ClientMessageUtil.CREATION_SUCCESSFUL;
import static com.revature.util.ClientMessageUtil.DELETION_FAILED;
import static com.revature.util.ClientMessageUtil.DELETION_SUCCESSFUL;
import static com.revature.util.ClientMessageUtil.UPDATE_FAILED;
import static com.revature.util.ClientMessageUtil.UPDATE_SUCCESSFUL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.ClientMessage;
import com.revature.models.User;
import com.revature.services.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api")
@Api(value = "UserRestController", tags = {"REST controller related to User Entities"})
public class UserController {

	@Autowired
	private UserService userServ;
	 // get user by id
	
	@ApiOperation(value="Find user by id number", notes="Provide an id to lookup a specific user from the API", response = User.class)
	 @GetMapping(path = "/user") 
	 public @ResponseBody User getById(@RequestParam(value = "id", name = "id") int id) { 
		 System.out.println("TEST: " + userServ.findUserById(id));
		 return userServ.findUserById(id);
	 }
	 
	@GetMapping("/user")
	@ApiOperation(value="Find all users")
	public @ResponseBody List<User> getAll() {
		return userServ.findAllUsers();
	}
	@PostMapping("/user")
	@ApiOperation(value="Create new user entity")
	public @ResponseBody ClientMessage createUser(@RequestBody User user) {
		return userServ.createUser(user) ? CREATION_SUCCESSFUL : CREATION_FAILED;
	}
	
	@PutMapping("/user")
	@ApiOperation(value="Update user entity")
	public @ResponseBody ClientMessage updateCandy(@RequestBody User user) {
		return userServ.updateUser(user) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
	}
	
	@DeleteMapping("/user")
	@ApiOperation(value="Remove user entity")
	public @ResponseBody ClientMessage deleteCandy(@RequestBody User user) {
		return userServ.deleteUser(user) ? DELETION_SUCCESSFUL : DELETION_FAILED;
	}

}