package com.revature.controllers;


import static com.revature.util.ClientMessageUtil.CREATION_FAILED;
import static com.revature.util.ClientMessageUtil.CREATION_SUCCESSFUL;
import static com.revature.util.ClientMessageUtil.DELETION_FAILED;
import static com.revature.util.ClientMessageUtil.DELETION_SUCCESSFUL;
import static com.revature.util.ClientMessageUtil.UPDATE_FAILED;
import static com.revature.util.ClientMessageUtil.UPDATE_SUCCESSFUL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.ClientMessage;
import com.revature.models.FavoriteSong;
import com.revature.services.FavoriteSongService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:5500/", "http://127.0.0.1:5500/", "http://localhost:4200/", "http://127.0.0.1:5501/", "http://localhost:8080/", "http://127.0.0.1:8080/", "http://localhost:5502/", "http://127.0.0.1:5502/"})
@Api(value = "FavoriteSongRestController", description = "REST controller related to favorite song entities")
public class FavoriteSongController {
	
	@Autowired
	private FavoriteSongService fserv;
	
	@ApiOperation(value="Find fav song by id number", notes="provide an id to lookup specific fav song from the API", response = FavoriteSong.class)
	@GetMapping(path = "/favoritesong")
	public @ResponseBody FavoriteSong getById(@RequestParam(value = "id", name = "id") int id) {
		return fserv.getSongById(id);
	}
	
	@GetMapping("/favoritesongs")
	@ApiOperation(value="find all fav song")
	public @ResponseBody List<FavoriteSong> getAll(){
		return fserv.getAllFavoriteSongs();
	}

	@GetMapping("/favoritesongsuser")
	@ApiOperation(value="find all fav songs of a user")
	public @ResponseBody List<FavoriteSong> getUser(@RequestParam(value = "user_id", name = "user_id") int user_id){
		return fserv.getAllSongsByUser(user_id);
	}
	
	@PostMapping("/favoritesong")
	@ApiOperation(value="Create new fav song entity")
	public @ResponseBody ClientMessage createFavoriteSong(@RequestBody FavoriteSong favoriteSong) {
		return fserv.createFavoriteSong(favoriteSong) ? CREATION_SUCCESSFUL : CREATION_FAILED;
	}
	
	@PutMapping("/favoritesong")
	@ApiOperation(value="Update fav song entity")
	public @ResponseBody ClientMessage deleteSong(@RequestBody FavoriteSong favoriteSong) {
		return fserv.deleteFavoriteSong(favoriteSong) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
		
	}
	
	@DeleteMapping("/favoritesong")
	@ApiOperation(value="Remove fav song entity")
	public @ResponseBody ClientMessage deleteFavoriteSong(@RequestBody FavoriteSong favoriteSong) {
		return fserv.deleteFavoriteSong(favoriteSong) ? DELETION_SUCCESSFUL : DELETION_FAILED;
	}
	
	
	
}
