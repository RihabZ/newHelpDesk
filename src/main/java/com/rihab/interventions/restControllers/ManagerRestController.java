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

import com.rihab.interventions.entities.Manager;
import com.rihab.interventions.service.ManagerService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ManagerRestController {


	@Autowired
	ManagerService managerService;

@RequestMapping(path="allManagers",method = RequestMethod.GET)
public List<Manager> getAllManagers() {
	return managerService.getAllManagers();
}


@RequestMapping(value="/getbycodemanager/{codeManager}",method = RequestMethod.GET)
public Manager getMnaagerById(@PathVariable("codeManager") long codeManager) {
	return managerService.getManager(codeManager);
 }

//autorisation au admin seulement cette methode
@RequestMapping(path="/addManager",method = RequestMethod.POST)

public Manager createManager(@RequestBody Manager manager) {
	return managerService.saveManager(manager);
}


@RequestMapping(path="/updateManager",method = RequestMethod.PUT)

public Manager updateManager(@RequestBody Manager manager) {
		return managerService.updateManager(manager);
}

//autorisation au admin seulement cette methode
@RequestMapping(value="/delManager/{codeManager}",method = RequestMethod.DELETE)
@PreAuthorize("hasAuthority('ADMIN')")
public void deleteDemandeur(@PathVariable("codeManager") long codeManager)
{
	managerService.deleteManagerByCode(codeManager);
}

}
