package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Comment;
import com.revature.repositories.CommentRepository;


@Service
@Transactional
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository comRepo;
	
	@Autowired
	public CommentServiceImpl(CommentRepository dao) {
		this.comRepo = dao;
	}

	// create a new comment
	@Override
	public boolean createComment(Comment comment) {
		int pk = comRepo.save(comment).getComment_id();
		return (pk > 0) ? true : false;
	}

	// get all comment info from comment_id
	@Override
	public Comment getCommentById(int comment_id) {
		return comRepo.findById(comment_id);
	}

	//get all comments
	@Override
	public List<Comment> getAllComments() {
		return comRepo.findAll();
	}
	
	//update a comment body and likes by comment_id
	@Override
	public boolean updateComment(Comment comment) {
		Comment target = comRepo.findById(comment.getComment_id());
		target.setComment_body(comment.getComment_body());
		target.setComment_likes(comment.getComment_likes());
		return (comRepo.save(target) != null) ? true : false;
	}
	

	//update comment body by comment_id
	@Override
	public boolean updateCommentBody(Comment comment) {
		Comment target = comRepo.findById(comment.getComment_id());
		target.setComment_body(comment.getComment_body());
		return (comRepo.save(target) != null) ? true : false;
	}

	//delete a comment by comment_id
	@Override
	public boolean deleteComment(Comment comment) {
		comRepo.delete(comment);
		return true;
	}
	
}
