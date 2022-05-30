package com.revature.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SongTest {

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
	void testSongIntStringStringStringStringLongString() {
		Song s = new Song();
		
		s.setName("Whodini");
		s.setArtist("Bloke");
		s.setAlbum("Mavis");
		s.setArt("Bike");
		s.setLength(5L);
		s.setUrl("www.example.com");
		
		assertEquals("Whodini", s.getName());
		assertEquals("Bloke", s.getArtist());
		assertEquals("Mavis", s.getAlbum());
		assertEquals("Bike", s.getArt());
		assertEquals(5L, s.getLength());
		assertEquals("www.example.com", s.getUrl());
		
	}

}
