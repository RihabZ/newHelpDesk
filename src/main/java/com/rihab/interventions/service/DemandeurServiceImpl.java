package com.rihab.interventions.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rihab.interventions.entities.Demandeur;
import com.rihab.interventions.entities.Equipement;
import com.rihab.interventions.repos.DemandeurRepository;


@Service
public class DemandeurServiceImpl implements DemandeurService {
	
	@Autowired
	DemandeurRepository demandeurRepository;



@Override
public Demandeur saveDemandeur(Demandeur demandeur)
{
return demandeurRepository.save(demandeur);

}

@Override
public Demandeur updateDemandeur(Demandeur demandeur) {
return demandeurRepository.save(demandeur);
}


@Override
public void deleteDemandeur(Demandeur demandeur) {
	demandeurRepository.delete(demandeur);
}


@Override
public void deleteDemandeurByCode(long code) {
	demandeurRepository.deleteById(code);
}


@Override
public Demandeur getDemandeur(long code) {
return demandeurRepository.findById(code).get();
}


@Override
public List<Demandeur> getAllDemandeurs() {
return demandeurRepository.findAll();
}



@Override
public List<Demandeur> findByClientCodeClient(long codeClient)
{
	return demandeurRepository.findByClientCodeClient( codeClient);
			
}


@Override
public Demandeur getDemandeurByUsername(String username) {
    return demandeurRepository.findByUserUsername(username);
}





}
