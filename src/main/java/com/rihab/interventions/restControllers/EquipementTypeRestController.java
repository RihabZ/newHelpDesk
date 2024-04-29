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

import com.rihab.interventions.dto.TypeDTO;
import com.rihab.interventions.entities.Equipement;
import com.rihab.interventions.entities.Type;
import com.rihab.interventions.service.EquipementService;
import com.rihab.interventions.service.EquipementTypeService;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class EquipementTypeRestController {

		@Autowired
		EquipementTypeService equipementTypeService;
	
	@RequestMapping(path="allType",method = RequestMethod.GET)
	public List<Type> getAllEquipementsType() {
		return equipementTypeService.getAllEquipementsType();
	}
	
	
	@RequestMapping(path="/getbyeqtycode/{eqtyCode}",method = RequestMethod.GET)
	public Type getEquipementTypeByCode(@PathVariable("eqtyCode") String eqtyCode) {
		return equipementTypeService.getEquipementType(eqtyCode);
	 }

//autorisation au admin seulement cette methode
	@RequestMapping(path="/addeqty",method = RequestMethod.POST)
	public Type createEquipementType(@RequestBody Type type) {
		return equipementTypeService.saveEquipementType(type);
	}

	
	@RequestMapping(path="/updateeqty",method = RequestMethod.PUT)
public Type updateEquipementType(@RequestBody Type type) {
			return equipementTypeService.updateEquipementType(type);
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/deleqty/{eqtyCode}",method = RequestMethod.DELETE)
	
	public void deleteEquipementType(@PathVariable("eqtyCode") String eqtyCode)
	{
		equipementTypeService.deleteEquipementTypeByCode(eqtyCode);
	}

	
	
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/eqtyLibelle/{eqtyLibelle}",method = RequestMethod.GET)
    public List<Type> getEquipementTypeByEqtyLibelle(@PathVariable("eqtyLibelle") String libelle) {
        return equipementTypeService.findByEqtyLibelle(libelle);
    }
	//@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/eqtyLibelleContains/{libelle}",method = RequestMethod.GET)
    public List<Type> getEquipementTypeByEqtyLibelleContains(@PathVariable("libelle") String libelle) {
        return equipementTypeService.findByEqtyLibelleContains(libelle);
    }
	
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

	
	
	
	
	
}
