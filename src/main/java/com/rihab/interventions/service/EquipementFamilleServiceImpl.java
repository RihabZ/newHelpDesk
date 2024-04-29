package com.rihab.interventions.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rihab.interventions.entities.Famille;
import com.rihab.interventions.repos.EquipementFamilleRepository;

@Service
public class EquipementFamilleServiceImpl implements EquipementFamilleService {
	
	@Autowired
	EquipementFamilleRepository equipementFamilleRepository;



@Override
public Famille saveEquipementFamille(Famille famille)
{
return equipementFamilleRepository.save(famille);

}

@Override
public Famille updateEquipementFamille(Famille famille) {
return equipementFamilleRepository.save(famille);
}


@Override
public void deleteEquipementFamille(Famille famille) {
	equipementFamilleRepository.delete(famille);
}


@Override
public void deleteEquipementFamilleByCode(String code) {
	equipementFamilleRepository.deleteById(code);
}


@Override
public Famille getEquipementFamille(String eqfaCode) {
return equipementFamilleRepository.findById(eqfaCode).get();
}


@Override
public List<Famille> getAllEquipementsFamille() {
return equipementFamilleRepository.findAll();
}



@Override
public List<Famille> findByEqfaLibelle(String libelle)
{
return equipementFamilleRepository.findByEqfaLibelle(libelle);
}
@Override
public  List<Famille> findByEqfaLibelleContains(String libelle)
{
	return equipementFamilleRepository.findByEqfaLibelleContains(libelle);
}
	



}