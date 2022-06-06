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

import com.revature.models.Post;
import com.revature.models.Song;
import com.revature.repositories.PostRepository;
import com.revature.repositories.SongRepository;

class PostServiceImplTest {
	
	//Class to be tested
	private PostServiceImpl psi;
	
	//dependencies (will be mocked)
	private PostRepository postRepo;
	
	//test data
	private Post p;

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
		postRepo = Mockito.mock(PostRepository.class);
		
		//2. inject your service with mocked classes
		psi = new PostServiceImpl(postRepo);
		
		//3. provide a wizard stub to test with
		p = new Post();
		p.setPost_id(0);
		p.setPost_body(null);
		p.setPost_likes(0);
		p.setPost_song(null);
		p.setUser(null);
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	/*

	@Test
	void testPostServiceImpl() {
		fail("Not yet implemented");
	}
	
	*/

	@Test
	void testCreatePost() {
		
		//arrange
				//here, we are telling Mockito what to do with our mock method calls 
				//and what to expect in return from that call
				when(postRepo.save(p)).thenReturn(p);
				
				//act
				//run targeted test method with service injector
				psi.createPost(p);
				
				//assert
				//verify that the dao mock ran with injector
				verify(postRepo, times(1)).save(p);
		
	}

	@Test
	void testGetPostById() {
		
		psi.getPostById(0);
		
	}

	@Test
	void testGetAllPosts() {
		
		psi.getAllPosts();
		
	}
	
	

	@Test
	void testUpdatePost() {
		

		//arrange
		//here, we are telling Mockito what to do with our mock method calls 
		//and what to expect in return from that call
		when(postRepo.save(p)).thenReturn(p);
		
		//act
		//run targeted test method with service injector
		psi.createPost(p);
		
		//assert
		//verify that the dao mock ran with injector
		verify(postRepo, times(1)).save(p);
		
	}

	@Test
	void testUpdatePostBody() {
		

		//arrange
		//here, we are telling Mockito what to do with our mock method calls 
		//and what to expect in return from that call
		when(postRepo.save(p)).thenReturn(p);
		
		//act
		//run targeted test method with service injector
		psi.createPost(p);
		
		//assert
		//verify that the dao mock ran with injector
		verify(postRepo, times(1)).save(p);
		
	}
	


	@Test
	void testDeletePost() {
		
		psi.deletePost(p);
		
	}

}
