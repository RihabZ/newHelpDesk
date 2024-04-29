package com.rihab.interventions.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rihab.interventions.entities.Departement;
import com.rihab.interventions.service.DepartementService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class DepartemenetRestController {

	@Autowired
	DepartementService departementService;

@RequestMapping(path="allDepartement",method = RequestMethod.GET)
public List<Departement> getAllDepartements() {
	return departementService.getAllDepartements();
}


@RequestMapping(path="/getbycodedepart/{codeDepart}",method = RequestMethod.GET)
public Departement getDepartementById(@PathVariable("codeDepart") long codeDepart) {
	return departementService.getDepartement(codeDepart);
 }

//autorisation au admin seulement cette methode
@RequestMapping(path="/addDepart",method = RequestMethod.POST)
public Departement createDepartement(@RequestBody Departement departement) {
	return departementService.saveDepartement(departement);
}


@RequestMapping(path="/updateDepart",method = RequestMethod.PUT)
public Departement updateDepartement(@RequestBody Departement departement) {
		return departementService.updateDepartement(departement);
}


@RequestMapping(value="/delDepart/{codeDepart}",method = RequestMethod.DELETE)

public void deleteDepartement(@PathVariable("codeDepart") long codeDepart)
{
	departementService.deleteDepartementByCodeDepart(codeDepart);
}


}
