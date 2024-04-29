package com.rihab.interventions.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rihab.interventions.dto.InterventionDTO;
import com.rihab.interventions.entities.Equipement;
import com.rihab.interventions.entities.Intervention;


public interface InterventionRepository extends JpaRepository<Intervention, Long> {

	 List<Intervention>findByInterventionTypeCodeType(long code);

	

	Intervention findByTicketInterCode(String interCode);

	 
	// List<Intervention> findByTechnicienCodeTechnicien(long codeTechnicien);
	
}
