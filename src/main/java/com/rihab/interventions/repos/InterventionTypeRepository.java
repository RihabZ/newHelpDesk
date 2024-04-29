package com.rihab.interventions.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rihab.interventions.entities.InterventionType;

public interface InterventionTypeRepository extends JpaRepository<InterventionType, Long> {

	List<InterventionType> findByLibelleType(String libelle);
	 List<InterventionType> findByLibelleTypeContains(String libelle); 
	 
}
