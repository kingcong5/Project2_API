//package com.revature.models;
//import javax.persistence.*;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//import lombok.Data;
//
//
//
//@Entity
//@Table(name="favorite_songs")
//@Data
//@ApiModel(value = "FavoriteSong", description = "This model serves as basic model for all favorite song entity API operations")
//public class FavoriteSong {
//
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="fav_song_id")
//	@ApiModelProperty(name="id",
//	notes = "an Integer value that serves as the unique identier for any fav song entity", 
//	required = true,
//	value = "1")
//	private int id;
//	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "song_id", referencedColumnName = "song_id")
//	private Song song;
//	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
//	private Song user;
//
//	public FavoriteSong() {
//		super();
//	}
//
//	public FavoriteSong(Song song, Song user) {
//		super();
//		this.song = song;
//		this.user = user;
//	}
//
//	public FavoriteSong(int id, Song song, Song user) {
//		super();
//		this.id = id;
//		this.song = song;
//		this.user = user;
//	}
//	
//	
//	
//}
