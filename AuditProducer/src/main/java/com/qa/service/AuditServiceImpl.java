package com.qa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.entities.Audit;
import com.qa.repositories.AuditRepository;

@Service
public class AuditServiceImpl implements AuditService{

	private AuditRepository repo;
	
	@Autowired
	public AuditServiceImpl(AuditRepository repo) {
		this.repo = repo;
	}
	
	@Override
	public Audit createAudit(Audit audit) {
		
		return repo.save(audit);
	}

}
