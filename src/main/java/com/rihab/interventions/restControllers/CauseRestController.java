package com.rihab.interventions.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rihab.interventions.entities.Cause;
import com.rihab.interventions.service.CauseService;

@RestController
@RequestMapping("/api")
@CrossOrigin

public class CauseRestController {

	@Autowired
	CauseService causeService;

@RequestMapping(path="allCause",method = RequestMethod.GET)
public List<Cause> getAllCauses() {
	return causeService.getAllCauses();
}


@RequestMapping(path="/getbycodeCause/{codeCause}",method = RequestMethod.GET)
public Cause getCauseById(@PathVariable("codeCause") long codeCause) {
	return causeService.getCause(codeCause);
 }

//autorisation au admin seulement cette methode
@RequestMapping(path="/addCause",method = RequestMethod.POST)
public Cause createCause(@RequestBody Cause departement) {
	return causeService.saveCause(departement);
}


@RequestMapping(path="/updateCause",method = RequestMethod.PUT)
public Cause updateCause(@RequestBody Cause departement) {
		return causeService.updateCause(departement);
}


@RequestMapping(value="/delCause/{codeCause}",method = RequestMethod.DELETE)

public void deleteCause(@PathVariable("codeCause") long codeCause)
{
	causeService.deleteCauseByCodeCause(codeCause);
}




}
