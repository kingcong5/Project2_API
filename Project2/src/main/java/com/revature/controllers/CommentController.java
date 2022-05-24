package com.revature.controllers;

import static com.revature.util.ClientMessageUtil.CREATION_FAILED;
import static com.revature.util.ClientMessageUtil.CREATION_SUCCESSFUL;
import static com.revature.util.ClientMessageUtil.DELETION_FAILED;
import static com.revature.util.ClientMessageUtil.DELETION_SUCCESSFUL;
import static com.revature.util.ClientMessageUtil.UPDATE_FAILED;
import static com.revature.util.ClientMessageUtil.UPDATE_SUCCESSFUL;


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
import com.revature.models.Comment;
import com.revature.services.CommentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value = "CommentRestController", tags = {"REST controller related to Comment Entities"})
public class CommentController {

		
	@Autowired
	private CommentService comServ;
	
	
	 // get comment by id
	 @ApiOperation(value="Find comment by id number", notes="Provide an id to lookup a specific comment from the API", response = Comment.class)
	 @GetMapping(path = "/comment") 
	 public @ResponseBody Comment getById(@RequestParam(value = "id", name = "id") int id) { 
		 System.out.println("TEST: " + comServ.getCommentById(id));
		 return comServ.getCommentById(id); 
	 }

	
	// post new comment
	@PostMapping("/comment")
	@ApiOperation(value="Create new comment entity")
	public @ResponseBody ClientMessage createComment(@RequestBody Comment comment) {
		return comServ.createComment(comment) ? CREATION_SUCCESSFUL : CREATION_FAILED;
	}
 
	
	// update comment
	@PutMapping("/comment")
	@ApiOperation(value="Update comment entity")
	public @ResponseBody ClientMessage updateComment(@RequestBody Comment comment) {
		return comServ.updateComment(comment) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
	}
	
	
	// delete comment
	@DeleteMapping("/comment")
	@ApiOperation(value="Remove comment entity")
	public @ResponseBody ClientMessage deleteComment(@RequestBody Comment comment) {
		return comServ.deleteComment(comment) ? DELETION_SUCCESSFUL : DELETION_FAILED;
	}
	 
	 

//	// to do
//	@GetMapping("/comment")
//	@ApiOperation(value="Find all comments")
//	public @ResponseBody List<Comment> getAll() {
//		return comServ.getAllComments();
//	}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}


