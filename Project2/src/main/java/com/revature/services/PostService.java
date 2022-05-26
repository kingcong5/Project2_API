package com.revature.services;

import java.util.List;

import com.revature.models.Post;

public interface PostService {

	//create a new post
	boolean createPost(Post post);
	
	// get all post info from post_id
	Post getPostById(int post_id);
	
	//get all posts
	List<Post> getAllPosts();
	
	//update a post body and likes by post_id
	boolean updatePost(Post post);
	
	//update post body by post_id
	boolean updatePostBody(Post post);
	
	//delete a post by post_id
	boolean deletePost(Post post);



}
