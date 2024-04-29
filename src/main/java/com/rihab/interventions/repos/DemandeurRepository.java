package com.rihab.interventions.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rihab.interventions.entities.Demandeur;



public interface DemandeurRepository  extends JpaRepository<Demandeur, Long> {
	

	 
	 List<Demandeur> findByClientCodeClient(long codeClient);

	Demandeur findByUserUsername(String username);
	
}
