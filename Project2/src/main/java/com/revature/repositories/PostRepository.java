package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.revature.models.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

	// update post_body and post_likes by post_id
	@Query(value="Update posts PUT post_body=?1 post_likes=?2 WHERE post_id=?3", nativeQuery = true)
	public boolean updatePost(String post_body, int post_likes, int post_id);
	
	// get all post info from post_id
	@Query(value="SELECT * FROM posts where post_id=?1", nativeQuery = true)
	public Post findById(int post_id);
	
	//update only post body by post_id
	@Query(value="UPDATE posts SET post_body=?1, WHERE post_id=?2", nativeQuery = true)
	public boolean updatePostBody(String post_body, int post_id);
}
