package com.revature.repositories;



import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.revature.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	// need to add logger that can be used for interfaces
	
	
	// update user info by user_id
	@Query(value="Update User PUT f_name=?1 l_name=?2 favorite_artist=?3 username=?4 WHERE comment_id=?5", nativeQuery = true)
	public boolean updateUser(String f_name, String l_name, String favorite_artist, String username);
	
	
	
	// get all user info from user_id
	@Query(value="SELECT * FROM users where user_id=?1", nativeQuery = true)
	public User findById(int user_id);
	
	//update only user password by user_id
	@Query(value="UPDATE users SET password=?1, WHERE user_id=?2", nativeQuery = true)
	public boolean updateUserPassword(String password, int user_id);

	
}


