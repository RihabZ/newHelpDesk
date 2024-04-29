package com.rihab.interventions.restControllers;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import com.rihab.interventions.entities.Demandeur;
import com.rihab.interventions.entities.Equipement;
import com.rihab.interventions.service.DemandeurService;
import com.rihab.interventions.service.EquipementService;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class DemandeurRestController {

	
	
	@Autowired
	DemandeurService demandeurService;

@RequestMapping(path="allDemandeurs",method = RequestMethod.GET)
public List<Demandeur> getAllDemandeurs() {
	return demandeurService.getAllDemandeurs();
}


@RequestMapping(value="/getbycodedemandeur/{codeDemandeur}",method = RequestMethod.GET)
public Demandeur getDemandeurById(@PathVariable("codeDemandeur") long codeDemandeur) {
	return demandeurService.getDemandeur(codeDemandeur);
 }

//autorisation au admin seulement cette methode
@RequestMapping(path="/addDemandeur",method = RequestMethod.POST)

public Demandeur createDemandeur(@RequestBody Demandeur demandeur) {
	return demandeurService.saveDemandeur(demandeur);
}


@RequestMapping(path="/updateDemandeur",method = RequestMethod.PUT)

public Demandeur updateDemandeur(@RequestBody Demandeur demandeur) {
		return demandeurService.updateDemandeur(demandeur);
}

//autorisation au admin seulement cette methode
@RequestMapping(value="/delDemandeur/{codeDemandeur}",method = RequestMethod.DELETE)
@PreAuthorize("hasAuthority('ADMIN')")
public void deleteDemandeur(@PathVariable("codeDemandeur") long codeDemandeur)
{
	demandeurService.deleteDemandeurByCode(codeDemandeur);
}


@RequestMapping(value="/demandeursSociety/{codeClient}",method = RequestMethod.GET)
public List<Demandeur> getDemandeursByClientCodeClient(@PathVariable("codeClient") long codeClient) {
		return demandeurService.findByClientCodeClient(codeClient);
}
}
