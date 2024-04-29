package com.rihab.interventions.service;

import java.util.List;

import com.rihab.interventions.entities.InterventionType;

public interface InterventionTypeService {
	
	InterventionType saveInterventionType(InterventionType type);
	InterventionType updateInterventionType(InterventionType type);
void deleteInterventionType(InterventionType type);
 void deleteInterventionTypeByCodeType(long code);
 InterventionType getInterventionType(long code);
List<InterventionType> getAllInterventionsType();


List<InterventionType> findByLibelleType(String libelle);
List<InterventionType> findByLibelleTypeContains(String Libelle); 

}

