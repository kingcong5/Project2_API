package com.revature.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PostTest {


	@Test
	void testPostSongStringIntUser() {
		Post p = new Post();
		
		p.setPost_body("nice song");
		p.setPost_song("Diamonds");
		p.setPost_likes(7);
		
		
		assertEquals("nice song", p.getPost_body());
		assertEquals("Diamonds", p.getPost_song());
		assertEquals(7, p.getPost_likes());
		
	}

}
