package com.revature.controllers;


import static com.revature.util.ClientMessageUtil.CREATION_FAILED;
import static com.revature.util.ClientMessageUtil.CREATION_SUCCESSFUL;
import static com.revature.util.ClientMessageUtil.DELETION_FAILED;
import static com.revature.util.ClientMessageUtil.DELETION_SUCCESSFUL;
import static com.revature.util.ClientMessageUtil.UPDATE_FAILED;
import static com.revature.util.ClientMessageUtil.UPDATE_SUCCESSFUL;

import java.util.List;

import org.apache.log4j.Logger;
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

import com.revature.models.FavoriteSong;
import com.revature.models.ClientMessage;
import com.revature.services.FavoriteSongService;


@RestController
@RequestMapping("/api")
@Api(value = "FavoriteSongRestController", description = "REST controller related to favorite song entities")
public class FavoriteSongController {
	
	private static Logger log = Logger.getLogger(FavoriteSongController.class);
	
	@Autowired
	private FavoriteSongService fserv;
	
	@ApiOperation(value="Find fav song by id number", notes="provide an id to lookup specific fav song from the API", response = FavoriteSong.class)
	@GetMapping(path = "/favoritesong")
	public @ResponseBody FavoriteSong getById(@RequestParam(value = "id", name = "id") int id) {
		
		log.info("Getting favorite song by id...");
		
		return fserv.getSongById(id);
	}
	
	@GetMapping("/favoritesongs")
	@ApiOperation(value="find all fav song")
	public @ResponseBody List<FavoriteSong> getAll(){
		
		log.info("Getting all favorite songs");
		
		return fserv.getAllFavoriteSongs();
	}

	@GetMapping("/favoritesongsuser")
	@ApiOperation(value="find all fav songs of a user")
	public @ResponseBody List<FavoriteSong> getUser(int id){
		
		log.info("Getting all songs by user");
		
		return fserv.getAllSongsByUser(id);
	}
	
	@PostMapping("/favoritesong")
	@ApiOperation(value="Create new fav song entity")
	public @ResponseBody ClientMessage createFavoriteSong(@RequestBody FavoriteSong favoriteSong) {
		
		log.info("Creating favorite song");
		
		return fserv.createFavoriteSong(favoriteSong) ? CREATION_SUCCESSFUL : CREATION_FAILED;
	}
	
	@PutMapping("/favoritesong")
	@ApiOperation(value="Update fav song entity")
	public @ResponseBody ClientMessage deleteSong(@RequestBody FavoriteSong favoriteSong) {
		
		log.info("Deleting favorite song...");
		
		return fserv.deleteFavoriteSong(favoriteSong) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
		
	}
	
	@DeleteMapping("/favoritesong")
	@ApiOperation(value="Remove fav song entity")
	public @ResponseBody ClientMessage deleteFavoriteSong(@RequestBody FavoriteSong favoriteSong) {
		
		log.info("Deleting favorit song...");
		
		return fserv.deleteFavoriteSong(favoriteSong) ? DELETION_SUCCESSFUL : DELETION_FAILED;
	}
	
	
	
}
