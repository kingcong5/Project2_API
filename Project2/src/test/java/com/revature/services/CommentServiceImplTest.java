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

import com.revature.models.Comment;
import com.revature.models.FavoriteSong;
import com.revature.repositories.CommentRepository;
import com.revature.repositories.FavoriteSongRepository;

class CommentServiceImplTest {
	
	//Class to be tested
			private CommentServiceImpl csi;
			
			//dependencies (will be mocked)
			private CommentRepository commentRepo;
			
			//test data
			private Comment c;

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
		commentRepo = Mockito.mock(CommentRepository.class);
		
		//2. inject your service with mocked classes
		csi = new CommentServiceImpl(commentRepo);
		
		//3. provide a wizard stub to test with
		c = new Comment();
		c.setPost(null);
		c.setComment_body(null);
		c.setComment_id(0);
		c.setComment_likes(0);
		c.setUser(null);
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	/*

	@Test
	void testCommentServiceImpl() {
		fail("Not yet implemented");
	}
	
	*/

	@Test
	void testCreateComment() {
		

		//arrange
				//here, we are telling Mockito what to do with our mock method calls 
				//and what to expect in return from that call
				when(commentRepo.save(c)).thenReturn(c);
				
				//act
				//run targeted test method with service injector
				csi.createComment(c);
				
				//assert
				//verify that the dao mock ran with injector
				verify(commentRepo, times(1)).save(c);
		
	}

	@Test
	void testGetCommentById() {
		
		csi.getCommentById(0);
		
	}

	@Test
	void testGetAllComments() {
		
		csi.getAllComments();
		
	}
	
	/*

	@Test
	void testUpdateComment() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateCommentBody() {
		fail("Not yet implemented");
	}
	
	*/

	@Test
	void testDeleteComment() {
		
		csi.deleteComment(c);
		
	}

}
