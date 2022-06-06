package com.revature.services;

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

import com.revature.models.FavoriteSong;
import com.revature.models.Post;
import com.revature.repositories.FavoriteSongRepository;
import com.revature.repositories.PostRepository;

class FavoriteSongServiceImplTest {
	
	//Class to be tested
		private FavoriteSongServiceImpl fssi;
		
		//dependencies (will be mocked)
		private FavoriteSongRepository favoriteSongRepo;
		
		//test data
		private FavoriteSong fs;

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
		favoriteSongRepo = Mockito.mock(FavoriteSongRepository.class);
		
		//2. inject your service with mocked classes
		fssi = new FavoriteSongServiceImpl(favoriteSongRepo);
		
		//3. provide a wizard stub to test with
		fs = new FavoriteSong();
		fs.setId(0);
		fs.setSpotifyId(null);
		fs.setUser(null);
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCreateFavoriteSong() {
		

		//arrange
		//here, we are telling Mockito what to do with our mock method calls 
		//and what to expect in return from that call
		when(favoriteSongRepo.save(fs)).thenReturn(fs);
		
		//act
		//run targeted test method with service injector
		fssi.createFavoriteSong(fs);
		
		//assert
		//verify that the dao mock ran with injector
		verify(favoriteSongRepo, times(1)).save(fs);
		
	}

	@Test
	void testGetSongById() {
		
		fssi.getSongById(0);
		
	}

	@Test
	void testGetAllFavoriteSongs() {
		
		fssi.getAllFavoriteSongs();
		
	}
	
	

	@Test
	void testUpdateFavoriteSong() {
		
		//arrange
				//here, we are telling Mockito what to do with our mock method calls 
				//and what to expect in return from that call
				when(favoriteSongRepo.save(fs)).thenReturn(fs);
				
				//act
				//run targeted test method with service injector
				fssi.createFavoriteSong(fs);
				
				//assert
				//verify that the dao mock ran with injector
				verify(favoriteSongRepo, times(1)).save(fs);
		
	}
	
	

	@Test
	void testDeleteFavoriteSong() {
		
		fssi.deleteFavoriteSong(fs);
		
	}

	@Test
	void testGetAllSongsByUser() {
		
		fssi.getAllSongsByUser(0);		
	}

}
