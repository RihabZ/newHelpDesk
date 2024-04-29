package com.rihab.interventions.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rihab.interventions.entities.Departement;
import com.rihab.interventions.entities.Equipement;
import com.rihab.interventions.entities.Famille;
import com.rihab.interventions.repos.DepartementRepository;
import com.rihab.interventions.repos.EquipementFamilleRepository;

@Service
public class DepartementServiceImpl implements DepartementService {
	
	@Autowired
	DepartementRepository departementRepository;



@Override
public Departement saveDepartement(Departement departement)
{
return departementRepository.save(departement);

}

@Override
public Departement updateDepartement(Departement departement) {
return departementRepository.save(departement);
}


@Override
public void deleteDepartement(Departement departement) {
	departementRepository.delete(departement);
}


@Override
public void deleteDepartementByCodeDepart(long id) {
	departementRepository.deleteById(id);
}


@Override
public Departement getDepartement(long id) {
return departementRepository.findById(id).get();
}


@Override
public List<Departement> getAllDepartements() {
return departementRepository.findAll();
}





}
