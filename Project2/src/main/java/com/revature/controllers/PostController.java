package com.revature.controllers;

import static com.revature.util.ClientMessageUtil.CREATION_FAILED;
import static com.revature.util.ClientMessageUtil.CREATION_SUCCESSFUL;
import static com.revature.util.ClientMessageUtil.DELETION_FAILED;
import static com.revature.util.ClientMessageUtil.DELETION_SUCCESSFUL;
import static com.revature.util.ClientMessageUtil.UPDATE_FAILED;
import static com.revature.util.ClientMessageUtil.UPDATE_SUCCESSFUL;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.ClientMessage;
import com.revature.models.Post;
import com.revature.services.PostService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value = "PostRestController", tags = {"REST controller related to Post Entities"})
public class PostController {
	
	private static Logger log = Logger.getLogger(PostController.class);

		
	@Autowired
	private PostService comServ;
	
	
	// create a new post
	@PostMapping("/post")
	@ApiOperation(value="Create new post entity")
	public @ResponseBody ClientMessage createPost(@RequestBody Post post) {
		
		log.info("Creating post...");
		
		return comServ.createPost(post) ? CREATION_SUCCESSFUL : CREATION_FAILED;
	}
	
	
	//get all posts
	@GetMapping("/posts")
	@ApiOperation(value="Find all posts")
	public @ResponseBody List<Post> getAll() {
		
		log.info("Getting all posts...");
		
		return comServ.getAllPosts();
	}
 
	
	// get all post info from post_id
	 @ApiOperation(value="Find post by id number", notes="Provide an id to lookup a specific post from the API", response = Post.class)
	 @GetMapping(path = "/post") 
	 public @ResponseBody Post getPostById(@RequestParam(value = "post_id", name = "post_id") int post_id) { 
		 
		 log.info("Getting post by id...");
		 
		 System.out.println("TEST: " + comServ.getPostById(post_id));
		 return comServ.getPostById(post_id); 
	 }
	
	 
	//update a post body and likes by post_id
	@ApiOperation(value="Update Post Body and likes by id number", notes="Provide a body and id to lookup a specific post body from the API and edit it anbd attached likes", response = Post.class)
	@PutMapping(path = "/post")
	 public @ResponseBody ClientMessage updatePost(@RequestBody Post post) { 
		
		log.info("Updating post...");
		
		 return comServ.updatePost(post) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
	 }
	
	
	//update post body by post_id
	@ApiOperation(value="Update Post Body by id number", notes="Provide a body and id to lookup a specific post body from the API and edit it", response = Post.class)
	@PutMapping(path = "/postbody")
	 public @ResponseBody ClientMessage updatePostBody(@RequestBody Post post) { 
		
		log.info("Updating post body...");
		
		 return comServ.updatePostBody(post) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
	 }
	
	
	//delete a post by post_id
	@DeleteMapping("/post")
	@ApiOperation(value="Remove post entity")
	public @ResponseBody ClientMessage deletePost(@RequestBody Post post) {
		
		log.info("Deleting post...");
		
		return comServ.deletePost(post) ? DELETION_SUCCESSFUL : DELETION_FAILED;
	}

}


