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
@Table(name="posts")
@Data
@ApiModel(value = "Post", description = "This model serves as basic model for all Post entity API operations")
public class Post {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="post_id")
	@ApiModelProperty(name="post_id", 
	notes="an Integer value that serves as the unique identier for any post entity",
	required = true,
	value = "1")
	private int post_id;
	
	@Column(name="post_body", unique=false, nullable=false)
	@ApiModelProperty(name="post_body", 
	notes="a String value that serves as the post_body",
	required = true,
	value = "test post_body")
	private String post_body;
	
	@Column(name="post_likes", unique=false, nullable=true)
	@ApiModelProperty(name="post_likes", 
	notes="an Integer value that serves as the unique identier for any post_likes",
	required = true,
	value = "4")
	private int post_likes;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "Post_user_id", referencedColumnName = "user_id")
	private User user;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "Post_song_id", referencedColumnName = "song_id")
	private Song song;

	public Post() {
		super();
	}

	public Post(Song song, String post_body, int post_likes, User user) {
		super();
		this.song = song;
		this.post_body = post_body;
		this.post_likes = post_likes;
		this.user = user;
	}

	public Post(int post_id, Song song, String post_body, int post_likes, User user) {
		super();
		this.post_id = post_id;
		this.song = song;
		this.post_body = post_body;
		this.post_likes = post_likes;
		this.user = user;
	}

}



