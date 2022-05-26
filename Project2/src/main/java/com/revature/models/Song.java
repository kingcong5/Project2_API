package com.revature.models;
import javax.persistence.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name="songs")
@Data
@ApiModel(value="Song", description = "This model serves as basic model for all song entity API operations")
public class Song {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="song_id")
	@ApiModelProperty(name="song_id",
	notes="an Integer value that serves as the unique identier for any song entity",
	required = true,
	value = "1") 
	private int id;
	
	@Column(name="song_name")
	@ApiModelProperty(name="song_name",
	notes="a string value that serves as the name of the song",
	required = true,
	value = "test song name") 
	private String name;
	
	@Column(name="song_artist")
	@ApiModelProperty(name="song_artist",
	notes="a string value that serves as the artist name of the song",
	required = true,
	value = "test song artist")
	private String artist;
	
	@Column(name="song_album")
	@ApiModelProperty(name="song_album",
	notes="a string value that serves as the album name of the song",
	required = true,
	value = "test song album")
	private String album;
	
	@Column(name="song_album_art")
	@ApiModelProperty(name="song_album_art",
	notes="a string value that serves as the album art url of the song",
	required = true,
	value = "test song art")
	private String art;

	@Column(name="song_length")
	@ApiModelProperty(name="song_length",
	notes="an long int value that serves as the length in ms of the song",
	required = true,
	value = "1")
	private long length;
	
	@Column(name="song_spotify_url")
	@ApiModelProperty(name="song_spotify_url",
	notes="a string value that serves as the song spotify url",
	required = true,
	value = "test song url")
	private String url;
	
	
	public Song() {
		super();
	}


	public Song( String name, String artist, String album, String art, long length, String url) {
		super();
		this.name = name;
		this.artist = artist;
		this.album = album;
		this.art = art;
		this.length = length;
		this.url = url;
	}


	public Song(int id, String name, String artist, String album, String art, long length, String url) {
		super();
		this.id = id;
		this.name = name;
		this.artist = artist;
		this.album = album;
		this.art = art;
		this.length = length;
		this.url = url;
	}
	
	

}
