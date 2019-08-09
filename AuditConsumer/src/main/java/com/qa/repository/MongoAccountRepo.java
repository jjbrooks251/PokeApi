package com.qa.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.qa.entities.SentAudit;

public interface MongoAccountRepo extends MongoRepository<SentAudit, Integer>{

}
