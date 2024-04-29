package com.rihab.interventions.service;

import java.util.List;

import com.rihab.interventions.entities.Demandeur;
import com.rihab.interventions.entities.Equipement;

public interface DemandeurService {

	Demandeur saveDemandeur(Demandeur demandeur);
	Demandeur updateDemandeur(Demandeur demandeur);
void deleteDemandeur(Demandeur demandeur);
 void deleteDemandeurByCode(long code);
 Demandeur getDemandeur(long code);
List<Demandeur> getAllDemandeurs();



List<Demandeur> findByClientCodeClient(long codeClient);
Demandeur getDemandeurByUsername(String username);


}
