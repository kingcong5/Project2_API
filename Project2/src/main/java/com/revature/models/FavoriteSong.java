package com.revature.models;
import javax.persistence.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;



@Entity
@Table(name="favorite_songs")
@Data
@ApiModel(value = "FavoriteSong", description = "This model serves as basic model for all favorite song entity API operations")
public class FavoriteSong {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="fav_song_id")
	@ApiModelProperty(name="id",
	notes = "an Integer value that serves as the unique identier for any fav song entity", 
	required = true,
	value = "1") int id;
	/*
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "fav_song_song_id", referencedColumnName = "song_id") 
	private Song song;*/
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "fav_song_user_id", referencedColumnName = "user_id") 
	private User user;
	
	@Column(name="fav_song_spotify_id")
	@ApiModelProperty(name="fav_song_spotify_id",
	notes="a string value that serves as the spotify url id",
	required = true,
	value = "test fav song spotify id")
	private String spotifyId;

	public FavoriteSong() {
		super();
	}

	public FavoriteSong(User user, String spotifyId) {
		super();
		this.user = user;
		this.spotifyId = spotifyId;
	}

	public FavoriteSong(int id, User user, String spotifyId) {
		super();
		this.id = id;
		this.user = user;
		this.spotifyId = spotifyId;
	}
/*
	public FavoriteSong(Song song, User user) {
		super();
		this.song = song;
		this.user = user;
	}

	public FavoriteSong(int id, Song song, User user) {
		super();
		this.id = id;
		this.song = song;
		this.user = user;
	}
	*/
	
	
	
}
