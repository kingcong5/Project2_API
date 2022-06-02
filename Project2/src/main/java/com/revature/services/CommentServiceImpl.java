package com.revature.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Comment;
import com.revature.repositories.CommentRepository;


@Service
@Transactional
public class CommentServiceImpl implements CommentService {
	
	private static Logger log = Logger.getLogger(CommentServiceImpl.class);

	@Autowired
	private CommentRepository comRepo;
	
	@Autowired
	public CommentServiceImpl(CommentRepository dao) {
		this.comRepo = dao;
	}

	// create a new comment
	@Override
	public boolean createComment(Comment comment) {
		
		log.info("In service layer: Creating comment: " + comment);
		
		int pk = comRepo.save(comment).getComment_id();
		return (pk > 0) ? true : false;
	}

	// get all comment info from comment_id
	@Override
	public Comment getCommentById(int comment_id) {
		
		log.info("In service layer: Getting comment by id: " + comment_id);
		
		return comRepo.findById(comment_id);
	}

	//get all comments
	@Override
	public List<Comment> getAllComments() {
		
		log.info("In service layer: Getting all comments...");
		
		return comRepo.findAll();
	}
	
	//update a comment body and likes by comment_id
	@Override
	public boolean updateComment(Comment comment) {
		
		log.info("In service layer: Updating comment: " + comment);
		
		Comment target = comRepo.findById(comment.getComment_id());
		target.setComment_body(comment.getComment_body());
		target.setComment_likes(comment.getComment_likes());
		return (comRepo.save(target) != null) ? true : false;
	}
	

	//update comment body by comment_id
	@Override
	public boolean updateCommentBody(Comment comment) {
		
		log.info("In service layer: Updating comment body: " + comment);
		
		Comment target = comRepo.findById(comment.getComment_id());
		target.setComment_body(comment.getComment_body());
		return (comRepo.save(target) != null) ? true : false;
	}

	//delete a comment by comment_id
	@Override
	public boolean deleteComment(Comment comment) {
		
		log.info("In service layer: Deleting comment: " + comment);
		
		comRepo.delete(comment);
		return true;
	}
	
}
