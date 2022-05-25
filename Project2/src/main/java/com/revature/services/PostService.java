package com.revature.services;

import java.util.List;

import com.revature.models.Post;

public interface PostService {

	boolean createPost(Post post);
	
	Post getPostById(int id);
	
	List<Post> getAllPosts();
	
	List<Post> getAllPostsByUserId(int userId);
	
	boolean updatePostBody(Post post);
	
	boolean updatePostLikes(Post post);
	
	boolean deletePost(Post post);
}
