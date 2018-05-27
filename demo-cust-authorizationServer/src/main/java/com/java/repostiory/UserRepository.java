package com.java.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
}
