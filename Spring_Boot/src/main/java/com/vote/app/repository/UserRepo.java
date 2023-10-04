package com.vote.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vote.app.model.User;



@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	User findByUsername(String username);
}
