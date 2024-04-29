package com.rihab.interventions.service;

import java.util.List;

import com.rihab.interventions.entities.Type;

public interface EquipementTypeService {
	Type saveEquipementType(Type type);
	Type updateEquipementType(Type type);
void deleteEquipementType(Type type);
 void deleteEquipementTypeByCode(String code);
 Type getEquipementType(String code);
List<Type> getAllEquipementsType();


List<Type> findByEqtyLibelle(String libelle);
List<Type> findByEqtyLibelleContains(String Libelle); 

}
