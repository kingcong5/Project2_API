package com.revature.services;
import java.util.List;
import com.revature.models.Song;

public interface SongService {
	boolean createSong(Song song);
	
	Song getSongById(int id);
	
	List<Song> getAllSongs();
	
	boolean updateSong(Song song);
	
	boolean deleteSong(Song song);

}
