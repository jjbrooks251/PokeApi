package com.qa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.entities.Audit;

public interface AuditRepository extends JpaRepository<Audit, Integer>{

}
