package com.rihab.interventions.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rihab.interventions.entities.Intervention;
import com.rihab.interventions.entities.InterventionType;

import com.rihab.interventions.service.InterventionTypeService;

@RestController
@RequestMapping("/api")
@CrossOrigin


public class InterventionTypeRestController {


		@Autowired
		InterventionTypeService interventionTypeService;
	
	@RequestMapping(path="allTypeTickets",method = RequestMethod.GET)
	public List<InterventionType> getAllInterventionsType() {
		return interventionTypeService.getAllInterventionsType();
	}
	
	
	@RequestMapping(path="/getbycodeType/{codeType}",method = RequestMethod.GET)
	public InterventionType getInterventionTypeByCode(@PathVariable("codeType") long codeType) {
		return interventionTypeService.getInterventionType(codeType);
	 }

//autorisation au admin seulement cette methode
	@RequestMapping(path="/addetype",method = RequestMethod.POST)
	public InterventionType createInterventionType(@RequestBody InterventionType type) {
		return interventionTypeService.saveInterventionType(type);
	}

	
	@RequestMapping(path="/updatetype",method = RequestMethod.PUT)
public InterventionType updateInterventionType(@RequestBody InterventionType type) {
			return interventionTypeService.updateInterventionType(type);
	}
	
	
	@RequestMapping(value="/deletetype/{codeType}",method = RequestMethod.DELETE)
	
	public void deleteInterventionType(@PathVariable("codeType") long codeType)
	{
		interventionTypeService.deleteInterventionTypeByCodeType(codeType);
	}

	
	
	
	@RequestMapping(value="/libelleType/{libelleType}",method = RequestMethod.GET)
    public List<InterventionType> getInterventionTypeByLibelleType(@PathVariable("libelleType") String libelleType) {
        return interventionTypeService.findByLibelleType(libelleType);
    }
	
	@RequestMapping(value="/libelleTypeContains/{libelleType}",method = RequestMethod.GET)
    public List<InterventionType> getInterventionTypeByLibelleTypeContains(@PathVariable("libelleType") String libelleType) {
        return interventionTypeService.findByLibelleTypeContains(libelleType);
    }

	

	
	
	
	
	
}

