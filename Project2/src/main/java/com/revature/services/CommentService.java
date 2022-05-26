package com.revature.services;

import java.util.List;

import com.revature.models.Comment;

public interface CommentService {

	//create a new comment
	boolean createComment(Comment comment);
	
	// get all comment info from comment_id
	Comment getCommentById(int comment_id);
	
	//get all comments
	List<Comment> getAllComments();
	
	//update a comment body and likes by comment_id
	boolean updateComment(Comment comment);
	
	//update comment body by comment_id
	boolean updateCommentBody(Comment comment);
	
	//delete a comment by comment_id
	boolean deleteComment(Comment comment);



}



