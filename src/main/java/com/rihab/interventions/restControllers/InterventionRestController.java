package com.rihab.interventions.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rihab.interventions.dto.InterventionDTO;
import com.rihab.interventions.entities.Equipement;
import com.rihab.interventions.entities.Intervention;
import com.rihab.interventions.service.InterventionService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class InterventionRestController {

	
	@Autowired
	InterventionService interventionService;

	@PreAuthorize("hasAuthority('MANAGER')")
@RequestMapping(path="allInterventions",method = RequestMethod.GET)
public List<Intervention> getAllInterventions() {
	return interventionService.getAllInterventions();
}


@RequestMapping(value="/getById/{idIntervention}",method = RequestMethod.GET)
public Intervention getInterventionById(@PathVariable("idIntervention") long idIntervention) {
	return interventionService.getIntervention(idIntervention);
 }

//autorisation au admin seulement cette methode
@PreAuthorize("hasAuthority('TECHNICIEN')")
@RequestMapping(path="/addInter",method = RequestMethod.POST)
public Intervention createIntervention(@RequestBody Intervention intervention) {
	return interventionService.saveIntervention(intervention);
}

@PreAuthorize("hasAuthority('TECHNICIEN')")
@RequestMapping(path="/updateInter",method = RequestMethod.PUT)
public Intervention updateIntervention(@RequestBody Intervention intervention) {
		return interventionService.updateIntervention(intervention);
}

@PreAuthorize("hasAuthority('MANAGER')")
@RequestMapping(value="/deleteInter/{idIntervention}",method = RequestMethod.DELETE)

public void deleteIntervention(@PathVariable("idIntervention") long idIntervention)
{
	interventionService.deleteInterventionById(idIntervention);
}




@RequestMapping(value="/interType/{codeTpe}",method = RequestMethod.GET)
public List<Intervention> getInterventionsByInterventionTypeCode(@PathVariable("codeType") long codeType) {
		return interventionService.findByInterventionTypeCodeType(codeType);
}



@RequestMapping(value="/getbyTicket/{interCode}",method = RequestMethod.GET)
public Intervention getByTicketInterCode(@PathVariable("interCode") String interCode) {
	return interventionService.findByTicketInterCode(interCode);
 }
/*
@PreAuthorize("hasAuthority('MANAGER')")
@RequestMapping(value="/IntervsTech/{codeTechicien}",method = RequestMethod.GET)
public List<Intervention> getInterventionsByTechnicienCodeTechnicien(@PathVariable("codeTechicien") long codeTechicien) {
		return interventionService.findByTechnicienCodeTechnicien(codeTechicien);
}
*/

}