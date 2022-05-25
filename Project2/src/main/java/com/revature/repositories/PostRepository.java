package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.revature.models.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

	@Query(value="UPDATE posts SET post_body=?1, post_likes=?2 WHERE post_id=?3", nativeQuery = true)
	public boolean update(String post_body, int post_likes, int post_id);
	
	@Query(value="SELECT * FROM posts WHERE user_id=?1", nativeQuery = true)
	public List<Post> findByUserId(int userId);
}
