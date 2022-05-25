package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.models.Post;
import com.revature.repositories.PostRepository;

public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepository postRepo;

	@Override
	public boolean createPost(Post post) {
		int pk = postRepo.save(post).getPost_id();
		return (pk > 0) ? true : false;
	}

	@Override
	public Post getPostById(int id) {
		return postRepo.getReferenceById(id);
	}

	@Override
	public List<Post> getAllPosts() {
		return postRepo.findAll();
	}

	@Override
	public List<Post> getAllPostsByUserId(int userId) {
		return postRepo.findByUserId(userId);
	}

	@Override
	public boolean updatePostBody(Post post) {
		Post target = postRepo.findById(post.getPost_id()).stream().findFirst().get();
		target.setPost_body(post.getPost_body());
		return (postRepo.save(target) != null) ? true : false;
	}
	
	@Override
	public boolean updatePostLikes(Post post) {
		Post target = postRepo.findById(post.getPost_id()).stream().findFirst().get();
		target.setPost_likes(post.getPost_likes());
		return (postRepo.save(target) != null) ? true : false;
	}

	@Override
	public boolean deletePost(Post post) {
		postRepo.delete(post);
		return false;
	}

	

}
