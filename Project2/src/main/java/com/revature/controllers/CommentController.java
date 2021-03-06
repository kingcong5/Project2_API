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
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.revature.models.Comment;
import com.revature.services.CommentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:5500/", "http://127.0.0.1:5500/", "http://localhost:4200/", "http://127.0.0.1:5501/", "http://localhost:8080/", "http://127.0.0.1:8080/", "http://localhost:5502/", "http://127.0.0.1:5502/"})
@Api(value = "CommentRestController", tags = {"REST controller related to Comment Entities"})
public class CommentController {
	
	private static Logger log = Logger.getLogger(CommentController.class);

		
	@Autowired
	private CommentService comServ;
	
	
	// create a new comment
	@PostMapping("/comment")
	@ApiOperation(value="Create new comment entity")
	public @ResponseBody ClientMessage createComment(@RequestBody Comment comment) {
		log.info("Creating comment...");
		
		return comServ.createComment(comment) ? CREATION_SUCCESSFUL : CREATION_FAILED;
	}
	
	
	//get all comments
	@GetMapping("/comments")
	@ApiOperation(value="Find all comments")
	public @ResponseBody List<Comment> getAll() {
		
		log.info("Getting all comments...");
		
		return comServ.getAllComments();
	}
 
	
	// get all comment info from comment_id
	 @ApiOperation(value="Find comment by id number", notes="Provide an id to lookup a specific comment from the API", response = Comment.class)
	 @GetMapping(path = "/comment") 
	 public @ResponseBody Comment getCommentById(@RequestParam(value = "id", name = "id") int id) { 
		 log.info("Getting comment by id..");
		 
		 System.out.println("TEST: " + comServ.getCommentById(id));
		 return comServ.getCommentById(id); 
	 }
	
	 
	//update a comment body and likes by comment_id
	@ApiOperation(value="Update Comment Body and likes by id number", notes="Provide a body and id to lookup a specific comment body from the API and edit it anbd attached likes", response = Comment.class)
	@PutMapping(path = "/comment")
	 public @ResponseBody ClientMessage updateComment(@RequestBody Comment comment) { 
		log.info("updating comment...");
		
		 return comServ.updateComment(comment) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
	 }
	
	
	//update comment body by comment_id
	@ApiOperation(value="Update Comment Body by id number", notes="Provide a body and id to lookup a specific comment body from the API and edit it", response = Comment.class)
	@PutMapping(path = "/commentbody")
	 public @ResponseBody ClientMessage updateCommentBody(@RequestBody Comment comment) { 
		log.info("Updating comment body...");
		
		 return comServ.updateCommentBody(comment) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
	 }
	
	
	//delete a comment by comment_id
	@DeleteMapping("/comment")
	@ApiOperation(value="Remove comment entity")
	public @ResponseBody ClientMessage deleteComment(@RequestBody Comment comment) {
		log.info("Deleting comment...");
		
		return comServ.deleteComment(comment) ? DELETION_SUCCESSFUL : DELETION_FAILED;
	}

}


