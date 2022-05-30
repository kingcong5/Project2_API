package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Post;
import com.revature.repositories.PostRepository;


@Service
@Transactional
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository comRepo;
	
	@Autowired
	public PostServiceImpl(PostRepository dao) {
		this.comRepo = dao;
	}

	// create a new post
	@Override
	public boolean createPost(Post post) {
		int pk = comRepo.save(post).getPost_id();
		return (pk > 0) ? true : false;
	}

	// get all post info from post_id
	@Override
	public Post getPostById(int post_id) {
		return comRepo.findById(post_id);
	}

	//get all posts
	@Override
	public List<Post> getAllPosts() {
		return comRepo.findAll();
	}
	
	//update a post body and likes by post_id
	@Override
	public boolean updatePost(Post post) {
		Post target = comRepo.findById(post.getPost_id());
		target.setPost_body(post.getPost_body());
		target.setPost_likes(post.getPost_likes());
		return (comRepo.save(target) != null) ? true : false;
	}
	

	//update post body by post_id
	@Override
	public boolean updatePostBody(Post post) {
		Post target = comRepo.findById(post.getPost_id());
		target.setPost_body(post.getPost_body());
		return (comRepo.save(target) != null) ? true : false;
	}

	//delete a post by post_id
	@Override
	public boolean deletePost(Post post) {
		comRepo.delete(post);
		return true;
	}
	
}
