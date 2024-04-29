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
import org.springframework.web.bind.annotation.RestController;

import com.rihab.interventions.entities.InterventionNature;
import com.rihab.interventions.service.InterventionNatureService;
@RestController
@RequestMapping("/api")
@CrossOrigin


public class InterventionNatureRestController {


		@Autowired
		InterventionNatureService interventionNatureService;
	
	@RequestMapping(path="allNature",method = RequestMethod.GET)
	public List<InterventionNature> getAllInterventionsNature() {
		return interventionNatureService.getAllInterventionsNature();
	}
	
	
	@RequestMapping(path="/getbycode/{code}",method = RequestMethod.GET)
	public InterventionNature getInterventionNatureByCode(@PathVariable("code") long code) {
		return interventionNatureService.getInterventionNature(code);
	 }

//autorisation au admin seulement cette methode
	@RequestMapping(path="/addenature",method = RequestMethod.POST)
	public InterventionNature createInterventionNaturee(@RequestBody InterventionNature nature) {
		return interventionNatureService.saveInterventionNature(nature);
	}

	
	@RequestMapping(path="/updatenature",method = RequestMethod.PUT)
public InterventionNature updateInterventionNature(@RequestBody InterventionNature nature) {
			return interventionNatureService.updateInterventionNature(nature);
	}
	
	
	@RequestMapping(value="/deletenature/{code}",method = RequestMethod.DELETE)
	
	public void deleteInterventionNature(@PathVariable("code") long code)
	{
		interventionNatureService.deleteInterventionNatureByCode(code);
	}

	
	
	
	@RequestMapping(value="/libelle/{libelle}",method = RequestMethod.GET)
    public List<InterventionNature> getInterventionNatureByLibelle(@PathVariable("libelle") String libelle) {
        return interventionNatureService.findByLibelle(libelle);
    }
	//@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/libelleContains/{libelle}",method = RequestMethod.GET)
    public List<InterventionNature> getInterventionNatureByLibelleContains(@PathVariable("libelle") String libelle) {
        return interventionNatureService.findByLibelleContains(libelle);
    }

	
	/*
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/Libelle")
	public List<String> getAllEquipementTypeLibelles() {
		List<Type> types = equipementTypeService.getAllEquipementsType();
	  // Supposons que cette méthode récupère tous les types existants
	    List<String> libelles = new ArrayList<>();
	    for (Type type : types) {
	        libelles.add(type.getEqtyLibelle());
	    }
	    return libelles;
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/CodeAndLibelle")
	public List<TypeDTO> getAllEquipementTypeCodesAndLibelle() {
	    List<Type> types = equipementTypeService.getAllEquipementsType();
	    List<TypeDTO> equipementTypeDTOs = new ArrayList<>();

	    for (Type type : types) {
	       TypeDTO dto = new TypeDTO();
	        dto.setCode(type.getEqtyCode());
	        dto.setLibelle(type.getEqtyLibelle());
	        equipementTypeDTOs.add(dto);
	    }

	    return equipementTypeDTOs;
	}

	
	*/
	
	
	
}

