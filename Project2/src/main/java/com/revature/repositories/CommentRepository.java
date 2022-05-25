package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Comment;

@Repository
@Transactional
public interface CommentRepository extends JpaRepository<Comment, Integer>{

	// custom query to edit a comment
	@Query(value="Update comments SET comment_body=?1 WHERE comment_id=?2", nativeQuery = true)
	public boolean update(String comment_body, int comment_id);
	
}



