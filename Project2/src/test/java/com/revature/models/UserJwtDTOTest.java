package com.revature.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserJwtDTOTest {

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
	void testUserJwtDTOStringStringStringStringString() {
		UserJwtDTO ujwtd = new UserJwtDTO();
		
		ujwtd.setF_name("Maverick");
		ujwtd.setL_name("Clint");
		ujwtd.setFavorite_artist("Panterra");
		ujwtd.setUsername("mavcli");
		ujwtd.setPassword("password");
		
		assertEquals("Maverick", ujwtd.getF_name());
		assertEquals("Clint", ujwtd.getL_name());
		assertEquals("Panterra", ujwtd.getFavorite_artist());
		assertEquals("mavcli", ujwtd.getUsername());
		assertEquals("password", ujwtd.getPassword());
	}

}
