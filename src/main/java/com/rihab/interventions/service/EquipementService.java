package com.rihab.interventions.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rihab.interventions.dto.EquipementDTO;
import com.rihab.interventions.entities.*;


public interface EquipementService {
	Equipement saveEquipement(Equipement eqpt);
	Equipement updateEquipement(Equipement eqpt);
void deleteEquipement(Equipement eqpt);
 void deleteEquipementByCode(String code);
 Equipement getEquipement(String code);
List<Equipement> getAllEquipements();


List<Equipement> findByEqptDesignation(String desing);
List<Equipement> findByEqptDesignationContains(String desing); 

List<Equipement> findByDesingPrix ( String desing,Double prix);




List<Equipement> findByTypeEqtyCode(String eqtyCode);
List<EquipementDTO> getAllEquipementsDTOs();

}




