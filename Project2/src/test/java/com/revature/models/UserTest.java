package com.revature.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testHashCode() {
		fail("Not yet implemented");
	}

	@Test
	void testUser() {
		fail("Not yet implemented");
	}

	@Test
	void testUserStringStringStringStringString() {
		User u = new User();
		assertNull(u.getF_name());
		assertNull(u.getL_name());
		assertNull(u.getFavorite_artist());
		assertNull(u.getUsername());
		assertNull(u.getPassword());
	}

	@Test
	void testUserIntStringStringStringStringString() {
		User u = new User();
		assertNull(u.getId());
		assertNull(u.getF_name());
		assertNull(u.getL_name());
		assertNull(u.getFavorite_artist());
		assertNull(u.getUsername());
		assertNull(u.getPassword());
	}

}