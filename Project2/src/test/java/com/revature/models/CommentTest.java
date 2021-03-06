package com.revature.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CommentTest {

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

	@SuppressWarnings("unused")
	@Test
	void testCommentStringIntIntInt() {
		Comment c = new Comment();
		
		c.setComment_body("This is a test");
		c.setUser(null);
		c.setComment_likes(5);
		
		assertEquals("This is a test", c.getComment_body());
		assertEquals(null, c.getUser());
		assertEquals(5, c.getComment_likes());
	}

}
