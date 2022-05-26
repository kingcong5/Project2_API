package com.revature.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Song;
import com.revature.repositories.SongRepository;


@Service
@Transactional
public class SongServiceImpl implements SongService{
	
	@Autowired
	private SongRepository srepo;
	
	@Override
	public boolean createSong(Song song) {
		int pk = srepo.save(song).getId();
		return (pk > 0) ? true : false;
	}
	
	@Override 
	public Song getSongById(int id) {
		System.out.println("ID: " + id);
		return srepo.findById(id);
	}

	@Override 
	public List<Song> getAllSongs(){
		return srepo.findAll();
	}
	
	@Override 
	public boolean updateSong(Song song) {
		Song target = srepo.findById(song.getId());
		
		target.setAlbum(song.getAlbum());
		target.setArt(song.getArt());
		target.setArtist(song.getArtist());
		target.setLength(song.getLength());
		target.setName(song.getName());
		target.setUrl(song.getUrl());
		return (srepo.save(target) != null) ? true : false;
		
	}
	
	@Override 
	public boolean deleteSong(Song song) {
		srepo.delete(song);
		return true;
	}

}
