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
		assertNull(c.getComment_body());
		assertNull(c.getUser());
		assertNull(c.getComment_likes());
		assertNull(c.getPost());
	}

	@Test
	void testCommentIntStringIntIntInt() {
		Comment c = new Comment();
//		assertNull(c.getPost_id());
		assertNull(c.getComment_body());
//		assertNull(c.getUser_id());
		assertNull(c.getComment_likes());
//		assertNull(c.getPost_id());
	}

}
