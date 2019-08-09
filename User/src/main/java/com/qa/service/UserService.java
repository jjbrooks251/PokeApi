package com.qa.service;

import java.util.List;

import com.qa.entities.User;

public interface UserService {
	
	public List<User> getUsers();
	
	public User createUser(User user);
	
	public User findByAId(int aId);

}
