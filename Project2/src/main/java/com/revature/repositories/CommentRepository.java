package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Comment;

@Repository
@Transactional
public interface CommentRepository extends JpaRepository<Comment, Integer>{

}
