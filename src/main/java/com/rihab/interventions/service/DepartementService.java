package com.rihab.interventions.service;

import java.util.List;

import com.rihab.interventions.entities.Departement;

public interface DepartementService {

	Departement saveDepartement(Departement departement);
	Departement updateDepartement(Departement Departement);
void deleteDepartement(Departement departement);
 void deleteDepartementByCodeDepart(long id);
 Departement getDepartement(long id);
List<Departement> getAllDepartements();


}
