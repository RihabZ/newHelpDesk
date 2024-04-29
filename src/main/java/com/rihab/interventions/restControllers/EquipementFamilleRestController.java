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

import com.rihab.interventions.dto.FamilleDTO;
import com.rihab.interventions.dto.TypeDTO;
import com.rihab.interventions.entities.Equipement;
import com.rihab.interventions.entities.Famille;
import com.rihab.interventions.entities.Type;
import com.rihab.interventions.service.EquipementService;
import com.rihab.interventions.service.EquipementFamilleService;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class EquipementFamilleRestController {

		@Autowired
		EquipementFamilleService equipementFamilleService;
	
	@RequestMapping(path="allFamille",method = RequestMethod.GET)
	public List<Famille> getAllEquipementsFamille() {
		return equipementFamilleService.getAllEquipementsFamille();
	}
	
	
	@RequestMapping(path="/getbyeqfacode/{eqfaCode}",method = RequestMethod.GET)
	public Famille getEquipementFamilleByCode(@PathVariable("eqfaCode") String eqfaCode) {
		return equipementFamilleService.getEquipementFamille(eqfaCode);
	 }

//autorisation au admin seulement cette methode
	@RequestMapping(path="/addeqfa",method = RequestMethod.POST)
	public Famille createEquipementFamille(@RequestBody Famille famille) {
		return equipementFamilleService.saveEquipementFamille(famille);
	}

	
	@RequestMapping(path="/updateeqfa",method = RequestMethod.PUT)
public Famille updateEquipementFamille(@RequestBody Famille famille) {
			return equipementFamilleService.updateEquipementFamille(famille);
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/deleqfa/{eqfaCode}",method = RequestMethod.DELETE)
	
	public void deleteEquipementFamille(@PathVariable("eqfaCode") String eqfaCode)
	{
		equipementFamilleService.deleteEquipementFamilleByCode(eqfaCode);
	}

	
	
	
	
	@RequestMapping(value="/eqfaLibelle/{eqfaLibelle}",method = RequestMethod.GET)
    public List<Famille> getEquipementFamilleByEqfaLibelle(@PathVariable("eqfaLibelle") String libelle) {
        return equipementFamilleService.findByEqfaLibelle(libelle);
    }
	

	@GetMapping("/LibelleFam")
	public List<String> getAllEquipementFamilleLibelles() {
		List<Famille> familles = equipementFamilleService.getAllEquipementsFamille();
	  // Supposons que cette méthode récupère tous les familles existants
	    List<String> libelles = new ArrayList<>();
	    for (Famille famille : familles) {
	        libelles.add(famille.getEqfaLibelle());
	    }
	    return libelles;
	}
	
	@RequestMapping(value="/eqfaLibelleContains/{libelle}",method = RequestMethod.GET)
    public List<Famille> getEquipementFamilleByEqfaLibelleContains(@PathVariable("libelle") String libelle) {
        return equipementFamilleService.findByEqfaLibelleContains(libelle);
    }

	
	
	@GetMapping("/CodeFam")
	public List<String> getAllEquipementFamilleCodes() {
		List<Famille> familles = equipementFamilleService.getAllEquipementsFamille();
	  // Supposons que cette méthode récupère tous les types existants
	    List<String> Codes = new ArrayList<>();
	    for (Famille famille : familles) {
	    	Codes.add(famille.getEqfaCode());
	    }
	    return Codes;
	}
	
	

	@GetMapping("/CodeAndLibelleFam")
	public List<FamilleDTO> getAllEquipementFamilleCodesAndLibelle() {
	    List<Famille> familles = equipementFamilleService.getAllEquipementsFamille();
	    List<FamilleDTO> equipementFamilleDTOs = new ArrayList<>();

	    for (Famille famille : familles) {
	    	FamilleDTO dto = new FamilleDTO();
	        dto.setCode(famille.getEqfaCode());
	        dto.setLibelle(famille.getEqfaLibelle());
	        equipementFamilleDTOs.add(dto);
	    }

	    return equipementFamilleDTOs;
	}


	
	
	
	
	
}


