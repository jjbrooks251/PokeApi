package com.qa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.entities.User;
import com.qa.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository repo;
	
	@Autowired
	public UserServiceImpl(UserRepository repo) {
		this.repo = repo;
	}
	
	@Override
	public User createUser(User user) {
		
		return repo.save(user);
	}

	@Override
	public List<User> getUsers() {
		
		return repo.findAll();
	}

	@Override
	public User findByAId(int aId) {
		
		return repo.findByaId(aId);
	}

}
