package com.rihab.interventions.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.rihab.interventions.entities.Type;
@RepositoryRestResource(path = "rest")
public interface EquipementTypeRepository  extends JpaRepository<Type, String> {
	List<Type> findByEqtyLibelle(String libelle);
	 List<Type> findByEqtyLibelleContains(String libelle); 
	 
}
