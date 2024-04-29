package com.rihab.interventions.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.rihab.interventions.entities.Equipement;
import com.rihab.interventions.entities.Type;

@RepositoryRestResource(path = "rest")
public interface EquipementRepository  extends JpaRepository<Equipement, String> {
	
	
	List<Equipement> findByEqptDesignation(String desing);
	 List<Equipement> findByEqptDesignationContains(String desing); 
	 
	 @Query("select e from Equipement e where e.eqptDesignation like %:desing and e.eqptPrix > :prix")
	 List<Equipement> findByDesingPrix (@Param("desing") String desing,@Param("prix") Double prix);

	 
	 
	 List<Equipement> findByTypeEqtyCode(String eqtyCode);
	
}
