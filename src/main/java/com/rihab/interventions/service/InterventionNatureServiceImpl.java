package com.rihab.interventions.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rihab.interventions.entities.InterventionNature;


import com.rihab.interventions.repos.InterventionNatureRepository;

@Service
public class InterventionNatureServiceImpl implements InterventionNatureService {
	
@Autowired
	InterventionNatureRepository interventionNatureRepository;



@Override
public InterventionNature saveInterventionNature(InterventionNature nature)
{
return interventionNatureRepository.save(nature);

}

@Override
public InterventionNature updateInterventionNature(InterventionNature nature) {
return interventionNatureRepository.save(nature);
}


@Override
public void deleteInterventionNature(InterventionNature nature) {
	interventionNatureRepository.delete(nature);
}


@Override
public void deleteInterventionNatureByCode(long code) {
	interventionNatureRepository.deleteById(code);
}


@Override
public InterventionNature getInterventionNature(long code) {
return interventionNatureRepository.findById(code).get();
}


@Override
public List<InterventionNature> getAllInterventionsNature() {
return interventionNatureRepository.findAll();
}



@Override
public List<InterventionNature> findByLibelle(String libelle)
{
return interventionNatureRepository.findByLibelle(libelle);
}
@Override
public  List<InterventionNature> findByLibelleContains(String libelle)
{
	return interventionNatureRepository.findByLibelleContains(libelle);
}

}

	