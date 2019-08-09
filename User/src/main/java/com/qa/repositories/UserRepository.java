package com.qa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByaId(int aId);
}
