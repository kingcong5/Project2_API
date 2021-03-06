package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name="comments")
@Data
@ApiModel(value = "Comment", description = "This model serves as basic model for all Comment entity API operations")
public class Comment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="comment_id")
	@ApiModelProperty(name="comment_id", 
	notes="an Integer value that serves as the unique identier for any comments entity",
	required = true,
	value = "1")
	private int comment_id;
	
	@Column(name="comment_body", unique=false, nullable=false)
	@ApiModelProperty(name="comment_body", 
	notes="a String value that serves as the comment_body",
	required = true,
	value = "test comment_body")
	private String comment_body;
	
	@Column(name="comment_likes", unique=false)
	@ApiModelProperty(name="comment_likes", 
	notes="an Integer value that serves as the unique identier for any comment_likes",
	required = true,
	value = "4")
	private int comment_likes;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "comment_post_id", referencedColumnName = "post_id")
	private Post post;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "comment_user_id", referencedColumnName = "user_id")
	private User user;
	
	
	
	public Comment() {
		super();
	}


	public Comment(String comment_body, User user, int comment_likes, Post post) {
		super();
		this.comment_body = comment_body;
		this.user = user;
		this.comment_likes = comment_likes;
		this.post = post;
	}


	public Comment(int comment_id, String comment_body, User user, int comment_likes, Post post) {
		super();
		this.comment_id = comment_id;
		this.comment_body = comment_body;
		this.user = user;
		this.comment_likes = comment_likes;
		this.post = post;
	}

}

