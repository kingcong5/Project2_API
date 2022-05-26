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
	void testSong() {
		Song s = new Song();
		assertNull(s.getId());
		
	}

	@Test
	void testSongStringStringStringStringLongString() {
		Song s = new Song();
		assertNull(s.getName());
		assertNull(s.getArtist());
		assertNull(s.getAlbum());
		assertNull(s.getArt());
		assertNull(s.getLength());
		assertNull(s.getUrl());
	}

	@Test
	void testSongIntStringStringStringStringLongString() {
		Song s = new Song();
		assertNull(s.getId());
		assertNull(s.getName());
		assertNull(s.getArtist());
		assertNull(s.getAlbum());
		assertNull(s.getArt());
		assertNull(s.getLength());
		assertNull(s.getUrl());
	}

}
