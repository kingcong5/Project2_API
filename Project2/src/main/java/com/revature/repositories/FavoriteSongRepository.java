package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.FavoriteSong;

public interface FavoriteSongRepository extends JpaRepository<FavoriteSong, Integer>{
	
	@Query(value="UPDATE favorite_songs SET song_id=?1, user_id=?2 WHERE fav_song_id=?3", nativeQuery = true)
	public boolean update(int song, int user, int id);
	
	@Query(value="SELECT * FROM favorite_songs WHERE fav_song_id=?1", nativeQuery = true)
	public FavoriteSong findById(int id);
	
	@Query(value="SELECT * FROM favorite_songs WHERE fav_user_id=?1", nativeQuery = true)
	public List<FavoriteSong> findAllByUser(int id);


}
