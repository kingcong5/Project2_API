package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Song;


@Repository
@Transactional
public interface SongRepository extends JpaRepository<Song, Integer> {
	
	@Query(value="UPDATE songs SET song_name=?1, song_artist=?2, song_album=?3, song_art=?4, song_length=?5, song_url=?6 WHERE song_id=?7 ",nativeQuery = true)
	public boolean update(String name, String artist, String album, String art, long length, String url, int id);

	@Query(value="SELECT * FROM songs WHERE song_id=?1", nativeQuery = true)
	public Song findById(int id);
	
}

