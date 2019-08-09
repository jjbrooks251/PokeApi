package com.qa.reciever;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.qa.entities.SentAudit;
import com.qa.repository.MongoAccountRepo;

@Component
public class Reciever {
	
	@Autowired
    private MongoAccountRepo repo;

    @JmsListener(destination = "AuditQueue", containerFactory = "myFactory")
    public void receiveMessage(SentAudit sentAudit) {
        repo.save(sentAudit);
    }

}
