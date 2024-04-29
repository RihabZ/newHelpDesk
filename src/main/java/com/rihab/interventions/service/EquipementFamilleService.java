package com.rihab.interventions.service;

import java.util.List;
import com.rihab.interventions.entities.Famille;




public interface EquipementFamilleService {
	Famille saveEquipementFamille(Famille famille);
	
	Famille updateEquipementFamille(Famille famille);
	
void deleteEquipementFamille(Famille famille);

 void deleteEquipementFamilleByCode(String code);
 
 Famille getEquipementFamille(String code);
 
List<Famille> getAllEquipementsFamille();


List<Famille> findByEqfaLibelle(String libelle);


List<Famille> findByEqfaLibelleContains(String Libelle); 

}
