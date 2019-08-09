package com.qa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.qa.entities.Audit;
import com.qa.entities.SentAudit;
import com.qa.service.AuditService;

@RestController
@RequestMapping("/audit")
public class AuditController {

	private AuditService service;

	private RestTemplate rest;

	private JmsTemplate jmsTemplate;

	@Autowired
	public AuditController(AuditService service, RestTemplate rest, JmsTemplate jmsTemplate) {
		this.service = service;
		this.rest = rest;
		this.jmsTemplate = jmsTemplate;
	}
	
	private void sendToQueue(Audit audit){
        SentAudit auditToStore =  new SentAudit(audit);
        jmsTemplate.convertAndSend("AuditQueue", auditToStore);
    }

	@PostMapping(value = "/makeAudit/{user}/{poke}")
	public ResponseEntity<Audit> createAudit(@PathVariable("user") String user, @PathVariable("poke") String poke){
		
		Audit audit = new Audit();
		audit.setUsername(user);
		audit.setPokename(poke);
		
		Audit retVal = service.createAudit(audit);
		
		sendToQueue(audit);
		
		return new ResponseEntity<>(retVal, HttpStatus.CREATED);
	}
		
	

}
