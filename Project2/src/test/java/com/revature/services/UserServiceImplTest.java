package com.revature.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.revature.models.User;
import com.revature.repositories.UserRepository;

class UserServiceImplTest {
	
	//Class to be tested
		private UserServiceImpl usi;
		
		//dependencies (will be mocked)
		private UserRepository userRepo;
		
		//test data
		private User u;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
		/*Mockito setup*/
		//1. mock the depending classes
		userRepo = Mockito.mock(UserRepository.class);
		
		//2. inject your service with mocked classes
		usi = new UserServiceImpl(userRepo);
		
		//3. provide a wizard stub to test with
		u = new User();
		u.setUser_id(0);
		u.setF_name("Henry");
		u.setL_name("Jackson");
		u.setFavorite_artist("Psy");
		u.setUsername("hen123");
		u.setPassword("pass");
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	/* @Test
	void testUserServiceImpl() {
		fail("Not yet implemented");
	}
	*/ 

	@Test
	void testCreateUser() {
		
		//arrange
				//here, we are telling Mockito what to do with our mock method calls 
				//and what to expect in return from that call
				when(userRepo.save(u)).thenReturn(u);
				
				//act
				//run targeted test method with service injector
				usi.createUser(u);
				
				//assert
				//verify that the dao mock ran with injector
				verify(userRepo, times(1)).save(u);
		
	}

	@Test
	void testGetUserById() {
		

		usi.getUserById(0);
		
	}

	@Test
	void testGetAllUsers() {
		

		usi.getAllUsers();
		
	}

	
	
	@Test
	void testUpdateUser() {
		
when(userRepo.save(u)).thenReturn(u);
		
		

		assertThat(userRepo.save(u)).isNotNull();
		
		verify(userRepo, times(1)).save(u);
	}


	@Test
	void testUpdateUserPassword() {
		

when(userRepo.save(u)).thenReturn(u);
		
		

		assertThat(userRepo.save(u)).isNotNull();
		
		verify(userRepo, times(1)).save(u);
		
	}
	

	@Test
	void testDeleteUser() {
		

		usi.deleteUser(u);
		
	}

	@Test
	void testLogin() {
		

		usi.login(null, null);
		
	}

}