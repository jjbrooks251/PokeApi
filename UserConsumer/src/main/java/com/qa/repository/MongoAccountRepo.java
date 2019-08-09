package com.qa.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.qa.entities.SentUser;

public interface MongoAccountRepo extends MongoRepository<SentUser, Integer>{

}
