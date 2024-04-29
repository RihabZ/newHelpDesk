package com.rihab.interventions.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rihab.interventions.entities.Demandeur;
import com.rihab.interventions.entities.Departement;
import com.rihab.interventions.entities.Technicien;

import com.rihab.interventions.repos.TechnicienRepository;

@Service
public  class TechnicienServiceImpl implements TechnicienService{

	
	@Autowired
	TechnicienRepository technicienRepository;



@Override
public Technicien saveTechnicien(Technicien demandeur)
{
return technicienRepository.save(demandeur);

}

@Override
public Technicien updateTechnicien(Technicien demandeur) {
return technicienRepository.save(demandeur);
}


@Override
public void deleteTechnicien(Technicien demandeur) {
	technicienRepository.delete(demandeur);
}


@Override
public void deleteTechnicienByCode(long code) {
	technicienRepository.deleteById(code);
}


@Override
public Technicien getTechnicien(long code) {
return technicienRepository.findById(code).get();
}


@Override
public List<Technicien> getAllTechniciens() {
return technicienRepository.findAll();
}

@Override
public List<Technicien> findByDepartementCodeDepart(long codeDepart)
{
	return technicienRepository.findByDepartementCodeDepart( codeDepart);
			
}


@Override
public Technicien getTechnicienByUsername(String username) {
    return technicienRepository.findByUserUsername(username);
}





}


