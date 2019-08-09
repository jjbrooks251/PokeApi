package com.qa.reciever;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.qa.entities.SentUser;
import com.qa.repository.MongoAccountRepo;

@Component
public class Reciever {
	
	@Autowired
    private MongoAccountRepo repo;

    @JmsListener(destination = "UserQueue", containerFactory = "myFactory")
    public void receiveMessage(SentUser sentUser) {
        repo.save(sentUser);
    }

}
