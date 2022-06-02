package com.revature.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PostTest {

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
	void testPostSongStringIntUser() {
		Post p = new Post();
		
		p.setPost_body("nice song");
		p.setSong(null);
		p.setPost_likes(7);
		p.setUser(null);
		
		assertEquals("nice song", p.getPost_body());
		assertEquals(null, p.getSong());
		assertEquals(7, p.getPost_likes());
		assertEquals(null, p.getUser());
	}

}
