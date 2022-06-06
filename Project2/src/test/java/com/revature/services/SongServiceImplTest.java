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

import com.revature.models.Song;
import com.revature.models.User;
import com.revature.repositories.SongRepository;
import com.revature.repositories.UserRepository;

class SongServiceImplTest {
	
	//Class to be tested
			private SongServiceImpl ssi;
			
			//dependencies (will be mocked)
			private SongRepository songRepo;
			
			//test data
			private Song s;

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
		songRepo = Mockito.mock(SongRepository.class);
		
		//2. inject your service with mocked classes
		ssi = new SongServiceImpl(songRepo);
		
		//3. provide a wizard stub to test with
		s = new Song();
		s.setId(0);
		s.setName(null);
		s.setAlbum(null);
		s.setArt(null);
		s.setLength(0);
		s.setUrl(null);
		s.setArtist(null);
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCreateSong() {
		

		//arrange
		//here, we are telling Mockito what to do with our mock method calls 
		//and what to expect in return from that call
		when(songRepo.save(s)).thenReturn(s);
		
		//act
		//run targeted test method with service injector
		ssi.createSong(s);
		
		//assert
		//verify that the dao mock ran with injector
		verify(songRepo, times(1)).save(s);
		
	}

	@Test
	void testGetSongById() {
		
		ssi.getSongById(0);
		
	}

	@Test
	void testGetAllSongs() {
		
		ssi.getAllSongs();
		
	}
	
	

	@Test
	void testUpdateSong() {
		
		//arrange
				//here, we are telling Mockito what to do with our mock method calls 
				//and what to expect in return from that call
				when(songRepo.save(s)).thenReturn(s);
				
				//act
				//run targeted test method with service injector
				ssi.createSong(s);
				
				//assert
				//verify that the dao mock ran with injector
				verify(songRepo, times(1)).save(s);
		
	}
	
	

	@Test
	void testDeleteSong() {
		
		ssi.deleteSong(s);
		
	}

}
