package com.revature.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FavoriteSongTest {

	@Test
	void testFavoriteSongIntSongSong() {
		FavoriteSong fs = new FavoriteSong();
		
		fs.setSpotifyId(null);
		fs.setUser(null);
		
		assertEquals(null, fs.getSpotifyId());
		assertEquals(null, fs.getUser());
		
		
	}

}
