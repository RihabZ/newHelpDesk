package com.rihab.interventions.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.rihab.interventions.entities.Famille;

@RepositoryRestResource(path = "rest")
public interface EquipementFamilleRepository extends JpaRepository<Famille, String> {

	
	List<Famille> findByEqfaLibelle(String libelle);
	 List<Famille> findByEqfaLibelleContains(String libelle); 
	 

}
