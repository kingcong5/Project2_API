package com.revature.services;

import java.util.List;

import com.revature.models.Comment;

public interface CommentService {

	//create a new comment
	boolean createComment(Comment comment);
	
	//get comment by id
	Comment getCommentById(int id);
	
	//update a comment
	boolean updateComment(Comment comment);
	
	//delete a comment
	boolean deleteComment(Comment comment);
	
	//delete a comment
	List<Comment> getAllComments();

}
