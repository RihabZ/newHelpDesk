package com.rihab.interventions.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rihab.interventions.entities.InterventionType;
import com.rihab.interventions.repos.InterventionTypeRepository;
@Service
public class InterventionTypeServiceImpl implements InterventionTypeService {
	
@Autowired
	InterventionTypeRepository interventionTypeRepository;



@Override
public InterventionType saveInterventionType(InterventionType type)
{
return interventionTypeRepository.save(type);

}

@Override
public InterventionType updateInterventionType(InterventionType type) {
return interventionTypeRepository.save(type);
}


@Override
public void deleteInterventionType(InterventionType type) {
	interventionTypeRepository.delete(type);
}


@Override
public void deleteInterventionTypeByCodeType(long code) {
	interventionTypeRepository.deleteById(code);
}


@Override
public InterventionType getInterventionType(long code) {
return interventionTypeRepository.findById(code).get();
}


@Override
public List<InterventionType> getAllInterventionsType() {
return interventionTypeRepository.findAll();
}



@Override
public List<InterventionType> findByLibelleType(String libelle)
{
return interventionTypeRepository.findByLibelleType(libelle);
}
@Override
public  List<InterventionType> findByLibelleTypeContains(String libelle)
{
	return interventionTypeRepository.findByLibelleTypeContains(libelle);
}

}

	