package com.revature.services;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.FavoriteSong;
import com.revature.repositories.FavoriteSongRepository;


@Service
@Transactional
public class FavoriteSongServiceImpl implements FavoriteSongService {
	
	private static Logger log = Logger.getLogger(FavoriteSongServiceImpl.class);
	
	@Autowired
	private FavoriteSongRepository frepo;

	@Override
	public boolean createFavoriteSong(FavoriteSong favoriteSong) {
		
		log.info("In service layer: Creating favorite song: " + favoriteSong);
		
		int pk = frepo.save(favoriteSong).getId();
		return (pk > 0) ? true : false;
	}

	@Override
	public FavoriteSong getSongById(int id) {
		
		log.info("In service layer: Getting song by id: " + id);
		
		return frepo.findById(id);
	}

	@Override
	public List<FavoriteSong> getAllFavoriteSongs() {
		
		log.info("In service layer: Getting all favorite songs...");
		
		return frepo.findAll();

	}

	@Override
	public boolean updateFavoriteSong(FavoriteSong favoriteSong) {
		
		log.info("In service layer: Updating favorite song: " + favoriteSong);
		
		FavoriteSong target = frepo.findById(favoriteSong.getId());
		target.setSong(favoriteSong.getSong());	
		target.setUser(favoriteSong.getUser());
		return (frepo.save(target) != null) ? true : false;
		}

	@Override
	public boolean deleteFavoriteSong(FavoriteSong favoriteSong) {
		
		log.info("In service layer: Deleting favorite song: " + favoriteSong);
		
		frepo.delete(favoriteSong);
		return false;
	}

	@Override
	public List<FavoriteSong> getAllSongsByUser(int id) {
		
		log.info("In service layer: Getting all songs by user: " + id);
		
		return frepo.findAllByUser(id);
	}

}
