package com.rihab.interventions.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rihab.interventions.entities.InterventionNature;

public interface InterventionNatureRepository  extends JpaRepository<InterventionNature, Long> {

	List<InterventionNature> findByLibelle(String libelle);
	 List<InterventionNature> findByLibelleContains(String libelle); 
	 
}
