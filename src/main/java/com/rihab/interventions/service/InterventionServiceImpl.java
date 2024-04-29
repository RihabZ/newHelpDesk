package com.rihab.interventions.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rihab.interventions.dto.InterventionDTO;
import com.rihab.interventions.entities.Equipement;
import com.rihab.interventions.entities.Intervention;
import com.rihab.interventions.entities.Ticket;
import com.rihab.interventions.repos.InterventionRepository;
import com.rihab.interventions.repos.TicketRepository;

@Service
public class InterventionServiceImpl implements InterventionService {
	
	@Autowired
	InterventionRepository interventionRepository;



@Override
public Intervention saveIntervention(Intervention intervention)
{
return interventionRepository.save(intervention);

}

@Override
public Intervention updateIntervention(Intervention intervention) {
return interventionRepository.save(intervention);
}


@Override
public void deleteIntervention(Intervention intervention) {
	interventionRepository.delete(intervention);
}


@Override
public void deleteInterventionById(long id) {
	interventionRepository.deleteById(id);
}


@Override
public Intervention getIntervention(long id) {
return interventionRepository.findById(id).get();
}


@Override
public List<Intervention> getAllInterventions() {
return interventionRepository.findAll();
}



@Override
public List<Intervention> findByInterventionTypeCodeType(long code)
{
return interventionRepository.findByInterventionTypeCodeType( code);

}

@Override
public Intervention findByTicketInterCode(String interCode) {
	return interventionRepository.findByTicketInterCode(interCode);
	
}

/*
@Override
public List<Intervention> findByTechnicienCodeTechnicien(long codeTechnicien)
{
	return interventionRepository.findByTechnicienCodeTechnicien( codeTechnicien);
			
}
*/



}
