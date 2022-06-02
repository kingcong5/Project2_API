package com.revature.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.FavoriteSong;
import com.revature.repositories.FavoriteSongRepository;


@Service
@Transactional
public class FavoriteSongServiceImpl implements FavoriteSongService {
	
	@Autowired
	private FavoriteSongRepository frepo;

	@Override
	public boolean createFavoriteSong(FavoriteSong favoriteSong) {
		int pk = frepo.save(favoriteSong).getId();
		return (pk > 0) ? true : false;
	}

	@Override
	public FavoriteSong getSongById(int id) {
		return frepo.findById(id);
	}

	@Override
	public List<FavoriteSong> getAllFavoriteSongs() {
		return frepo.findAll();

	}

	@Override
	public boolean updateFavoriteSong(FavoriteSong favoriteSong) {
		FavoriteSong target = frepo.findById(favoriteSong.getId());
		target.setSpotifyId(favoriteSong.getSpotifyId());	
		target.setUser(favoriteSong.getUser());
		return (frepo.save(target) != null) ? true : false;
		}

	@Override
	public boolean deleteFavoriteSong(FavoriteSong favoriteSong) {
		frepo.delete(favoriteSong);
		return false;
	}

	@Override
	public List<FavoriteSong> getAllSongsByUser(int id) {
		return frepo.findAllByUser(id);
	}

}
