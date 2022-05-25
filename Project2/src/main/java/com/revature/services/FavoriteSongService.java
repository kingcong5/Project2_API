package com.revature.services;

import java.util.List;
import com.revature.models.FavoriteSong;

public interface FavoriteSongService {
	boolean createFavoriteSong(FavoriteSong favoriteSong);
	FavoriteSong getSongById(int id);
	List<FavoriteSong> getAllFavoriteSongs();
	List<FavoriteSong> getAllSongsByUser(int id);
	boolean updateFavoriteSong(FavoriteSong favoriteSong);
	boolean deleteFavoriteSong(FavoriteSong favoriteSong);
	

}
