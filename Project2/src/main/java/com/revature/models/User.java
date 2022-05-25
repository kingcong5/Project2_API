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
@Table(name="user")
@Data
@ApiModel(value="user", description = "This model serves as basic model for all user entity API operations")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	@ApiModelProperty(name="user_id",
	notes="an Integer value that serves as the unique identier for user",
	required = true,
	value = "1")
	private int id;
	
	@Column(name="f_name")
	@ApiModelProperty(name="f_name",
	notes="a string value that serves as the first name for users",
	required = true,
	value = "test first name")
	private String f_name;
	
	@Column(name="l_name")
	@ApiModelProperty(name="l_name",
	notes="a string value that serves as the last name for users",
	required = true,
	value = "test last name")
	private String l_name;
	
	
	@Column(name="favorite_artist")
	@ApiModelProperty(name="favorite_artist",
	notes="a string value that serves as a favorite artist for user",
	required = true,
	value = "test favorite artist")
	private String favorite_artist;
	
	@Column(name="username")
	@ApiModelProperty(name="username",
	notes="a string value that serves as a username",
	required = true,
	value = "test username")
	private String username;
	
	
	@Column(name="password")
	@ApiModelProperty(name="password",
	notes="a string value that serves as a password",
	required = true,
	value = "test password")
	private String password;


	public User() {
		super();
	}


	public User(String f_name, String l_name, String favorite_artist, String username, String password) {
		super();
		this.f_name = f_name;
		this.l_name = l_name;
		this.favorite_artist = favorite_artist;
		this.username = username;
		this.password = password;
	}


	public User(int id, String f_name, String l_name, String favorite_artist, String username, String password) {
		super();
		this.id = id;
		this.f_name = f_name;
		this.l_name = l_name;
		this.favorite_artist = favorite_artist;
		this.username = username;
		this.password = password;
	}
	
	
}
