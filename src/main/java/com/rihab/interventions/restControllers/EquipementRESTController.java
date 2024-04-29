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

import com.rihab.interventions.dto.EquipementDTO;
import com.rihab.interventions.dto.TypeDTO;
import com.rihab.interventions.entities.Equipement;
import com.rihab.interventions.entities.Famille;
import com.rihab.interventions.entities.Type;
import com.rihab.interventions.service.EquipementService;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class EquipementRESTController {

		@Autowired
		EquipementService equipementService;
	
	@RequestMapping(path="all",method = RequestMethod.GET)
	public List<Equipement> getAllEquipements() {
		return equipementService.getAllEquipements();
	}
	
	
	@RequestMapping(value="/getbyeqptcode/{eqptCode}",method = RequestMethod.GET)
	public Equipement getEquipementById(@PathVariable("eqptCode") String eqptCode) {
		return equipementService.getEquipement(eqptCode);
	 }

//autorisation au admin seulement cette methode
	@RequestMapping(path="/addeqpt",method = RequestMethod.POST)
	
	public Equipement createEquipement(@RequestBody Equipement equipement) {
		return equipementService.saveEquipement(equipement);
	}

	
	@RequestMapping(path="/updateeqpt",method = RequestMethod.PUT)
	
	public Equipement updateEquipement(@RequestBody Equipement equipement) {
			return equipementService.updateEquipement(equipement);
	}
	
	//autorisation au admin seulement cette methode
	@RequestMapping(value="/deleqpt/{eqptCode}",method = RequestMethod.DELETE)
	@PreAuthorize("hasAuthority('ADMIN')")
	public void deleteEquipement(@PathVariable("eqptCode") String eqptCode)
	{
		equipementService.deleteEquipementByCode(eqptCode);
	}

	
	@RequestMapping(value="/eqptstype/{eqtyCode}",method = RequestMethod.GET)
	public List<Equipement> getEquipementsByTypeCodeType(@PathVariable("eqtyCode") String eqtyCode) {
			return equipementService.findByTypeEqtyCode(eqtyCode);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/searchDesignation/{eqptDesignation}",method = RequestMethod.GET)
	 public List<Equipement>getEquipementByDesignation(@PathVariable("eqptDesignation") String eqptDesignation) {
        return equipementService.findByEqptDesignation(eqptDesignation);
    }
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/searchDesignationContains/{eqptDesignation}",method = RequestMethod.GET)
    public List<Equipement> getEquipementByEqptDesignationContains(@PathVariable("eqptDesignation") String eqptDesignation) {
        return equipementService.findByEqptDesignationContains(eqptDesignation);
    }

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/CodeAndDesignation")
	public List<EquipementDTO> getAllEquipementCodesAndLibelle() {
	    List<Equipement> equipements = equipementService.getAllEquipements();
	    List<EquipementDTO> equipementDTOs = new ArrayList<>();

	    for (Equipement equipement : equipements) {
	    	EquipementDTO dto = new EquipementDTO();
	        dto.setCode(equipement.getEqptCode());
	        dto.setDesignation(equipement.getEqptDesignation());
	        equipementDTOs.add(dto);
	    }

	    return equipementDTOs;
	}

}
