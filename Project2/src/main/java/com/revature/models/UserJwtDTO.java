package com.revature.models;
import lombok.Data;

@Data
public class UserJwtDTO {
	private int user_id;
	private String f_name;
	private String l_name;
	private String favorite_artist;
	private String username;
	private String password;
	
	public UserJwtDTO() {
		super();
	}
	
	public UserJwtDTO(String f_name, String l_name, String favorite_artist, String username, String password) {
		super();
		this.f_name = f_name;
		this.l_name = l_name;
		this.favorite_artist = favorite_artist;
		this.username = username;
		this.password = password;
	}

	public UserJwtDTO(int user_id, String f_name, String l_name, String favorite_artist, String username,
			String password) {
		super();
		this.user_id = user_id;
		this.f_name = f_name;
		this.l_name = l_name;
		this.favorite_artist = favorite_artist;
		this.username = username;
		this.password = password;
	}




	
	
	

}

