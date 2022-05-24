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
	
	@Override
	public boolean createComment(Comment comment) {
		int pk = comRepo.save(comment).getComment_id();
		return (pk > 0) ? true : false;
	}

	@Override
	public Comment getCommentById(int id) {
		return comRepo.getReferenceById(id);
	}

	@Override
	public boolean updateComment(Comment comment) {
		Comment target = comRepo.findById(comment.getComment_id()).stream().findFirst().get();
		target.setComment_body(comment.getComment_body());
		return (comRepo.save(target) != null) ? true : false;
	}

	@Override
	public boolean deleteComment(Comment comment) {
		// TODO Auto-generated method stub
		comRepo.delete(comment);
		return true;
	}

	// update likes. likes = likes += 1
	
	// get all comments
	@Override
	public List<Comment> getAllComments(){
		return comRepo.findAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
