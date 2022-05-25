package com.revature.controllers;

import static com.revature.util.ClientMessageUtil.CREATION_FAILED;
import static com.revature.util.ClientMessageUtil.CREATION_SUCCESSFUL;
import static com.revature.util.ClientMessageUtil.DELETION_FAILED;
import static com.revature.util.ClientMessageUtil.DELETION_SUCCESSFUL;
import static com.revature.util.ClientMessageUtil.UPDATE_FAILED;
import static com.revature.util.ClientMessageUtil.UPDATE_SUCCESSFUL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.revature.models.Song;
import com.revature.models.ClientMessage;
import com.revature.services.SongService;


@RestController
@RequestMapping("/api")
@Api(value = "SongRestController", description = "REST controller releated to song entities")
public class SongController {
	
	@Autowired 
	private SongService sserv;
	
	@ApiOperation(value="Find song by id number", notes="Provide an id to lookup specific song from the API", response = Song.class)
	@GetMapping(path = "/song")
	public @ResponseBody Song getById(@RequestParam(value = "id", name = "id") int id) {
		return sserv.getSongById(id);
		
	}
	
	@GetMapping("/songs")
	@ApiOperation(value="find all songs")
	public @ResponseBody List<Song> getAll(){
		return sserv.getAllSongs();
	}
	
	@PostMapping("/song")
	@ApiOperation(value="Create new song entity")
	public @ResponseBody ClientMessage createSong(@RequestBody Song song) {
		return sserv.createSong(song) ? CREATION_SUCCESSFUL : CREATION_FAILED;
	}
	
	@PutMapping("/song")
	@ApiOperation(value="Update song entity")
	public @ResponseBody ClientMessage updateSong(@RequestBody Song song) {
		return sserv.updateSong(song) ? UPDATE_SUCCESSFUL : UPDATE_FAILED ;
		
	}
	
	@DeleteMapping("/song")
	@ApiOperation(value="Remove song entity")
	public @ResponseBody ClientMessage deleteSong(@RequestBody Song song) {
		return sserv.deleteSong(song) ? DELETION_SUCCESSFUL : DELETION_FAILED;
	}
}
