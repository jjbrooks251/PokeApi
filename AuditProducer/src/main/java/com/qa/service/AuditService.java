package com.qa.service;

import java.util.List;

import com.qa.entities.Audit;

public interface AuditService {

	public Audit createAudit(Audit audit);
	
	public List<Audit> getAudits();
	
}
