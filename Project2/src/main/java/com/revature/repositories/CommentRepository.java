package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Comment;

@Repository
@Transactional
public interface CommentRepository extends JpaRepository<Comment, Integer>{

	// update comment_body and comment_likes by comment_id
	@Query(value="Update comments PUT comment_body=?1 comment_likes=?2 WHERE comment_id=?3", nativeQuery = true)
	public boolean updateComment(String comment_body, int comment_likes, int comment_id);
	
	// get all comment info from comment_id
	@Query(value="SELECT * FROM comments where comment_id=?1", nativeQuery = true)
	public Comment findById(int comment_id);
	
	//update only comment body by comment_id
	@Query(value="UPDATE comments SET comment_body=?1, WHERE comment_id=?2", nativeQuery = true)
	public boolean updateCommentBody(String comment_body, int comment_id);
}



