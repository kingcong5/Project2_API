package com.revature.services;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Song;
import com.revature.repositories.SongRepository;


@Service
@Transactional
public class SongServiceImpl implements SongService{
	
	private static Logger log = Logger.getLogger(SongServiceImpl.class);
	
	@Autowired
	private SongRepository srepo;
	
	@Override
	public boolean createSong(Song song) {
		
		log.info("In service layer: Creating song: " + song);
		
		int pk = srepo.save(song).getId();
		return (pk > 0) ? true : false;
	}
	
	@Override 
	public Song getSongById(int id) {
		
		log.info("In service layer: Getting song by id: " + id);
		
		System.out.println("ID: " + id);
		return srepo.findById(id);
	}

	@Override 
	public List<Song> getAllSongs(){
		
		log.info("In service layer: Getting all songs...");
		
		return srepo.findAll();
	}
	
	@Override 
	public boolean updateSong(Song song) {
		
		log.info("In service layer: Updating song: " + song);
		
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
		
		log.info("In service layer: Deleting song: " + song);
		
		srepo.delete(song);
		return true;
	}

}
