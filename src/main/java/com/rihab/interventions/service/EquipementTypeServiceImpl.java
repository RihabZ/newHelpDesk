package com.rihab.interventions.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rihab.interventions.dto.EquipementDTO;
import com.rihab.interventions.entities.Equipement;
import com.rihab.interventions.entities.Type;
import com.rihab.interventions.repos.EquipementTypeRepository;
@Service
public class EquipementTypeServiceImpl implements EquipementTypeService {
	
	@Autowired
	EquipementTypeRepository equipementTypeRepository;



@Override
public Type saveEquipementType(Type type)
{
return equipementTypeRepository.save(type);

}


@Override
public Type updateEquipementType(Type type) {
return equipementTypeRepository.save(type);
}


@Override
public void deleteEquipementType(Type type) {
	equipementTypeRepository.delete(type);
}


@Override
public void deleteEquipementTypeByCode(String code) {
	equipementTypeRepository.deleteById(code);
}


@Override
public Type getEquipementType(String eqtyCode) {
return equipementTypeRepository.findById(eqtyCode).get();
}


@Override
public List<Type> getAllEquipementsType() {
return equipementTypeRepository.findAll();
}



@Override
public List<Type> findByEqtyLibelle(String libelle)
{
return equipementTypeRepository.findByEqtyLibelle(libelle);
}
@Override
public  List<Type> findByEqtyLibelleContains(String libelle)
{
	return equipementTypeRepository.findByEqtyLibelleContains(libelle);
}
	



}